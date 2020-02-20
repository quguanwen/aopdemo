package com.example.demo.asynctask;


import lombok.extern.slf4j.Slf4j;

import java.util.Random;

import static java.lang.System.currentTimeMillis;
import static java.lang.Thread.sleep;

/**
 * 定义一些普通的任务
 */

@Slf4j
public class CommonTask {
    private static Random random = new Random();

    public void doTaskOne() throws Exception {
        log.info("<---观察线程池标识");
        System.out.println("开始做任务一");
        long start = currentTimeMillis();
        sleep(random.nextInt(10000));
        long end = currentTimeMillis();
        System.out.println("完成任务一，耗时：" + (end - start) + "毫秒");
    }

    public void doTaskTwo() throws Exception {
        System.out.println("开始做任务二");
        long start = currentTimeMillis();
        sleep(random.nextInt(10000));
        long end = currentTimeMillis();
        System.out.println("完成任务二，耗时：" + (end - start) + "毫秒");
    }

    public Integer doTaskThree() throws Exception {
        System.out.println("开始做任务三");
        long start = currentTimeMillis();
        sleep(random.nextInt(10000));
        long end = currentTimeMillis();
        System.out.println("完成任务三，耗时：" + (end - start) + "毫秒");
        return 1;
    }
}
