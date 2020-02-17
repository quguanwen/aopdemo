package com.example.demo.service;

import com.example.demo.configuration.exception.CustomException;
import com.example.demo.configuration.exception.CustomExceptionType;
import org.springframework.stereotype.Service;

@Service
public class ExceptionServiceImpl implements ExceptionService {

    @Override
    public String test() {
        //制造异常,未知的异常没有捕获
        int a = 1 / 0;
        return "A";
    }

    @Override
    public String test1(int input) {
        //捕获异常,转换为自定义异常抛出
        if (input > 10) {
            throw new CustomException(CustomExceptionType.USER_INPUT_ERROR, "不能输入大于10的数字");
        }
        return "B";
    }
}
