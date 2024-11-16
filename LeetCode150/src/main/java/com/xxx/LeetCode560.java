package com.xxx;

import java.util.HashMap;

public class LeetCode560 {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> prefixSumCount = new HashMap<>();
        prefixSumCount.put(0, 1); // 初始条件：前缀和为 0 出现 1 次
        int currentSum = 0; // 当前前缀和
        int count = 0; // 记录子数组个数
        for (int num : nums) {
            currentSum += num;
            if (null != prefixSumCount.get(currentSum - k)) {
                count += prefixSumCount.get(currentSum - k);
            }

            // 更新哈希表中当前前缀和的出现次数
            prefixSumCount.put(currentSum, prefixSumCount.getOrDefault(currentSum, 0) + 1);

        }
        return count ;
    }
}
