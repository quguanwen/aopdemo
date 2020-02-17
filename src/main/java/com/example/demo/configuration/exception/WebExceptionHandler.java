package com.example.demo.configuration.exception;

import com.example.demo.entity.AjaxResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * 全局异常处理器
 * 记录系统中抛出所有的异常必须有指定处理器对异常处理!!!
 *
 */

@ControllerAdvice
@Slf4j
public class WebExceptionHandler {

    @ExceptionHandler(CustomException.class)
    @ResponseBody
    public AjaxResponse customerException(CustomException e) {
        if (e.getCode() == CustomExceptionType.SYSTEM_ERROR.getCode()) {
            //TODO 持久化日志处理
            log.error("系统内部错误:{}", e.getMessage());
        }
        return AjaxResponse.error(e);
    }

    //TODO 出现未捕获到的异常,也统一转换为自定义异常
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public AjaxResponse exception(Exception e) {
        log.error(e.getMessage());
        return AjaxResponse.error(new CustomException(CustomExceptionType.OTHER_ERROR, "未知异常"));
    }
}
