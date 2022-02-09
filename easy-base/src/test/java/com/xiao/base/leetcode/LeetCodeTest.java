package com.xiao.base.leetcode;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

public class LeetCodeTest extends TestCase {

    private LeetCode leetCode = new LeetCode();

    @Test
    public void testFindContentChildren() {
        int[] children = {2, 1};
        int[] cookies = {2, 3, 1};
        int contentChildren = leetCode.findContentChildren(children, cookies);
        Assert.assertTrue(contentChildren == 2);
    }

}