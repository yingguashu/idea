package com.example.demod.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

    @RequestMapping(value = "/user/login")
    public String login(HttpSession session, @RequestParam("username")String username, @RequestParam("password")String password, Model model){
        System.out.println(username);
        System.out.println(password);
        if(!StringUtils.isEmpty(username) && "123456".equals(password)){
            session.setAttribute("loginUser",username);
            System.out.println("登录名是:"+username);
            return "redirect:/main";
        }else {
            model.addAttribute("msg","用户名或密码输入错误");
            return "index";
        }
    }
}