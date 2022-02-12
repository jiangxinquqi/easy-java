package com.xiao.base.junit;

public class Calculate {

    public static int add(int a, int b) {
        return a + b;
    }

    public static int minus(int a, int b) {
        return a - b;
    }

    public static int divide(int a, int b) throws Exception {
        if (b == 0) {
            throw new Exception("除数不能为0");
        }
        return a / b;
    }

    public static int multiply(int a, int b) {
        return a * b;
    }

}
