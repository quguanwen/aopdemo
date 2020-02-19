package com.example.demo.controller;

import com.example.demo.ListenerFilterIntercept.CustomLister1;
import com.example.demo.configuration.exception.CustomException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
public class UserStatisticsController {

    @Resource
    CustomLister1 customLister1;

    @RequestMapping("/logUser")
    //TODO 统计在线人数,需要监听器+Controller一起实现,
    public String logUser(HttpServletRequest request, HttpServletResponse response) {
        //TODO 创建session
        request.getSession().setAttribute("name", request.getParameter("name"));
        return request.getParameter("name") + "登录成功！当前在线用户人数是：" + customLister1.count;
    }


    @RequestMapping("/logOut")
    public String logOut(HttpServletRequest request, HttpServletResponse response) {
        //TODO 销毁session
        request.getSession().invalidate();
        return request.getParameter("name") + "登出成功！当前在线用户人数是：" + customLister1.count;
    }

}