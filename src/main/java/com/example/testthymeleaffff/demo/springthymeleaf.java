package com.example.testthymeleaffff.demo;

import com.example.testthymeleaffff.conteoller.LoginHandlerInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.nio.file.Watchable;


@Configuration
public class springthymeleaf extends WebMvcConfigurerAdapter {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/index").setViewName("index");
        registry.addViewController("/main").setViewName("dashboard");
    }
    @Bean
    public  WebMvcConfigurerAdapter addweb(){
        WebMvcConfigurerAdapter addpate =new WebMvcConfigurerAdapter() {


            //注册拦截器
            @Override
            public void addInterceptors(InterceptorRegistry registry) {
                //springboot已经做好静态资源的映射了，所以这里不需要再排除静态资源
                registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/**")
                        .excludePathPatterns("/index","/user/login","/","/css/**","/js/**","/img/**");
                //addPathPatterns():添加拦截器 addPathPatterns（/**）拦截所有多层访问路径
                //excludePathPatterns:排除
            }
        };
        return addpate;
    }
}
