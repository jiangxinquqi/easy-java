package com.xiao.base.leetcode;

/**
 * <p>整数反转</>
 *
 * 给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。
 * <p>
 * 如果反转后整数超过 32 位的有符号整数的范围 [−2^31,  2^31 − 1] ，就返回 0。
 */
public class Solution0007 {

    public int reverse(int x) {
        if (x == 0) {
            return 0;
        }

        String num = String.valueOf(x);
        if (x < 0) {
            num = num.replace("-", "");
        }

        if (num.length() == 1) {
            return x;
        }

        char[] chars = num.toCharArray();
        for (int i = 0; i < chars.length >> 1; i++) {
            char temp = chars[i];
            chars[i] = chars[chars.length - i - 1];
            chars[chars.length - i - 1] = temp;
        }

        num = String.valueOf(chars);
        if (num.length() == 10 && num.compareTo("2147483647") > 0) {
            return 0;
        }

        if (x < 0) {
            return 0 - Integer.parseInt(num);
        }
        return Integer.parseInt(num);
    }

}
