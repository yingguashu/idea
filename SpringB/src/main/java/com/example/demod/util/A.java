package com.example.demod.util;

import com.alibaba.excel.EasyExcel;
import com.example.demod.pojo.Admin;

import java.text.SimpleDateFormat;
import java.util.*;

public class A {
    public static void main(String[] args) {
        String strfile="E:\\123\\write.xlsx";

        Set<String> excludeField = new HashSet<>();
        excludeField.add("id");
        EasyExcel.write(strfile, Admin.class)
                .excludeColumnFiledNames(excludeField).sheet("管理员信息").doWrite(getData());

        SimpleDateFormat format = new SimpleDateFormat("yyyy:MM:dd hh:mm:ss");
        long lo=1651509675046L;
        String format1 = format.format(new Date(lo));
        System.out.println(format1);
    }

    public static List<Admin> getData(){
        List<Admin> list=new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Admin admin = new Admin();
            admin.setId(i);
            admin.setName("测试"+i);
            admin.setPassword("123qwe"+i);
            admin.setDateTime(1651509675046L);
//            admin.setUpdateTime(new Date());
            admin.setDeleted(1);
            list.add(admin);
        }
        return list;
    }
}
