package com.dawei.boot.boothelloword.config;

import com.dawei.boot.boothelloword.interceptors.UserLoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author Dawei 2019/3/14
 * Boot 用于配置Mvc属性所使用的类
 */
@Configuration
public class BootMvcConfiguration implements WebMvcConfigurer {


    //拦截器配置
    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        /*
         * 配置登陆校验拦截器
         * 拦截除了游客访问和登陆的所有請求
         */
        registry.addInterceptor(new UserLoginInterceptor())
                .addPathPatterns("/**/**")
                .excludePathPatterns("/user/login", "/**/guest/**");

    }

    //跨域访问配置
    @Override
    public void addCorsMappings(CorsRegistry registry) {

    }

    //格式化
    @Override
    public void addFormatters(FormatterRegistry registry) {

    }



}
