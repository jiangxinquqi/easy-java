package com.xiao.base.leetcode;

/**
 * <p>两数之和</>
 *
 * <p>给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
 * 你可以按任意顺序返回答案。
 * </>
 * 示例 1：
 * 输入：nums = [2,7,11,15], target = 9
 * 输出：[0,1]
 * 解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
 */
public class Solution0001 {
    public int[] twoSum(int[] nums, int target) {
        // 暴力枚举解法：时间复杂度为 O(N^2),空间复杂度为O(1)
        // 另一种解法利用hash表，时间复杂度可以降低到O(N)，空间复杂度为O(N)
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[0];
    }
}
