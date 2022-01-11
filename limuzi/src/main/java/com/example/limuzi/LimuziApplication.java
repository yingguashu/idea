package com.example.limuzi;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/**
 * 热加载。热更新
 * 1,ctrl+shift+a -->搜索Registry,找到Registry...,是带三个点的,然后找到compile.automake.allow.when.app.running,勾选
 * 2,快捷键Ctrl+F9热加载
 */

@SpringBootApplication
@MapperScan("com.example.limuzi.dao")
@MapperScan("com.baomidou.mybatisplus.samples.quickstart.mapper")
public class LimuziApplication {

    public static void main(String[] args) {
        SpringApplication.run(LimuziApplication.class, args);
    }


}
