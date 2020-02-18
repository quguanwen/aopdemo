package com.example.demo.controller;

import com.example.demo.entity.AjaxResponse;
import com.example.demo.iocdemo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IOController {

    @Autowired
    private ApplicationContext applicationContext;

    @GetMapping("/getUser")
    public AjaxResponse getUser() {
        //从IOC容器中获取指定名称的对象
        User user = (User) applicationContext.getBean("User1");
        return AjaxResponse.success(user);
    }


}
