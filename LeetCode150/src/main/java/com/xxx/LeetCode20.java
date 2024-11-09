package com.xxx;

import java.util.Stack;

public class LeetCode20 {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            // 如果是左括号，压入栈中
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else {
                // 如果是右括号，检查栈是否为空并进行匹配
                if (stack.isEmpty()) return false; // 栈为空则不匹配

                char top = stack.pop();
                if (c == ')' && top != '(') return false;
                if (c == ']' && top != '[') return false;
                if (c == '}' && top != '{') return false;
            }
        }
        return true;
    }
}
