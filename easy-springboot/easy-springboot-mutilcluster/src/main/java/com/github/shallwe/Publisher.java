package com.github.shallwe;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationEvent;

public class Publisher {

    private static ApplicationContext applicationContext;

    public Publisher(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    public static void publishEvent(ApplicationEvent event) {
        System.out.println("发布事件。。。" + event.getClass());
        applicationContext.publishEvent(event);
    }

}
