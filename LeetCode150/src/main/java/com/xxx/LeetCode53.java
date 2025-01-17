package com.xxx;

public class LeetCode53 {
    // 前缀和解法
    public int maxSubArray(int[] nums) {
        int length = nums.length;
        int res = nums[0];
        int[] prefixSum = new int[length];
        prefixSum[0] = nums[0];

        for (int i = 1; i < length; i++) {
            prefixSum[i] = prefixSum[i - 1] + nums[i];
        }

        int minSum = 0;
        for (int i = 0; i < length; i++) {
            res = Math.max(res, prefixSum[i] - minSum);
            minSum = Math.min(minSum, prefixSum[i]);
        }
        return res;
    }

    // dp 解法
    public int maxSubArray2(int[] nums) {
        // dp实现最大连续子数组和
        int length = nums.length;
        int[] dp = new int[length];
        dp[0] = nums[0];
        int maxSum = dp[0]; // 初始化最大和

        for (int i = 1; i < length; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
            maxSum = Math.max(maxSum, dp[i]);
        }
        return maxSum;
    }
}
