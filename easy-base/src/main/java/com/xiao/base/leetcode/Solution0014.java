package com.xiao.base.leetcode;

/**
 * 最长公共前缀
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * <p>
 * 如果不存在公共前缀，返回空字符串 ""。
 * 示例 1：
 * <p>
 * 输入：strs = ["flower","flow","flight"]
 * 输出："fl"
 * <p>
 * 示例 2：
 * <p>
 * 输入：strs = ["dog","racecar","car"]
 * 输出：""
 * 解释：输入不存在公共前缀。
 */
public class Solution0014 {

    // 解法一，暴力枚举
    public String longestCommonPrefix(String[] strs) {
        String commonPrefix = "";
        // 1. 查找最小长度元素
        int minlength = minlength(strs);
        if (minlength == 0) {
            return "";
        }
        // 2. 遍历数组每个元素，拼接最长前缀
        for (int i = 0; i < minlength; i++) {
            char temp = strs[0].charAt(i);
            for (int j = 0; j < strs.length; j++) {
                if (temp != strs[j].charAt(i)) {
                    return commonPrefix;
                }
            }
            commonPrefix += temp;
        }
        return commonPrefix;
    }

    public int minlength(String[] strs) {
        int minlength = strs[0].length();
        for (int i = 0; i < strs.length; i++) {
            if (strs[i].length() < minlength) {
                minlength = strs[i].length();
            }
        }
        return minlength;
    }

    public static void main(String[] args) {
        String[] tem = {"flower", "flow", "flight"};
        Solution0014 solution0014 = new Solution0014();
        System.out.println(solution0014.longestCommonPrefix(tem));
    }


}
