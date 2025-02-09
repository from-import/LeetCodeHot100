package com.xxx;

import java.util.HashMap;

public class LeetCode1 {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int number = nums[i];
            if (map.get(number) != null) {
                return new int[]{i , map.get(number)};
            }
            map.put(target - number, i);
        }
        return new int[]{0, 0};
    }
}
