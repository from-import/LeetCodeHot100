package com.xxx;

import java.util.ArrayList;
import java.util.List;

public class LeetCode131 {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        List<String> path = new ArrayList<>();
        backTracking(s, 0, path, res);
        return res;
    }

    private void backTracking(String s, int start, List<String> path, List<List<String>> res) {
        // 如果起始索引到达字符串末尾，说明找到了一种分割方案
        if (start == s.length()) {
            res.add(new ArrayList<>(path));
            return;
        }

        // 从当前起始索引开始，尝试分割每个可能的子串
        for (int end = start; end < s.length(); end++) {
            // 如果当前子串为回文
            if (isPalindrome(s, start, end)) {
                path.add(s.substring(start, end + 1));

                // 需要从当前被分割子串的末尾的下一个位置继续处理剩余部分
                // 因此是end + 1 而不是 start + 1
                backTracking(s, end + 1, path, res);
                path.remove(path.size() - 1);

            }
            continue;
        }
    }

    // 判断子串 s[start:end] 是否是回文
    private boolean isPalindrome(String s, int start, int end) {
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
