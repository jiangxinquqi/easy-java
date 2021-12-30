package com.xiao.shallwe.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MonitorController {

    @GetMapping("/test")
    public String test() {
        return "hello world";
    }

}
