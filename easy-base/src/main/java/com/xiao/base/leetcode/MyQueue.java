package com.xiao.base.leetcode;

import java.util.Deque;
import java.util.LinkedList;

public class MyQueue {

    private Deque<Integer> s1;
    private Deque<Integer> s2;
    private int front = 0;

    public MyQueue() {
        s1 = new LinkedList<>();
        s2 = new LinkedList<>();
    }

    public void push(int x) {
        if (s1.isEmpty()) {
            front = x;
        }
        s1.push(x);
    }

    public int pop() {
        //先检查s2是否为空,如果为空,弹出的是s1的栈底,非空,弹出s2的栈顶
        if (s2.isEmpty()){
            while (!s1.isEmpty()){
                s2.push(s1.pop());
            }
        }

        return s2.pop();
    }

    public int peek() {
        if (!s2.isEmpty()){
            return s2.peek();
        }
        return front;
    }

    public boolean empty() {
        return s1.isEmpty() && s2.isEmpty();
    }

}
