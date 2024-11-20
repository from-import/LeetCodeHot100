package com.xxx;

import java.util.HashMap;

public class LeetCode1 {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (null != map.get(target - nums[i])) {
                // 找到了可以配对的数
                return new int[]{i, map.get(target - nums[i])};
            }
            map.put(nums[i], i);
        }
        return new int[]{0, 0};
    }
}
