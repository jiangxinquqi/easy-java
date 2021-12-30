package com.xiao.shallwe;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ShallweApplication {

    public static void main(String[] args) {
        System.setProperty("xiaoname", "jianjun");
        SpringApplication.run(ShallweApplication.class, args);
    }

}
