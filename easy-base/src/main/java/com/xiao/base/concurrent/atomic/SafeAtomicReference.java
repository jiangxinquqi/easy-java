package com.xiao.base.concurrent.atomic;

import com.xiao.base.concurrent.annotations.ThreadSafe;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.atomic.AtomicReference;

/**
 * @desc: 功能描述：（）
 * @author： jianjun.xiao
 * @E-mail： xiaoxiao65535@163.com
 * @createTime： 2018/9/28 17:07
 */
@ThreadSafe
@Slf4j
public class SafeAtomicReference {
    public static AtomicReference<Integer> num = new AtomicReference<>(0);

    public static void main(String[] args) {
        num.compareAndSet(0, 1); // 1
        num.compareAndSet(0, 2); // no
        num.compareAndSet(1, 3); // 3
        num.compareAndSet(1, 4); // no
        num.compareAndSet(3, 5); // 5
        log.info("count:{}", num.get()); // 5
    }

}
