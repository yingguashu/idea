package com.example.demod;

import com.example.demod.dao.AdminMapper;
import com.example.demod.pojo.Admin;
import com.example.demod.pojo.Dog;
import com.example.demod.pojo.Person;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class DemoApplicationTests {

    @Autowired
    private AdminMapper adminMapper;

    @Autowired
    private Dog dog;
    @Autowired
    private Person person;


    @Test
    void contextLoads() {
//        System.out.println(dog);
        System.out.println(person);
    }

    @Test //查询
    void test1(){
        List<Admin> admins = adminMapper.finAll();
        System.out.println(admins);
    }

    @Test //增加
    void test2(){
        Admin admin1 = new Admin();
        admin1.setName("测试用的2");
        admin1.setPassword("1223www");
        admin1.setDateTime(23456799789L);
        admin1.setPerms("user");
//        admin1.setUpdateTime(new Date());
        Integer add = adminMapper.add(admin1);
        System.out.println(add==1?"添加成功":"添加失败");
    }

}
