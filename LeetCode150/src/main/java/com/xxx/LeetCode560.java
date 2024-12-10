package com.xxx;

import java.util.HashMap;

public class LeetCode560 {
    // 暴力方法，时间复杂度O(n^2)
    public int subarraySum(int[] nums, int k) {
        int target = 0;
        for (int i = 0; i < nums.length; i++) {
            int sumNow = 0;
            for (int j = i; j < nums.length; j++) {
                sumNow += nums[j];
                if (sumNow == k) {
                    target += 1;
                }
            }
        }
        return target;
    }

    public int subarraySum2(int[] nums, int k) {
        int target = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0,1);
        int count = 0;
        int currentSum = 0;
        for (int num : nums) {
            currentSum += num;
            if (null != map.get(currentSum - k)) {
                count += map.get(currentSum - k);
            }
            // 更新哈希表中当前前缀和的出现次数
            map.put(currentSum, map.getOrDefault(currentSum, 0) + 1);
        }
        return count;
    }
}
