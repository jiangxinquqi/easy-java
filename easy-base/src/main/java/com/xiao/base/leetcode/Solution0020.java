package com.xiao.base.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @desc: 功能描述：<有效括号>
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 * <p>
 * 有效字符串需满足：
 * <p>
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * </>
 */
public class Solution0020 {

    public boolean isValid2(String s) {
        // 使用栈
        // 建立映射 {} [] ()
        // 遍历s
        // 如果是open，则压栈
        // 如果是close，则判断栈顶和该元素是否为开闭关系
        //      是：出栈
        //      否：直接返回false
        // 结束遍历，栈元素为0，返回true，否者false；
        Map<Character, Character> validMap = new HashMap<>(5);
        validMap.put('}', '{');
        validMap.put(']', '[');
        validMap.put(')', '(');
        Stack<Character> validStack = new Stack<>();
        if (s.length() <= 1) {
            return false;
        }
        validStack.push(s.charAt(0));
        for (int i = 1; i < s.length(); i++) {
            Character currentChar = s.charAt(i);
            if (validMap.get(currentChar) == null) {
                // 空为open，直接压栈
                validStack.push(currentChar);
            } else {
                // close
                if (validMap.get(currentChar) != validStack.peek()) {
                    return false; 
                }
                // 匹配出栈
                validStack.pop();
            }
        }
        return validStack.size() == 0;
    }

    public boolean isValid1(String s) {
        while (s.contains("{}") || s.contains("[]") || s.contains("()")) {
            s = s.replace("{}", "")
                    .replace("()", "")
                    .replace("[]", "");
        }
        return s.length() == 0;
    }

    public boolean isValid(String s) {
        int openIndex = 0;
        // 获取当前open字符，它的下一个字符必须是对应的close字符。
        while (openIndex < s.length()) {
            char openChar = s.charAt(openIndex);
            char closeChar = s.charAt(openIndex + 1);
            switch (openChar) {
                case '{':
                    if (closeChar != '}') {
                        return false;
                    }
                    break;
                case '[':
                    if (closeChar != ']') {
                        return false;
                    }
                    break;
                case '(':
                    if (closeChar != ')') {
                        return false;
                    }
                    break;
            }

            openIndex += 2;
        }
        return true;
    }

    public static void main(String[] args) {
        Solution0020 a = new Solution0020();
        System.out.println(a.isValid2("]"));
    }
}
