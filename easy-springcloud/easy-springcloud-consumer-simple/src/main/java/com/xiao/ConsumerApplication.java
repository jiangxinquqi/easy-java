package com.xiao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @desc: 功能描述：（服务提供者）
 * @author： jianjun.xiao
 * @E-mail： xiaoxiao65535@163.com
 * @createTime： 2018/9/16 1:58
 */
@SpringBootApplication
@RestController
public class ConsumerApplication {

    @Value("${server.port}")
    private String port;
    @Value("${spring.application.name}")
    private String applicationName;

    public static void main(String[] args) {
        SpringApplication.run(ConsumerApplication.class, args);
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping
    public String provider() {
        return restTemplate.getForObject("http://localhost:6300/provider", String.class);
    }

    @GetMapping("/consumer")
    public String hello() {
        return "i am " + applicationName + ":" + port;
    }
}
