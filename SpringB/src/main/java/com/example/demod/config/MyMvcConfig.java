package com.example.demod.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MyMvcConfig implements WebMvcConfigurer {
    @Override//视图跳转
    public void addViewControllers(ViewControllerRegistry registry) {
        //添加一个视图控制跳转到指定页面
        registry.addViewController("/user/jia").setViewName("index");
        registry.addViewController("/index.html").setViewName("index");
        registry.addViewController("/main").setViewName("dashboard");
    }
    @Bean//自定义的国际化组件就生效了
    public LocaleResolver localeResolver(){
        System.out.println("进入了国际化bean");
        return new MyLocaleResolver();
    }

    @Override //添加拦截器
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginInterceptor()).addPathPatterns("/**").excludePathPatterns("/index.html",
                "/","/user/login","/static/**");
    }
}
