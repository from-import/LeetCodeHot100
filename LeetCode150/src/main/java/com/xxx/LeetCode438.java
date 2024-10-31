package com.xxx;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class LeetCode438 {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        if (s.length() < p.length()) {
            return res;
        }

        // 正确初始化 target 为 p 排序后的字符串
        char[] pArr = p.toCharArray();
        Arrays.sort(pArr);
        String target = new String(pArr);

        // 遍历 s 的子串
        for (int i = 0; i <= s.length() - p.length(); i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = i; j < i + p.length(); j++) {
                sb.append(s.charAt(j));
            }
            String str = sb.toString();
            char[] saveStr = str.toCharArray();
            Arrays.sort(saveStr);

            // 将 saveStr 转为字符串后进行内容比较
            if (new String(saveStr).equals(target)) {
                res.add(i);
            }
        }
        return res;
    }
}
