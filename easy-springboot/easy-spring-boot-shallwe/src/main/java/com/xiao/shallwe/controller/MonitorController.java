package com.xiao.shallwe.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class MonitorController {

    @GetMapping("/test")
    public String test() {
        return "hello world";
    }

    @GetMapping("/monitor/{appName}/{option}")
    public String restart(@PathVariable String appName,
                          @PathVariable String option) throws IOException {
        String commond = "sh /opt/microservice/service/" + appName + "/bin/boot.sh " + option;
        Runtime.getRuntime().exec(commond);
        return "sucess";
    }

}
