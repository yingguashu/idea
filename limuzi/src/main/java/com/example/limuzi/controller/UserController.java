package com.example.limuzi.controller;

import com.example.limuzi.domian.User;
import net.sf.jsqlparser.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;

@Controller
public class UserController {

    @RequestMapping(value = "/user",method = RequestMethod.GET)
    public String getUser(Model model, HttpSession session){
        ArrayList<User> userList=new ArrayList<>();
        for (long i=0;i<5;i++){
           User user=new User();
            user.setId(i);
            user.setName("李玄子");
            user.setAge("18");
            userList.add(user);
        }
        session.setAttribute("user",userList);
        return "user";
    }
}
