package com.github.shallwe;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class MutilClusterApplication {

    public static void main(String[] args) {
        SpringApplication.run(MutilClusterApplication.class, args);
    }

    @GetMapping("/test")
    public String test() {
        return "";
    }

}
