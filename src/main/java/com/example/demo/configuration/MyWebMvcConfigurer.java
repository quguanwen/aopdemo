package com.example.demo.configuration;

import com.example.demo.listenerfilterintercept.CustomIntercept;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MyWebMvcConfigurer implements WebMvcConfigurer {

    //TODO 注册拦截器规则,多个拦截器按照注册顺序执行
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //TODO 对所有的请求路径都使用该拦截器拦截
        registry.addInterceptor(getHandlerInterceptor()).addPathPatterns("/**");
    }

    //TODO 将自定义拦截器创建并注入ioc
    @Bean
    public static HandlerInterceptor getHandlerInterceptor(){
        return new CustomIntercept();
    }

}
