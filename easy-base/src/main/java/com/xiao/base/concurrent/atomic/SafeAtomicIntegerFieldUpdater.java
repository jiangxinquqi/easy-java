package com.xiao.base.concurrent.atomic;

import com.xiao.base.concurrent.annotations.ThreadSafe;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/**
 * @desc: 功能描述：（）
 * @author： jianjun.xiao
 * @E-mail： xiaoxiao65535@163.com
 * @createTime： 2018/10/7 10:29
 */
@ThreadSafe
@Slf4j
public class SafeAtomicIntegerFieldUpdater {
    // AtomicIntegerFieldUpdater : 原子性更新某个对象的某个字段,该字段必须被volatile修饰，且不能为static
    private static AtomicIntegerFieldUpdater<SafeAtomicIntegerFieldUpdater> updater
            = AtomicIntegerFieldUpdater.newUpdater(SafeAtomicIntegerFieldUpdater.class, "count");

    // 要更新的对象的值必须被volatile修饰
    @Getter
    private volatile int count = 100;

    public static void main(String[] args) {

        SafeAtomicIntegerFieldUpdater safeAtomicIntegerFieldUpdater = new SafeAtomicIntegerFieldUpdater();

        if (updater.compareAndSet(safeAtomicIntegerFieldUpdater, 100, 200)) {
            log.info("update success 1,count:{}", safeAtomicIntegerFieldUpdater.getCount());
        }

        if (updater.compareAndSet(safeAtomicIntegerFieldUpdater, 100, 200)) {
            log.info("update success 2,count:{}", safeAtomicIntegerFieldUpdater.getCount());
        } else {
            log.info("update failed");
        }
    }

}
