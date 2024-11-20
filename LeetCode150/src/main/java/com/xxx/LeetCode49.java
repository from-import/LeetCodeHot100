package com.xxx;

import java.util.*;

class LeetCode49 {

    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        HashMap<Integer, List<String>> map = new HashMap<>();

        for (String s : strs) {
            int hashKey = wordToHash(s);

            // 如果不存在键，初始化对应的列表
            if (!map.containsKey(hashKey)) {
                map.put(hashKey, new ArrayList<>());
            }

            map.get(hashKey).add(s);
        }

        // 遍历 HashMap，将每个分组添加到结果列表
        for (Map.Entry<Integer, List<String>> entry : map.entrySet()) {
            res.add(entry.getValue()); // 只需要分组的值部分
        }

        return res; // 返回分组结果
    }

    public int wordToHash(String s) {
        char[] res = s.toCharArray();
        Arrays.sort(res);
        String finalString = new String(res);
        return finalString.hashCode();
    }


}


