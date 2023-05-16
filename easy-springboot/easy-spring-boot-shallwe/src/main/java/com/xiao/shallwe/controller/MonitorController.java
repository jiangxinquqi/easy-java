package com.xiao.shallwe.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.HashMap;

@RestController
public class MonitorController {

    @GetMapping("/test")
    public HashMap<String, Object> test() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("code", 200);
        map.put("message", "success");
        map.put("data", "test");
        return map;
    }

    @GetMapping("/monitor/{appName}/{option}")
    public String restart(@PathVariable String appName,
                          @PathVariable String option) throws IOException {
        String commond = "sh /opt/microservice/service/" + appName + "/bin/boot.sh " + option;
        Runtime.getRuntime().exec(commond);
        return "success";
    }

}
