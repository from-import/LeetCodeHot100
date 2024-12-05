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

    // 笨点的方法
    public int lengthOfLongestSubstring2(String s) {
        if (s.length() == 0) {
            return 0;
        }
        int maxLength = 1;
        HashSet<Character> set = new HashSet<>();
        char[] string = s.toCharArray();
        int length = string.length;
        int left = 0;
        int right = 1;
        set.add(string[left]);
        while(right < length) {
            if (set.contains(string[right])) {
                while(string[left] != string[right]) {
                    set.remove(string[left]);
                    left++;
                }
                left++;
            }
            maxLength = Math.max(maxLength, right - left + 1);
            set.add(string[right]);
            right++;
        }

        return maxLength;
    }
}
