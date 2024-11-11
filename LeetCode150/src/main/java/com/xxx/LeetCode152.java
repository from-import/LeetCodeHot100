package com.xxx;

public class LeetCode152 {
    public int maxProduct(int[] nums) {

        int length = nums.length;

        // 初始化 dp 数组
        int[] dpMax = new int[length];
        int[] dpMin = new int[length];

        // 初始值
        dpMax[0] = nums[0];
        dpMin[0] = nums[0];

        // 记录结果
        int maxProduct = nums[0];

        for (int i = 1; i < length; i++) {
            if (nums[i] >= 0) {
                dpMax[i] = Math.max(nums[i], dpMax[i - 1] * nums[i]);
                dpMin[i] = Math.min(nums[i], dpMin[i - 1] * nums[i]);
            } else {
                dpMax[i] = Math.max(nums[i], dpMin[i - 1] * nums[i]);
                dpMin[i] = Math.min(nums[i], dpMax[i - 1] * nums[i]);
            }
            // 更新全局最大值
            maxProduct = Math.max(maxProduct, dpMax[i]);
        }

        return maxProduct;


    }
}
