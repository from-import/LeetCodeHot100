package com.xxx;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.*;

class LeetCode438 {

    public List<Integer> findAnagrams(String s, String p) {
        if (p.length() > s.length()) {
            return Collections.emptyList();
        }

        Map<Character, Integer> targetMap = new HashMap<>();
        for (int i = 0; i < p.length(); i++) {
            targetMap.put(p.charAt(i), targetMap.getOrDefault(p.charAt(i), 0) + 1);
        }

        Map<Character, Integer> charMap = new HashMap<>();
        for (int i = 0; i < p.length(); i++) {
            charMap.put(s.charAt(i), charMap.getOrDefault(s.charAt(i), 0) + 1);
        }

        int left = 0;
        List<Integer> result = new ArrayList<>();

        if (charMap.equals(targetMap)) {
            result.add(left);
        }

        for (int right = p.length(); right < s.length(); right++) {
            if (charMap.get(s.charAt(left)) == 1) {
                charMap.remove(s.charAt(left));
            } else {
                charMap.put(s.charAt(left), charMap.get(s.charAt(left)) - 1);
            }
            left++;

            charMap.put(s.charAt(right), charMap.getOrDefault(s.charAt(right), 0) + 1);

            if (charMap.equals(targetMap)) {
                result.add(left);
            }

        }
        return result;


    }

}
