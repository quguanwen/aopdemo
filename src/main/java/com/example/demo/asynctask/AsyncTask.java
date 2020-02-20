package com.example.demo.asynctask;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;
import java.util.concurrent.Future;

/**
 * 将普通的任务改造成异步任务,并且立即返回一个Future对象可以监测子线程状态
 * */

@Component
public class AsyncTask extends CommonTask {

    //TODO 指定所使用的线程池Bean配置名称
    @Async("taskExecutor")
    public Future<String> doTaskOneCallback() throws Exception {
        super.doTaskOne();
        return new AsyncResult<>("任务1完成");
    }

    @Async("taskExecutor")
    public Future<String> doTaskTwoCallback() throws Exception {
        super.doTaskTwo();
        return new AsyncResult<>("任务2完成");
    }

    @Async("taskExecutor")
    public Future<Integer> doTaskThreeCallback() throws Exception {
        Integer result = super.doTaskThree();
        return new AsyncResult<>(result);
    }


}
