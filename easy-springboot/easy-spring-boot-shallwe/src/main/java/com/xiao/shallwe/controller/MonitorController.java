package com.xiao.shallwe.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.HashMap;

@RestController
public class MonitorController {

    @Value("${test.null-value}")
    private String a;

    @GetMapping("/test")
    public HashMap<String, Object> test() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("code", 200);
        map.put("message", "success");
        map.put("data", "test");
        System.out.println(a);
        System.out.println(StringUtils.isEmpty(a));
        return map;
    }

    @GetMapping("/monitor/{appName}/{option}")
    public String restart(@PathVariable String appName,
                          @PathVariable String option) throws IOException {
        String command = "sh /opt/microservice/service/" + appName + "/bin/boot.sh " + option;
        Runtime.getRuntime().exec(command);
        return "success";
    }

}
