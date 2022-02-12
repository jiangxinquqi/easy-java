package com.xiao.base.junit;

import junit.framework.TestCase;
import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class CalculateTest extends TestCase {

    @BeforeClass
    public static void setUpBeforeClass() {
        System.out.println("before class");
    }

    @AfterClass
    public static void afterClass() {
        System.out.println("after class");
    }

    @Before
    public void setUp() {
        System.out.println("before");
    }

    @After
    public void after() {
        System.out.println("after");
    }

    @Parameterized.Parameters
    public static Collection data() {
        return Arrays.asList(new Object[][] {
                { 1, 1, 2 },
                { -1, -1, -2 },
                { -1, 1, 0 },
                { 2147483647, 1, -2147483647 },
                { -2147483648, -1, 2147483647 }
        });
    }

    private int leftVal;
    private int rightVal;
    private int expectedVal;

    public CalculateTest(int leftVal, int rightVal, int expectedVal) {
        super();
        this.leftVal = leftVal;
        this.rightVal = rightVal;
        this.expectedVal = expectedVal;
    }

//    @Test
//    public void testAdd() {
//        assertEquals(5, Calculate.add(1, 4));
//    }
//
//    @Test
//    public void testMinus() {
//        assertEquals(-1, Calculate.minus(2, 3));
//    }
//
//    @Test
//    public void testDivide() throws Exception {
//        assertEquals(0, Calculate.divide(1, 4));
//    }
//
//    @Test
//    public void testMultiply() {
//        assertEquals(4, Calculate.multiply(1, 4));
//    }

}