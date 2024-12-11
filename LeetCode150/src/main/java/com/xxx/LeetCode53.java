package com.xxx;

public class LeetCode53 {
    // 前缀和解法
    public int maxSubArray(int[] nums) {
        int length = nums.length;
        int[] prefixSum = new int[length];
        int maxNum = Integer.MIN_VALUE;
        int minNum = 0;

        // 构造前缀和数组
        int count = 0;
        int sumNow = 0;
        for (int num : nums) {
            sumNow += num;
            prefixSum[count++] = sumNow;
        }

        // 遍历前缀和数组，找到最大和
        for (int sum : prefixSum) {
            maxNum = Math.max(maxNum, sum - minNum);
            minNum = Math.min(minNum, sum);
        }
        return maxNum;
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
