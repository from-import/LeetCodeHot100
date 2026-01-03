package com.xxx;

public class LeetCode45 {
    public int jump(int[] nums) {
        int count = 0;  // 跳跃次数
        int maxReach = 0;  // 当前跳跃范围的最大可达位置
        int nextMaxReach = 0;  // 下一步的最大可达位置

        for (int i = 0; i < nums.length - 1; i++) {
            nextMaxReach = Math.max(nextMaxReach, i + nums[i]);  // 更新下一步的最大可达位置

            if (i == maxReach) {  // 到达当前跳跃的最远位置
                count++;  // 增加跳跃次数
                maxReach = nextMaxReach;  // 更新跳跃范围

                if (maxReach >= nums.length - 1) {  // 如果已经可以到达或超过终点
                    break;
                }
            }
        }

        return count;
    }

    /**
     * O(n^2)
     */
    public int jump2(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }
        int maxJump = nums[0];
        int index = 0;
        int count = 0;
        while (index < nums.length) {
            count++;
            int value = nums[index];
            int maxReached = nums[index] + index;
            if (maxReached >= nums.length - 1) {
                return count;
            }
            int farIndex = index;

            for (int j = index+1; j <= Math.min(nums.length - 1, index + value); j++) {
                // forEach the value range
                if (nums[j] + j >= maxReached) {
                    maxReached = nums[j] + j;
                    farIndex = j;
                    if (maxReached >= nums.length - 1) {
                        return count + 1;
                    }
                }
            }
            index = farIndex;

        }
        return -1;
    }

    /**
     * O(n)
     */
    public int jump3(int[] nums) {
        int steps = 0, end = 0, farthest = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            farthest = Math.max(farthest, i + nums[i]);
            if (i == end) {
                steps++;
                end = farthest;
            }
        }
        return steps;
    }
}
