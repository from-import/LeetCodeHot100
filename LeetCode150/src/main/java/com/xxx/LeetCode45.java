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
}
