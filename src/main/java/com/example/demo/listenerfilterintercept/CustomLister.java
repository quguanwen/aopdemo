package com.example.demo.listenerfilterintercept;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;

/**
 * 监听request，统计访问量
 * */
@WebListener
@Slf4j
public class CustomLister implements ServletRequestListener {

    @Override
    public void requestDestroyed(ServletRequestEvent sre) {
        log.info("request级别监听器：销毁");
    }


    private static Long pv = 0L;

    @Override
    public void requestInitialized(ServletRequestEvent sre) {
        pv++;
        log.info("request级别监听器,访问次数+1,当前访问量:{}", pv);
    }

}
