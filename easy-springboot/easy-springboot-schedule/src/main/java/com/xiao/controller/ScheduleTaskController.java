package com.xiao.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

/**
 * @desc: 功能描述：<定时任务>
 * @author： jianjun.xiao
 * @E-mail： xiaocen65535@163.com
 * @createTime： 2021/6/17 8:14
 */
@RestController
@Slf4j
public class ScheduleTaskController {

    /**
     * 第一步，添加@EnableScheduling启动定时任务
     * 第二步，添加@Scheduled(cron = "0/5 * * * * ?")定时规则
     * cron详解：
     */
    @Async
    @Scheduled(cron = "0/5 * * * * ?")
    public void testScheduled() throws InterruptedException {
        log.info("任务一，当前时间：{}，当前线程：{}", LocalDateTime.now(), Thread.currentThread().getName());
        Thread.sleep(5000);
    }

    @Async
    @Scheduled(cron = "0/8 * * * * ?")
    public void testScheduled2() throws InterruptedException {
        log.info("任务二，当前时间：{}，当前线程：{}", LocalDateTime.now(), Thread.currentThread().getName());
        Thread.sleep(5000);
    }

}
