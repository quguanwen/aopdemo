package com.example.demo.entity;

import com.example.demo.configuration.exception.CustomException;
import com.example.demo.configuration.exception.CustomExceptionType;
import lombok.Data;

@Data
public class AjaxResponse {
    private boolean isok;   //请求是否处理成功
    private int code;          //请求响应状态码（200、400、500）
    private String message;  //请求结果描述信息
    private Object data;  //请求结果数据

    private AjaxResponse() {

    }

    //请求成功的响应，不带查询数据（用于删除、修改、新增接口）
    public static AjaxResponse success() {
        AjaxResponse resultBean = new AjaxResponse();
        resultBean.setIsok(true);
        resultBean.setCode(200);
        resultBean.setMessage("success");
        return resultBean;
    }

    //请求成功的响应，带有查询数据（用于数据查询接口）
    public static AjaxResponse success(Object data) {
        AjaxResponse resultBean = new AjaxResponse();
        resultBean.setIsok(true);
        resultBean.setCode(200);
        resultBean.setMessage("success");
        resultBean.setData(data);
        return resultBean;
    }

    //请求异常的数据封装
    public static AjaxResponse error(CustomException e){
        AjaxResponse resultBean = new AjaxResponse();
        resultBean.setIsok(false);
        resultBean.setCode(e.getCode());
        //用户错误,直接返回,不需要联系人
        if(e.getCode() == CustomExceptionType.USER_INPUT_ERROR.getCode()){
            resultBean.setMessage(e.getMessage());
        //程序已知位置错误,给予友好提示
        }else if(e.getCode() == CustomExceptionType.SYSTEM_ERROR.getCode()){
            resultBean.setMessage(e.getMessage() + ",系统出现异常，请联系管理员电话：13756108723进行处理!");
        }else{
        //未知错误提供友好提示
            resultBean.setMessage("系统出现未知异常，请联系管理员电话：13756108723进行处理!");
        }
        return resultBean;
    }
}
