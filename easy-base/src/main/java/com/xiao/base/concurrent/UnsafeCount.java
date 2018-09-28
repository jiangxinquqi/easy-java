package com.xiao.base.concurrent;

import com.xiao.base.concurrent.annotations.NotThreadSafe;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * @desc: 功能描述：（不安全的程序计数器）
 * @author： jianjun.xiao
 * @E-mail： xiaoxiao65535@163.com
 * @createTime： 2018/9/28 11:24
 */
@Slf4j
@NotThreadSafe
public class UnsafeCount {
    // 总请求数
    public static int clientTotal = 5000;
    // 允许的并发数
    public static int threadTotal = 200;
    // 程序计数器
    public static int count = 0;

    public static void main(String[] args) throws Exception {
        // 定义线程
        ExecutorService executorService = Executors.newCachedThreadPool();
        // 定义信号量，可以控制并发数
        final Semaphore semaphore = new Semaphore(threadTotal);
        // 初始化请求数
        final CountDownLatch countDownLatch = new CountDownLatch(clientTotal);
        for (int i = 0; i < clientTotal; i++) {
            executorService.execute(() -> {
                try {
                    // 锁定资源
                    semaphore.acquire();
                    add();
                    // 释放资源
                    semaphore.release();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                // 请求完成，请求数减1
                countDownLatch.countDown();
            });
        }
        // 等待所有线程执行完
        countDownLatch.await();
        // 关闭线程池
        executorService.shutdown();
        log.info("count:{}", count);
    }

    private static void add() {
        count++;
    }

}
