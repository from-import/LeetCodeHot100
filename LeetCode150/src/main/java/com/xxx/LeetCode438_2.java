package com.xxx;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class LeetCode438_2 {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        if (s.length() < p.length()) {
            return res;
        }

        // 统计 p 中各字符的频率
        int[] pCount = new int[26];
        for (char c : p.toCharArray()) {
            pCount[c - 'a']++;
        }

        // 初始化滑动窗口的字符频率
        int[] sCount = new int[26];
        for (int i = 0; i < p.length(); i++) {
            sCount[s.charAt(i) - 'a']++;
        }

        // 检查初始窗口是否是异位词
        if (Arrays.equals(sCount, pCount)) {
            res.add(0);
        }

        // 滑动窗口：从索引 p.length() 开始，逐步向右移动
        for (int i = p.length(); i < s.length(); i++) {
            // 加入新字符到窗口
            sCount[s.charAt(i) - 'a']++;
            // 移除窗口的第一个字符
            sCount[s.charAt(i - p.length()) - 'a']--;

            // 检查窗口是否匹配
            if (Arrays.equals(sCount, pCount)) {
                res.add(i - p.length() + 1);
            }
        }
        return res;
    }
}
