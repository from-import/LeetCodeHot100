package com.xxx;

import java.util.Stack;

public class LeetCode32 {
    public int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        int maxLength = 0;
        stack.push(-1);  // 初始状态，表示无匹配的右括号索引
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                stack.push(i);
            }
            else {
                stack.pop();
                // 弹出后判断是否为空
                if (stack.isEmpty()) {
                    stack.push(i); // 不存在左括号了，将右括号索引入栈，有效长度更新
                }
                else {
                    // 栈不为空，计算有效长度
                    int length = i - stack.peek();
                    maxLength = Math.max(length, maxLength);
                }
            }
        }
        return maxLength;
    }
}
