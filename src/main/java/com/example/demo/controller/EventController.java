package com.example.demo.controller;

import com.example.demo.entity.AjaxResponse;
import com.example.demo.eventlisteners.EmailEvent;
import com.example.demo.eventlisteners.SmessageEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.annotation.ApplicationScope;

@RestController
public class EventController {

    @Autowired
    ApplicationContext applicationContext;

    @GetMapping("/SMessageEvent")
    public AjaxResponse SMessageEvent() {
        applicationContext.publishEvent(new SmessageEvent("测试短信发送"));
        return AjaxResponse.success();
    }

    @GetMapping("/EmailEvent")
    public AjaxResponse EmailEvent() {
        applicationContext.publishEvent(new EmailEvent("测试邮件发送"));
        return AjaxResponse.success();
    }
}
