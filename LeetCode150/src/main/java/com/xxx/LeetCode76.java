package com.xxx;

import java.util.HashMap;
import java.util.Map;

public class LeetCode76 {
    public String minWindow(String s, String t) {
        if (t.length() > s.length()) return "";

        int left = 0;
        int right = 0;

        // init target
        Map<Character, Integer> need = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            need.put(c, need.getOrDefault(c, 0) + 1);
        }

        String result = "";
        Integer length  = Integer.MAX_VALUE;

        Map<Character, Integer> window = new HashMap<>();
        while (right < s.length()) {
            while (!covers(window, need) && right < s.length()) {
                window.put(s.charAt(right), window.getOrDefault(s.charAt(right), 0) + 1);
                right++;
            }

            while (covers(window, need)) {

                if (right - left < length) {
                    result = s.substring(left, right);
                    length = result.length();
                }

                if (window.get(s.charAt(left)) == 1) {
                    window.remove(s.charAt(left));
                } else {
                    window.put(s.charAt(left), window.get(s.charAt(left)) - 1);
                }

                left++;
            }

        }

        return result;
    }

    private boolean covers(Map<Character, Integer> window, Map<Character, Integer> need) {
        for (Map.Entry<Character, Integer> e : need.entrySet()) {
            char c = e.getKey();
            int needCnt = e.getValue();
            int winCnt = window.getOrDefault(c, 0);
            if (winCnt < needCnt) return false;
        }
        return true;
    }
}

