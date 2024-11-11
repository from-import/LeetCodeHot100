package com.xxx;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode300 {
    // 解法1 DP
    public int lengthOfLIS(int[] nums) {
        int length = nums.length;
        int[] dp = new int[length + 1];
        Arrays.fill(dp,1);

        for (int i = 1; i < length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i])
                    dp[i] = Math.max(dp[i], dp[j] + 1);
            }
        }

        // 找到 dp 数组中的最大值，即为最长递增子序列的长度
        return Arrays.stream(dp).max().getAsInt();
    }

    // 解法2 贪心 + 二分查找
    public int lengthOfLIS2(int[] nums) {
        List<Integer> tails = new ArrayList<>(); // 用于记录每个递增子序列的最小尾部元素

        for (int num : nums) {
            int left = 0, right = tails.size();

            // 二分查找，找到第一个大于等于 num 的位置
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (tails.get(mid) < num) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }

            // 更新 tails 数组
            if (right >= tails.size()) {
                // 没有找到大于等于 num 的元素，添加到末尾
                tails.add(num);
            } else {
                // 找到了，替换该位置元素
                tails.set(right, num);
            }
        }

        // tails 的长度就是最长递增子序列的长度
        return tails.size();
    }
}
