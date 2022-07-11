package com.example.demod.pojo;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

//员工表
@Data
@NoArgsConstructor
public class Employee {
    private Integer id;//id
    private String lastname;//名字
    private String email;//邮箱
    private Integer gender;//性别
    private Department department;
    @DateTimeFormat(pattern="yyyy-MM-dd HH-mm-ss")
    private Date bith;

    public Employee(Integer id, String lastname, String email, Integer gender, Department department) {
        this.id = id;
        this.lastname = lastname;
        this.email = email;
        this.gender = gender;
        this.department = department;
        //默认的创建日期
        this.bith =new Date();
    }


}
