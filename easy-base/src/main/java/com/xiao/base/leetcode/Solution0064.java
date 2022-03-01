package com.xiao.base.leetcode;

public class Solution0064 {
    public int minPathSum(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] dp = new int[m][n];
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if (i == 0 && j==0) {
                    dp[i][j] = grid[i][j];
                } else if (i == 0) {
                    dp[i][j] = dp[i][j-1] + grid[i][j];
                } else if (j == 0) {
                    dp[i][j] = dp[i-1][j] + grid[i][j];
                } else {
                    dp[i][j] = Math.min(dp[i-1][j], dp[i][j-1]) + grid[i][j];
                }
            }
        }
        return dp[m - 1][n - 1];
    }

    public static void main(String[] args) {
//        int[][] dp = new int[][]{{1,3,1},{1,5,1},{4,2,1}};
//        Solution0064 solution0064 = new Solution0064();
//        int i = solution0064.minPathSum(dp);
//        System.out.println(i);
        int n = 3;
            int[] fib = new int[n + 1];
            fib[1] = 1;
            fib[2] = 1;
            for (int i = 3; i < n + 1; i++) {
                fib[i] = fib[i - 1] + fib[i - 2];
            }
        System.out.println(fib[n]);
    }
}
