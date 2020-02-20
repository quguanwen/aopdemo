package com.example.demo.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

@Configuration
public class TaskConfiguration {
    @Bean("taskExecutor")
    public Executor taskExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        //初始化线程数10
        executor.setCorePoolSize(10);
        //最大线程数20
        executor.setMaxPoolSize(20);
        //缓冲队列最大200
        executor.setQueueCapacity(200);
        //线程的空闲时间,及没有任务存在的时间
        executor.setKeepAliveSeconds(60);
        //应用关闭线程池直接关闭,这里改为true应用关闭后线程池等待所有任务完成后再继续销毁关闭线程
        executor.setWaitForTasksToCompleteOnShutdown(true);
        //设置任务等待超时时间,如果任务超过指定时间未结束强制销毁
        executor.setAwaitTerminationSeconds(30);
        //定位处理任务所在的线程池名前缀
        executor.setThreadNamePrefix("taskExecutor-");
        //线程池对拒绝任务处理策略
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        return executor;
    }
}
