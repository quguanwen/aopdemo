package com.example.demo.controller;

import com.example.demo.entity.AjaxResponse;
import com.example.demo.entity.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * 测试校验器+全局统一异常处理的报错
 * */

@RestController
public class ValidationController {

    @GetMapping("/validation")
    public AjaxResponse validation(@Valid @RequestBody User user) {
        return AjaxResponse.success(user);
    }
}
