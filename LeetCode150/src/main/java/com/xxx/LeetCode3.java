package com.xxx;

import java.util.HashSet;
import java.util.Set;

public class LeetCode3 {
    public int lengthOfLongestSubstring(String s) {
        int length = 0;
        int left = 0;
        int res = 0;
        Set<Character> set = new HashSet<>(); // 用于存储当前窗口的字符
        for(int right = 0; right < s.length(); right++){
            // 如果当前字符重复
            while(set.contains(s.charAt(right))){
                set.remove(s.charAt(left));
                left++;
            }

            // 如果当前字符不重复
            if(!set.contains(s.charAt(right))){
                set.add(s.charAt(right));
            }
            length = right - left + 1;
            res = Math.max(res, length);
        }
        // Go
        return res;
    }
}
