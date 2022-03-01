package com.xiao.base.leetcode;

import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;

/**
 * https://blog.csdn.net/qq_35915384/article/details/80227297
 */
@RunWith(Parameterized.class)
public class Solution0069Test extends TestCase {

    private int x;

    private int expected;

    private int y;

    private Solution0069 solution0069 = new Solution0069();

    public Solution0069Test(int x, int expected, int y) {
        this.x = x;
        this.y = y;
        this.expected = expected;
    }

    //Declares parameters here
    @Parameterized.Parameters(name = "case1")
    public static Iterable<Object[]> case1() {
        return Arrays.asList(new Object[][]{
                {0, 0, 1},
                {1, 1, 2},
                {2, 1, 3},
                {3, 1, 4},
                {4, 2, 5},
                {8, 2, 6}
        });
    }

    @Test
    public void testMySqrt() {
        int sqrt = solution0069.mySqrt(x);
        assertEquals(expected, sqrt);
    }

    @Test
    public void testCase2() {
        System.out.println("" + x + y + expected);
    }

}