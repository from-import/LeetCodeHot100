package com.xxx;

import java.util.*;

class LeetCode49 {

    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        // 一次遍历，按照sort后的char[]作为key填入map
        // 如果为null，new一个List<String>
        // 如果不为null，.add
        for (String s : strs) {
            char[] arrayString = s.toCharArray();
            Arrays.sort(arrayString);
            String mid = new String(arrayString);
            if (map.get(mid) == null) {
                List<String> res = new ArrayList<>();
                res.add(s);
                map.put(mid, res);
            }
            else {
                map.get(mid).add(s);
            }
        }

        List<List<String>> result = new ArrayList<>();
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            result.add(entry.getValue());
        }
        return result;

    }



    public List<List<String>> groupAnagrams2(String[] strs) {
        if (strs.length == 0) {
            return new ArrayList<>();
        }
        Map<String, List<String>> resultMap = new HashMap<>();
        for (String str : strs) {
            char[] keyCharacter = str.toCharArray();
            Arrays.sort(keyCharacter);

            List<String> strings = resultMap.computeIfAbsent(
                    new String(keyCharacter), k -> new ArrayList<>());
            strings.add(str);
        }

        return new ArrayList<>(resultMap.values());
    }


}


