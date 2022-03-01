package com.xiao.base.leetcode;

public class Solution0917 {
    public String reverseOnlyLetters(String s) {
        char[] chars = s.toCharArray();
        int i = 0;
        int j = chars.length - 1;
        while (i < j) {
            while (Character.isLetter(chars[i])) {
                // 直到左边扫描到字母
                i++;
            }
            while (Character.isLetter(chars[j])) {
                // 直到右边扫描到字母
                j--;
            }
            if (i >= j) {
                break;
            }
            swap(chars, i, j);
            i++;
            j--;
        }
        return String.valueOf(chars);
    }

    private void swap(char[] chars, int left, int right) {
        char tmp = chars[left];
        chars[left] = chars[right];
        chars[right] = tmp;
    }
}
