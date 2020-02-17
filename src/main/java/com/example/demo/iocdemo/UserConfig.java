package com.example.demo.iocdemo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class UserConfig {

    /**
     * 注入到了IOC容器
     * */
    @Bean("User1")
    public User createUser(){
        return new User("qgw","25");
    }
}
