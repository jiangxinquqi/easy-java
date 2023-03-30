package com.xiao.base.spring;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.annotation.Resource;

public class SpringXmlTest {

    @Resource
    private User user;

    private void print() {
        user.print();
    }

    @Test
    public void test() {

//        ConfigurableApplicationContext application = SpringApplication.run(SpringXmlTest.class);
//
//        ApplicationContext context1 = new ClassPathXmlApplicationContext("applicationContext.xml");
////
//        ApplicationContext context = new AnnotationConfigApplicationContext(SpringXmlTest.class, User.class);

          ApplicationContext context = new ClassPathJsonApplicationContext("");

//        User bean = context.getBean(User.class);
//        bean.print();

//        SpringXmlTest test = context.getBean(SpringXmlTest.class);
//        test.print();

    }

}
