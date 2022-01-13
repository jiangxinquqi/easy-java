package com.xiao;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.lang.reflect.Method;
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

    @Value("${xiao}")
    private String xiao;

    public static void main(String[] args) {
        SpringApplication.run(AssemblyApplication.class, args);
        dump(args);
    }

    @GetMapping("/test")
    public String test() {

        log.debug("debug............");
        log.info("info..............");
        log.warn("warn..............");
        log.error("error..............");

        return xiao;
    }

    static class OOM{}

    public static void dump(String[] args) {
        int i = 0;//模拟计数多少次以后发生异常
        try {
            while (true){
                i++;
                Enhancer enhancer = new Enhancer();
                enhancer.setSuperclass(OOM.class);
                enhancer.setUseCache(false);
                enhancer.setCallback(new MethodInterceptor() {
                    @Override
                    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                        return methodProxy.invokeSuper(o,args);
                    }
                });
                enhancer.create();
            }
        } catch (Throwable e) {
            System.out.println("=================多少次后发生异常："+i);
            e.printStackTrace();
        }
    }

    @GetMapping("/file")
    public String file() throws IOException {
        return Files.createTempDirectory("weixin-mp-kf-download", new FileAttribute[0]).toFile().toString();
    }
}
