package com.example.demo.controller;


import com.example.demo.annotation.LoggerApply;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AspectController {

    @Autowired
    LoggerApply loggerApply;

    @GetMapping("aspectTest")
    public void aTest() {
        try {
            loggerApply.test("hello");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
