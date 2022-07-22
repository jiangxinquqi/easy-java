package com.xiao.base.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 通过运行结果我们可以看到，通过动态代理，我们可以在不修改目标类源代码的情况下，对目标类的功能进行增强。
 * <p>
 * 我们可以总结一下动态代理的作用：
 * <p>
 * 1.在目标类源代码不改变的情况下，增加目标类的功能
 * 2.当涉及到多个方法都需要增加某些同样的功能时，使用动态代理可以减少代码的重复
 * 3.可以使目标类专注于业务逻辑代码
 * 4.实现解耦合，让业务功能和日志、事务和非事务功能分离
 */
public class SubjectInvocationHandler implements InvocationHandler {

    private Object target;

    public SubjectInvocationHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("=========前置增强======");
        System.out.println(method.getName());
        Object invoke = method.invoke(target, args);
        System.out.println("=========后置增强======");
        return invoke;
    }

    public static void main(String[] args) {

        Subject subject = new DefaultSubject();

        SubjectInvocationHandler handler = new SubjectInvocationHandler(subject);

        Subject proxy = (Subject) Proxy.newProxyInstance(subject.getClass().getClassLoader(), subject.getClass().getInterfaces(), handler);

        String result = proxy.subject("订阅");

        System.out.println(result);

        String s = proxy.deSubject();

        System.out.println(s);

    }

}
