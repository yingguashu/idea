package com.example.limuzi.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.limuzi.domian.Singer;
import com.example.limuzi.service.SingerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.Iterator;
import java.util.List;

@Controller
@RequestMapping("/geshou")
public class geshouController {

    @Autowired
    private SingerService singerService;


    @RequestMapping("/allSinger")
    public String allSinger(HttpSession session){
        List<Singer> singer= singerService.allSinger();
        session.setAttribute("singer", JSONObject.toJSONStringWithDateFormat(singer,"yyyy/MM/dd"));
        String all = JSONObject.toJSONStringWithDateFormat(singer, "yyyy/MM/dd");
        System.out.println(all);
        Iterator<Singer> it=singer.iterator();
        while (it.hasNext()){
            System.out.println(it.next());
        }
        return "geshou";

    }

}
