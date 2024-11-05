package com.xxx;

public class LeetCode5 {
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 1) {
            return "";
        }

        char[] chars = s.toCharArray();
        String maxString = ""; // 初始化为空字符串
        for (int i = 0; i < s.length(); i++) {
            int left = i, right = i;
            // 单字符为中心的扩展
            while (left >= 0 && right < s.length() && chars[left] == chars[right]) {
                left--;
                right++;
            }
            // 此时的 left 和 right 指向回文串外的元素，所以用 left + 1 和 right - 1 获取回文子串
            if (right - left - 1 > maxString.length()) {
                maxString = s.substring(left + 1, right);
            }

            // 双字符为中心的扩展
            left = i;
            right = i + 1;
            while (left >= 0 && right < s.length() && chars[left] == chars[right]) {
                left--;
                right++;
            }
            if (right - left - 1 > maxString.length()) {
                maxString = s.substring(left + 1, right);
            }
        }
        return maxString;
    }
}
