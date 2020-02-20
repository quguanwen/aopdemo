package com.example.demo.controller;

import com.example.demo.asynctask.AsyncTask;
import com.example.demo.entity.AjaxResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.Future;

import static java.lang.System.currentTimeMillis;
import static java.lang.Thread.sleep;

@Slf4j
@RestController
public class AsyncController {

    @Autowired
    AsyncTask asyncTask;

    @GetMapping("/asyncTask")
    public AjaxResponse asyncTask() throws Exception {

        Long start = currentTimeMillis();

        Future<String> task1 = asyncTask.doTaskOneCallback();
        Future<String> task2 = asyncTask.doTaskTwoCallback();
        Future<Integer> task3 = asyncTask.doTaskThreeCallback();
        //TODO 获取线程方法执行的返回值
        log.info("获取task的返回值:{}", task3.get());

        //TODO 等待三个任务结束再推出循环，否则sleep1秒
        while (!task1.isDone() || !task2.isDone() || !task3.isDone()) {
            sleep(1000);
        }

        Long end = currentTimeMillis();

        return AjaxResponse.success(end - start);
    }
}
