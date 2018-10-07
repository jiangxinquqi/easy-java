package com.xiao.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @desc: 功能描述：（）
 * @author： jianjun.xiao
 * @E-mail： xiaoxiao65535@163.com
 * @createTime： 2018/10/7 12:01
 */
@RestController
@Slf4j
public class CorsController {

    @CrossOrigin(origins = {"http://127.0.0.1:8020", "null"})
    @GetMapping("/cors")
    public String cors() {
        return "cors";
    }

    @CrossOrigin(origins = {"http://127.0.0.1:8020", "null"})
    @PostMapping("/cors")
    public String corsPost(String a) {
        return a;
    }
}
