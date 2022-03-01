package com.xiao.base.leetcode;

public class Solution0070 {

    public int climbStairs(int n) {
        int pre1 = 1, pre2 = 2, current = 0;
        if (n <= 2) {
            return n;
        }
        for (int i = 3; i < n; i++) {
            current = pre1 + pre2;
            pre1 = pre2;
            pre2 = current;
        }
        return current;
    }

}
