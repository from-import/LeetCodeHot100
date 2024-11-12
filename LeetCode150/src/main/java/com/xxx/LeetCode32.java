package com.xxx;

import java.util.Stack;

public class LeetCode32 {
    /*
    遇到左括号 '(' 时，将其索引压入栈。
    遇到右括号 ')' 时，弹出栈顶元素，并检查栈是否为空：
    如果栈为空，说明当前 ')' 没有匹配的 '('，此时将该右括号的索引压入栈，作为新的“无匹配右括号”的位置，用于之后的长度计算。
    如果栈不为空，计算当前的有效长度，即 i - stack.peek()，并更新 maxLength。
     */
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
