package com.xiao.log;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @desc: 功能描述：（）
 * @author： jianjun.xiao
 * @E-mail： xiaoxiao65535@163.com
 * @createTime： 2018/9/4 16:05
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class ElkAppcliationTest {

    @Test
    public void log() {
        log.info("info========");
        log.warn("warn========");
        log.error("error========");
    }

}
