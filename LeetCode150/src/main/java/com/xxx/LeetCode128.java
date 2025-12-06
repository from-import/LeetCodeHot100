package com.xxx;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class LeetCode128 {
    public int longestConsecutive(int[] nums) {
        int maxValue = 0;
        if (nums.length == 0) {
            return maxValue;
        }
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        for (int val : set) {
            if (set.contains(val - 1)) {
                // 开始计算新的长度
                int curMaxValue = 0;
                while (set.contains(val + 1)) {
                    curMaxValue++;
                }
                maxValue = Math.max(maxValue, curMaxValue);
            }
        }
        return maxValue;

    }
}
