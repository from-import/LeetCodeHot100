package com.xxx;

public class LeetCode416 {
    public boolean canPartition(int[] nums) {
        int totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }

        // 如果总和为奇数，不能分成两个和相等的子集
        if (totalSum % 2 != 0) {
            return false;
        }

        int target = totalSum / 2;
        boolean[] dp = new boolean[target + 1];
        dp[0] = true; // 和为0的子集总是存在的，即空集

        for (int num : nums) {
            for (int j = target; j >= num; j--) {
                dp[j] = dp[j] || dp[j - num];
            }
        }

        return dp[target];
    }
}
