package com.xxx;

import java.util.ArrayList;
import java.util.List;

public class LeetCode22 {
    private List<String> res = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        backTracking("", 0, 0, n);
        return res;
    }

    void backTracking(String current, int open, int close, int max) {
        // 如果当前字符串长度等于目标长度，将其加入结果集
        if (current.length() == max * 2) {
            res.add(current);
            return;
        }

        // 如果可以添加左括号
        if (open < max) {
            backTracking(current + "(", open + 1, close, max);
        }

        // 如果可以添加右括号
        if (close < open) {
            backTracking(current + ")", open, close + 1, max);
        }
    }
}
