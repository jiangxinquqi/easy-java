package com.xiao.dao;

import org.junit.Test;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @desc: 功能描述：<>
 * @author： jianjun.xiao
 * @E-mail： xiaocen65535@163.com
 * @createTime： 2021/5/29 8:33
 */
public class AnnotationApplicationTest {

    @Test
    public void test() {
        ConfigurableApplicationContext context = SpringApplication.run(MybatisApplication.class, new String());
        System.out.println(context.getBean("deptMapper"));
    }

}