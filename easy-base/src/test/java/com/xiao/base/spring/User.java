package com.xiao.base.spring;

import lombok.Data;

@Data
public class User {

    private Integer id = 1;
    private String name = "hahah";

    public void print() {
        System.out.println(id + name);
    }

}
