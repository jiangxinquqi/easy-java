package com.xiao.base.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution0046 {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();

        List<Integer> item = new ArrayList<>(nums.length);
        for (Integer integer : nums) {
            item.add(integer);
        }

        backtrack(res, item, 0);
        return res;
    }

    private void backtrack(List<List<Integer>> res, List<Integer> item, int level) {
        if (item.size() == level) {
            res.add(new ArrayList<>(item));
            return;
        }
        for (int i = level; i < item.size(); i++) {
            Collections.swap(item, level, i);
            backtrack(res, item, level + 1);
            Collections.swap(item, level, i);
        }
    }

}

