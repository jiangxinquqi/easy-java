package com.xiao.base.leetcode;

import java.util.Arrays;

public class Solution0416 {
    public boolean canPartition(int[] nums) {
//        int sum = Arrays.stream(nums).sum();
//        if (nums.length == 1 || sum % 2 == 1) return false;
//        int target = sum/2, n = nums.length;
//        boolean[][] dp = new boolean[n + 1][target + 1];
//        for (int i = 0; i <= n; ++i) {
//            dp[i][0] = true;
//        }
//        for (int i = 0; i <= n; i++) {
//            for (int j =  nums[i-1]; j <= target; j++) {
//                dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i - 1]];
//            }
//        }
//        return dp[n][target];
        int sum = Arrays.stream(nums).sum();
        if (nums.length == 1 || sum % 2 == 1) return false;
        int target = sum/2, n = nums.length;
        boolean[][] dp = new boolean[n][target + 1];
        for (int i = 0; i < n; i++) {
            dp[i][0] = true;
        }
        for (int i = 1; i < n; i++) {
            int num = nums[i];
            for (int j = 1; j <= target; j++) {
                if (j >= num) {
                    dp[i][j] = dp[i - 1][j] | dp[i - 1][j - num];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n - 1][target];
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2 ,4};
        int reduce = Arrays.stream(arr).sum();
        System.out.println(reduce);
    }
}
