package com.xiao;

import com.xiao.jd.vop.api.JdVopService;
import com.xiao.jd.vop.api.impl.JdVopInRedisConfigStorage;
import com.xiao.jd.vop.api.impl.JdVopServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import redis.clients.jedis.JedisPool;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.attribute.FileAttribute;

/**
 * @desc: 功能描述：（）
 * @author： jianjun.xiao
 * @E-mail： xiaoxiao65535@163.com
 * @createTime： 2018/9/10 13:57
 */
@SpringBootApplication
@RestController
@Slf4j
public class AssemblyApplication {
    public static void main(String[] args) {
        SpringApplication.run(AssemblyApplication.class, args);
    }

    @GetMapping("/test")
    public String test() {
        for (int i = 0; i < 500; i++) {
            log.debug("debug............");
            log.info("info..............");
            log.warn("warn..............");
            log.error("error..............");
        }
        return "test";
    }

    @GetMapping("/file")
    public String file() throws IOException {
        return Files.createTempDirectory("weixin-mp-kf-download", new FileAttribute[0]).toFile().toString();
    }
}
