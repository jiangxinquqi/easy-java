package com.xiao;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @desc: 功能描述：（）
 * @author： jianjun.xiao
 * @E-mail： xiaoxiao65535@163.com
 * @createTime： 2018/9/11 14:46
 */
@SpringBootApplication
@RestController
@Slf4j
public class LogbackApplication {
    public static void main(String[] args) {
        SpringApplication.run(LogbackApplication.class, args);
    }

    @GetMapping("/log")
    public void log() {
        log.info("log..........");
        log.warn("warn.............");
        log.error("error.........");
    }
}
