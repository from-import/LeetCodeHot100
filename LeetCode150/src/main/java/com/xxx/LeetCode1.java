package com.xxx;

import java.util.HashMap;
import java.util.Map;

public class LeetCode1 {
    public int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length < 2) {
            return new int[]{-1, -1};
        }
        Map<Integer, Integer> sumMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (sumMap.get(nums[i]) != null) {
                return new int[]{i, sumMap.get(nums[i])};
            }
            sumMap.put(target - nums[i], i);
        }
        return new int[]{-1, -1};

    }
}
