package com.example.demo.controller;

import com.example.demo.entity.AjaxResponse;
import com.example.demo.service.ExceptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExceptionController {

    @Autowired
    ExceptionService exceptionService;

    @GetMapping("/known")
    public AjaxResponse known() {
        exceptionService.test1(12);
        return AjaxResponse.success();
    }

    @GetMapping("/unknown")
    public AjaxResponse unknown() {
        exceptionService.test();
        return AjaxResponse.success();
    }

}
