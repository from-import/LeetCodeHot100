package com.xxx;

import java.util.HashMap;
import java.util.Map;

public class LeetCode560 {
    // 暴力方法，时间复杂度O(n^2)
    public int subarraySum1(int[] nums, int k) {
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

    public int subarraySum3(int[] nums, int k) {
        int[] prefix = new int[nums.length];
        prefix[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            prefix[i] = prefix[i - 1] + nums[i];
        }

        Map<Integer, Integer> count = new HashMap<>();
        count.put(0, 1);
        int res = 0;

        for (int pre : prefix) {
            res += count.getOrDefault(pre - k, 0);
            count.put(pre, count.getOrDefault(pre, 0) + 1);
        }
        return res;

    }
}
