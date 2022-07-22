package com.xiao.base.proxy;

public class DefaultSubject implements Subject {

    @Override
    public String subject(String message) {
        System.out.println("message: " + message);
        return "success";
    }

    @Override
    public String deSubject() {
        System.out.println("取消订阅");
        return "success";
    }

}
