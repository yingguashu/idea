package com.example.demod.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Arrays;


@Controller
public class HelloController {

    @RequestMapping(value = "/user/hello",method = RequestMethod.GET)
    public String hello(Model model) {
        model.addAttribute("msg","转发到hello页面成功");
        model.addAttribute("users", Arrays.asList("第一个","第二个","第三个"));
        return "hello";
    }

}
