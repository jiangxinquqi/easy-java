package com.xiao.base.leetcode;

import org.springframework.scheduling.support.SimpleTriggerContext;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Pattern;

class ListNode {

    private int value;

    private ListNode next = null;

    public ListNode() {

    }

    public ListNode(int value) {
        this.value = value;
    }

    public ListNode(int value, ListNode next) {
        this.value = value;
        this.next = next;
    }

    public ListNode next() {
        return next;
    }

    public int value() {
        return this.value;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }

}

class MyChar implements Comparable<MyChar> {
    public char cha;
    public int sum;

    public MyChar(char cha, int sum) {
        this.cha = cha;
        this.sum = sum;
    }

    @Override
    public int compareTo(MyChar o) {
        if (sum == o.sum) {
            return cha - o.cha;
        } else {
            return sum - o.sum;
        }
    }

}

public class Niuke {

    public static void main(String[] args) {
        System.out.println(new Niuke().trans("This is a sample",16));
    }

    public String trans(String s, int n) {
        // write code here
        String str = trans(s);

        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < str.length(); i++) {
            char cha = str.charAt(i);
            if (cha >= 'a' && cha <= 'z') {
                sb.append((char) (cha - 'a' + 'A'));
            } else if (cha >= 'A' && cha <= 'Z') {
                sb.append((char) (cha - 'A' + 'a'));
            } else {
                sb.append(cha);
            }
        }
        return sb.toString();
    }

    private String trans(String s) {
        String[] strs = s.split(" ");
        for (int i = 0; i < strs.length / 2; i++) {
            String temp = strs[i];
            strs[i] = strs[strs.length - 1 - i];
            strs[strs.length - 1 - i] = temp;
        }
        return null;
    }

    private static int longest(String pwd) {
        int longest = 1;
        for (int i = 0; i < pwd.length(); i++) {
            for (int j = i + 1; j < pwd.length(); j++) {
                if (isTarget(pwd.substring(i, j))) {
                    longest = Math.max(longest, j - i);
                }
            }
        }
        return longest;
    }

    private static boolean isTarget(String source) {
        return true;
    }


    public static int process(int m, int n) {
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0) {
                    dp[0][j] = 1;
                } else if (j == 0) {
                    dp[i][0] = 1;
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
                String s = Integer.toBinaryString(1);
            }
        }

        return dp[m + 1][n + 1];
    }

    public static String process1(String source) {
        StringBuffer sb = new StringBuffer();
        // 遍历字符串
        for (int i = 0; i < source.length(); i++) {
            char cha = source.charAt(i);

            // 1--1， abc--2, def--3, ghi--4, jkl--5, mno--6, pqrs--7, tuv--8 wxyz--9, 0--0
            if (cha >= 'a' && cha <= 'c') {
                sb.append('2');
            } else if (cha >= 'd' && cha <= 'f') {
                sb.append('3');
            } else if (cha >= 'g' && cha <= 'i') {
                sb.append('4');
            } else if (cha >= 'j' && cha <= 'l') {
                sb.append('5');
            } else if (cha >= 'm' && cha <= 'o') {
                sb.append('6');
            } else if (cha >= 'p' && cha <= 's') {
                sb.append('7');
            } else if (cha >= 't' && cha <= 'v') {
                sb.append('8');
            } else if (cha >= 'w' && cha <= 'z') {
                sb.append('9');
            } else if (cha == 'Z') {
                sb.append('a');
            } else if (cha >= 'A' && cha < 'Z') {
                sb.append(Character.toLowerCase(cha) + '1');
            } else {
                sb.append(cha);
            }

        }
        return sb.toString();
    }

    public static boolean isBorther(String target, String source) {
        if (target.length() != source.length()) {
            return false;
        }

        char[] chars = target.toCharArray();
        char[] chars1 = source.toCharArray();
        for (int i = 0; i < target.length(); i++) {
            if (chars[i] != chars1[i]) {
                return false;
            }
        }
        return true;
    }

    private static int StrToInt(String s) {
        s = s.trim();
        if (s.length() == 0) {
            return 0;
        }

        int result = 0;
        int index = 0;
        int sign = 1;
        if (s.charAt(index) == '-') {
            sign = -1;
            index++;
        } else if (s.charAt(index) == '+') {
            index++;
        }

        while (index < s.length() && Character.isDigit(s.charAt(index))) {
            if ((Integer.MAX_VALUE / 10) < result || (Integer.MIN_VALUE / 10) > result) {
                break;
            }
            result = result * 10 + (s.charAt(index) - '0') * sign;
            index++;
        }

        return result;
    }

    private static boolean isReat(String s) {
        // 3. 校验字串
        for (int i = 0; i < s.length() - 2; i++) {
            String subString = s.substring(i, i + 3);
            if (s.substring(i + 3).indexOf(subString) != -1) {
                return false;
            }
        }
        return true;
    }

    private static boolean isGreaterThan3Type(String s) {
        // 2. 校验字符类型，至少3种类型
        int count = 0;
        if (Pattern.compile("[A-Z]").matcher(s).find()) {
            count++;
        }
        if (Pattern.compile("[a-z]").matcher(s).find()) {
            count++;
        }
        if (Pattern.compile("[0-9]").matcher(s).find()) {
            count++;
        }
        if (Pattern.compile("[^a-zA-Z0-9]").matcher(s).find()) {
            count++;
        }
        return count >= 3;
    }

    private static boolean isLengthOk(String s) {
        return s.length() >= 8;
    }

}

