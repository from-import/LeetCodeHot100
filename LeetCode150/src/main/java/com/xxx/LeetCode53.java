package com.xxx;

public class LeetCode53 {
    public int maxSubArray(int[] nums) {
        int[] sumNums = new int[nums.length];
        int countNow = 0;
        int count = 0;

        // 构造前缀和array
        for (int num : nums) {
            countNow += num;
            sumNums[count++] = countNow;
        }

        int res = Integer.MIN_VALUE;
        int minSum = 0;

        // 遍历一次前缀和array,维护两个变量：
        // res:最大和
        // minSum:遍历到目前的最小前缀和
        for (int sum : sumNums) {
            res = Math.max(res, sum - minSum);
            minSum = Math.min(minSum, sum);
        }
        return res;
    }
}
