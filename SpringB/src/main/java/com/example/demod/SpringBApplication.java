package com.example.demod;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.demod.dao")
public class SpringBApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBApplication.class, args);
    }

}
