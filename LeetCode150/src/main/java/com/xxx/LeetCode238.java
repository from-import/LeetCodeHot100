package com.xxx;

public class LeetCode238 {
    public int[] productExceptSelf(int[] nums) {
        // pre[i] 应该是 nums[0] 到 nums[i-1] 的乘积（不包括 nums[i]）
        // last[i] 应该是 nums[i+1] 到 nums[length-1] 的乘积（不包括 nums[i]）
        int length = nums.length;
        int[] pre = new int[length];
        int[] last = new int[length];
        pre[0] = 1;
        last[length - 1] = 1;

        for (int i = 1; i < length; i++) {
            pre[i] = pre[i - 1] * nums[i - 1];
        }

        for (int i = length - 2; i >= 0 ; i--) {
            last[i] = last[i + 1] * nums[i + 1];
        }

        int[] answer = new int[length];
        for (int i = 0; i < length; i++) {
            answer[i] = pre[i] * last[i];
        }
        return answer;
    }

    // O(1)空间复杂度实现(无额外空间消耗)
    public int[] productExceptSelf2(int[] nums) {
        // pre[i] 应该是 nums[0] 到 nums[i-1] 的乘积（不包括 nums[i]）
        // last[i] 应该是 nums[i+1] 到 nums[length-1] 的乘积（不包括 nums[i]）
        int length = nums.length;
        int[] answer = new int[length];
        answer[0] = 1;
        answer[length - 1] = 1;

        for (int i = 1; i < length; i++) {
            answer[i] = answer[i - 1] * nums[i - 1];
        }
        // 用一个变量 suffix 计算后缀积并直接累乘到 answer
        int suffix = 1;
        for (int i = length - 1; i >= 0 ; i--) {
            answer[i] *= suffix;
            suffix *= nums[i];
        }

        return answer;
    }
}
