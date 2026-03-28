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

    public int maxSubArray3(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        int[] prefix = new int[nums.length];
        prefix[0] = nums[0];

        for (int i = 1; i < nums.length; i++) {
            prefix[i] = prefix[i-1] + nums[i];
        }

        int[] minPrefix = new int[prefix.length];
        int minPrefixValue = prefix[0];
        for (int i = 0; i < prefix.length; i++) {
            minPrefixValue = Math.min(prefix[i], minPrefixValue);
            minPrefix[i] = minPrefixValue;
        }

        int result = nums[0];
        for (int i = 0; i < prefix.length; i++) {
            result = Math.max(prefix[i], result);
            if (i > 0) {
                int value = prefix[i] - minPrefix[i-1];
                result = Math.max(result, value);
            }
        }
        return result;
    }
}
