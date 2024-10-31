package com.xxx;

import java.util.*;

class LeetCode49 {

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> m = new HashMap<>();

        for (String str : strs) {
            char[] s = str.toCharArray();
            Arrays.sort(s);
            // s 相同的字符串分到同一组
            // m.computeIfAbsent(new String(s), k -> new ArrayList<>()).add(str);

            // 将字符数组 s 转换为字符串 key
            String key = new String(s);
            // 检查 Map 中是否存在 key，如果不存在就放入一个空的 ArrayList
            if (!m.containsKey(key)) {
                m.put(key, new ArrayList<>());
            }
            // 将当前字符串 str 添加到对应的列表中
            m.get(key).add(str);
        }
        return new ArrayList<>(m.values());

    }

}


