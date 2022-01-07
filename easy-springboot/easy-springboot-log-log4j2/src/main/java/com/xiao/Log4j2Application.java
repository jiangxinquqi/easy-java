package com.xiao;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@Slf4j
public class Log4j2Application {

    public static void main(String[] args) {
        for (int i = 0; i < 10000; i++) {
            log.info("info...");
            log.warn("warn...");
            log.error("error...");
        }
        SpringApplication.run(Log4j2Application.class, args);
    }

}
