package com.xiao;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @desc: 功能描述：（服务提供者）
 * @author： jianjun.xiao
 * @E-mail： xiaoxiao65535@163.com
 * @createTime： 2018/9/16 1:58
 */
@SpringBootApplication
@RestController
public class ProviderApplication {

    @Value("${server.port}")
    private String port;
    @Value("${spring.application.name}")
    private String applicationName;

    public static void main(String[] args) {
        SpringApplication.run(ProviderApplication.class, args);
    }

    @GetMapping("/hello")
    public String hello() {
        return "i am " + applicationName + ":" + port;
    }
}
