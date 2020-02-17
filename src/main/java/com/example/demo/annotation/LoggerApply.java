package com.example.demo.annotation;

import org.springframework.stereotype.Component;

/**
 * 调用切面的类
 * */

@Component
public class LoggerApply {

    @MyAnnotation(module = "1234567890")
    public void test(String event) throws Exception{
        System.out.println("应用业务运行ing...............");
        throw new Exception();
    }

}
