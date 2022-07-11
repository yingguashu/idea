package com.example.demod.config;

import org.springframework.web.servlet.HandlerInterceptor;

public class LoginInterceptor implements HandlerInterceptor {
//    @Override
//    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//        //登录成功之后获取用户信息session
//        Object loginUser = request.getSession().getAttribute("loginUser");
//        System.out.println("QAQ"+loginUser);
//        if (loginUser==null){//没有登录
//            request.setAttribute("msg","没有登录，请先登录");
//            request.getRequestDispatcher("/index.html").forward(request,response);
////            response.sendRedirect("index.html");
//            return false;
//        }else {
//            return true;
//        }
//
//    }
}
