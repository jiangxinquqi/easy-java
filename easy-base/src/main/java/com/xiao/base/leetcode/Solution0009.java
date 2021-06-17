package com.xiao.base.leetcode;

/**
 * <p>回文数</>
 *
 * 给你一个整数 x ，如果 x 是一个回文整数，返回 true ；否则，返回 false 。
 * <p>
 * 回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。例如，121 是回文，而 123 不是。
 */
public class Solution0009 {
    public boolean isPalindrome(int x) {
        String tep = String.valueOf(x);
        return tep.equals(new StringBuffer(tep).reverse().toString());
    }

    public static void main(String[] args) {
        Solution0009 a = new Solution0009();
        System.out.println(a.isPalindrome(121));
    }
}
