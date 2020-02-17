package com.example.demo.entity;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class User {

    @NotNull(message = "用户名不允许为空")
    @Size(min = 2, max = 8, message = "用户名称必须在2到8位之间")
    private String name;

    @NotNull(message = "年龄不允许为空")
    private String age;

    @Email(message = "请输入正确的电子邮箱地址")
    private String email;

}
