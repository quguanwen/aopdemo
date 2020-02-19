package com.example.demo.ListenerFilterIntercept;


import lombok.extern.slf4j.Slf4j;
import org.springframework.lang.Nullable;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
public class CustomIntercept implements HandlerInterceptor {

    /**
     * request和response都应当在这里设置
     * */
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.info(request.getHeader("User-Agent"));
        response.addHeader("myId","007");
        return true;
    }

    /**
     * 如果@ResponseBody注释 或者返回 ResponseEntity，在postHandle拦截器中修改请求头，是无效的。
     * */
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable ModelAndView modelAndView) throws Exception {
        log.info("??");
    }

    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable Exception ex) throws Exception {
        log.info("???");
    }
}
