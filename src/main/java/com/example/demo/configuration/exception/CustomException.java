package com.example.demo.configuration.exception;

/**
 * 自定义异常,继承RuntimeException
 */

public class CustomException extends RuntimeException {

    //异常错误码,枚举类定义好了
    private int code;
    //异常信息,转换自定义异常时添加
    private String message;

    public CustomException(CustomExceptionType type, String message) {
        this.code = type.getCode();
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    //重写了RuntimeException的方法
    public String getMessage() {
        return message;
    }

}
