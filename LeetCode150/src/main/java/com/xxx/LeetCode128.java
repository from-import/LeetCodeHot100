package com.xxx;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

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

    public int longestConsecutive2(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        Set<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            numSet.add(num);
        }

        int maxLength = 1;
        for (int num : numSet) {
            if (!numSet.contains(num - 1)) {
                int current = num;
                int currentLength = 1;
                while (numSet.contains(current + 1)) {
                    currentLength++;
                    current++;
                }
                maxLength = Math.max(maxLength, currentLength);
            }
        }
        return maxLength;

    }
}
