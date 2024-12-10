package com.xxx;

import java.util.HashMap;
import java.util.Map;

public class LeetCode76 {
    public String minWindow(String s, String t) {
        // 如果 s 或 t 为空，直接返回空字符串
        if (s == null || s.length() == 0 || t == null || t.length() == 0) {
            return "";
        }

        // 使用两个哈希表，记录 t 中每个字符的需求量和当前窗口中的字符数
        Map<Character, Integer> tMap = new HashMap<>();
        Map<Character, Integer> windowMap = new HashMap<>();

        // 初始化 t 中的字符需求
        for (char c : t.toCharArray()) {
            tMap.put(c, tMap.getOrDefault(c, 0) + 1);
        }

        // 左右指针初始化，满足条件的字符数 `formed` 初始化
        int left = 0, right = 0;
        int formed = 0;
        int required = tMap.size(); // 需要的不同字符数
        int minLength = Integer.MAX_VALUE; // 用于记录最小子串长度
        int minLeft = 0; // 记录最小子串的起始位置

        while (right < s.length()) {
            char c = s.charAt(right);
            windowMap.put(c, windowMap.getOrDefault(c, 0) + 1);
            // 如果当前字符 c 满足了 t 中的需求，`formed` 加 1
            if (tMap.containsKey(c) && windowMap.get(c).intValue() == tMap.get(c).intValue()) {
                formed++;
            }
            // 当 formed 满足 required 时，开始收缩左指针
            while (left <= right && formed == required) {
                // 更新最小窗口
                if (right - left + 1 < minLength) {
                    minLength = right - left + 1;
                    minLeft = left;
                }
                // 收缩left指针
                char leftChar = s.charAt(left);
                windowMap.put(leftChar, windowMap.getOrDefault(leftChar, 0) - 1);
                // 如果左边字符不再满足需求，`formed` 减 1
                if (tMap.containsKey(leftChar) && windowMap.get(leftChar).intValue() < tMap.get(leftChar).intValue()) {
                    formed--;
                }
                left++;
            }
            right++;
        }
        // 根据 minLength 返回结果
        return minLength == Integer.MAX_VALUE ? "" : s.substring(minLeft, minLeft + minLength);
    }

    // 滑动窗口+哈希表
    public static String minWindow2(String s, String t) {
        if (s == null || t == null || s.length() < t.length()) {
            return "";
        }

        // 统计 t 中每个字符的频率
        HashMap<Character, Integer> tCount = new HashMap<>();
        for (char c : t.toCharArray()) {
            tCount.put(c, tCount.getOrDefault(c, 0) + 1);
        }

        // 滑动窗口
        HashMap<Character, Integer> windowCount = new HashMap<>();
        int left = 0, right = 0;
        int required = tCount.size();
        int formed = 0;
        int[] ans = {-1, 0, 0}; // {窗口大小, 左边界, 右边界}

        while (right < s.length()) {
            // 增加右边界字符
            char c = s.charAt(right);
            windowCount.put(c, windowCount.getOrDefault(c, 0) + 1);

            // 如果窗口内某字符的频率满足 t 的要求
            if (tCount.containsKey(c) && windowCount.get(c).intValue() == tCount.get(c).intValue()) {
                formed++;
            }

            // 当窗口内字符频率满足所有要求时，尝试收缩窗口
            while (left <= right && formed == required) {
                c = s.charAt(left);

                // 更新最小窗口
                if (ans[0] == -1 || right - left + 1 < ans[0]) {
                    ans[0] = right - left + 1;
                    ans[1] = left;
                    ans[2] = right;
                }

                // 左边界字符移出窗口
                windowCount.put(c, windowCount.get(c) - 1);
                if (tCount.containsKey(c) && windowCount.get(c).intValue() < tCount.get(c).intValue()) {
                    formed--;
                }

                left++;
            }

            right++;
        }

        return ans[0] == -1 ? "" : s.substring(ans[1], ans[2] + 1);
    }
}

