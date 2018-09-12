package com.xiao;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * @desc: 功能描述：（）
 * @author： jianjun.xiao
 * @E-mail： xiaoxiao65535@163.com
 * @createTime： 2018/9/12 16:28
 */
@Setter
@Getter
public class User implements Serializable {
    private static final long serialVersionUID = -1L;

    private String username;
    private Integer age;

    public User() {
    }

    public User(String username, Integer age) {
        this.username = username;
        this.age = age;
    }

}
