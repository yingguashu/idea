package com.example.demod.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.LocaleResolver;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

@Configuration
@Component
public class MyLocaleResolver implements LocaleResolver {

    @Override
    public Locale resolveLocale(HttpServletRequest Request) {
        System.out.println("进入了国际化请求");
        String parameter = Request.getParameter("l");
        Locale locale = Locale.getDefault();//如果没有就使用默认的
        //如果请求的链接携带了国际化的参数，就开始判断
        if (!StringUtils.isEmpty(parameter)){
            //zh_CN
            String[] split = parameter.split("_");
            //国家，地区
            locale=new Locale(split[0], split[1]);
        }
        return locale;
    }

    @Override
    public void setLocale(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Locale locale) {

    }
}
