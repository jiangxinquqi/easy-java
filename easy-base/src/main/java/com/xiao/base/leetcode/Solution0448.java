package com.xiao.base.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Solution0448 {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> disappearedNumbers = new ArrayList<>();
        int[] appearedNumbeers = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            appearedNumbeers[nums[i]] = 1;
        }
        for (int i = 1; i <= nums.length; i++) {
            if (appearedNumbeers[i] == 0) disappearedNumbers.add(i);
        }
        return disappearedNumbers;
    }
}
