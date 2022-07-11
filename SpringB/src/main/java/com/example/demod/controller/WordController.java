package com.example.demod.controller;

import com.alibaba.excel.EasyExcel;
import com.example.demod.pojo.Admin;
import com.example.demod.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.URLEncoder;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@ResponseBody
public class WordController {

    @Autowired
    private AdminService adminService;

    @GetMapping("/word")
    public String word(){
        return "word!";
    }

    @GetMapping("/excl")
    public String excel(HttpServletRequest request,
                        HttpServletResponse response) throws Exception {
        // 设置响应头
        response.setContentType("application/vnd.ms-excel");
        response.setCharacterEncoding("utf-8");
        // 设置防止中文名乱码
        String filename = URLEncoder.encode("员工信息", "utf-8");
        // 文件下载方式(附件下载还是在当前浏览器打开)
        response.setHeader("Content-disposition", "attachment;filename=" +
                filename + ".xlsx");
        // 构建写入到excel文件的数据
        List<Admin> list = adminService.finAll();
//        System.out.println(list);
        Set<String> excludeField = new HashSet<>();
        excludeField.add("id");
        try {
            EasyExcel.write(response.getOutputStream(), Admin.class)
                    .excludeColumnFiledNames(excludeField).sheet("管理员信息").doWrite(list);
            return "下载成功";
        }catch (Exception e){
            return "下载失败";
        }

    }

    @GetMapping("/add")
    public String addAdmin(Admin admin){
//        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh-mm-ss");
        Admin admin1 = new Admin();
        admin1.setName("测试用的");
        admin1.setPassword("1223www");
//        admin1.setDateTime(new Date().getTime());
        admin1.setPerms("user");
        Integer add = adminService.add(admin1);
        if (add!=1){
            return "添加失败";
        }else {
            return "添加成功";
        }
    }
}
