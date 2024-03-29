package com.github.shallwe;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class MulticasterApplication {

    public static void main(String[] args) {
        SpringApplication.run(MulticasterApplication.class, args);
    }

    @GetMapping("/test")
    public String test() {
        return "";
    }

}
