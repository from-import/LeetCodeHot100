package com.xxx;

public class LeetCode238 {
    /**
     * 左侧前缀积 (mid1)：
     *
     *     mid1[i] 表示从 nums[0] 到 nums[i-1] 的乘积，因此 mid1[0] 初始化为 1，因为 nums[0] 没有左侧元素。
     *     每个 mid1[i] 值依赖于前一个 mid1[i - 1] 乘上 nums[i - 1]。
     *
     * 右侧前缀积 (mid2)：
     *
     *     mid2[i] 表示从 nums[i+1] 到 nums[nums.length-1] 的乘积，因此 mid2[nums.length - 1] 初始化为 1，因为 nums[nums.length - 1] 没有右侧元素。
     *     每个 mid2[i] 值依赖于后一个 mid2[i + 1] 乘上 nums[i + 1]。
     *
     * 结果计算：
     *
     *     最后，结果数组 res[i] 的值是 mid1[i] * mid2[i]，即除 nums[i] 之外的所有元素的乘积。
     * @param nums
     * @return
     */
    public int[] productExceptSelf(int[] nums) {
            int[] res = new int[nums.length];
            int[] mid1 = new int[nums.length]; // 左到右的前缀积
            int[] mid2 = new int[nums.length]; // 右到左的前缀积

            mid1[0] = 1;
            for(int i = 1; i < nums.length; i++){
                mid1[i] = mid1[i - 1] * nums[i - 1];
            }

            mid2[nums.length - 1] = 1;  // 因为最后一个位置右侧没有元素，乘积为 1
            for (int i = nums.length - 2; i >= 0; i--) {
                mid2[i] = mid2[i + 1] * nums[i + 1];
            }

            for(int i = 0; i < nums.length; i++){
                res[i] = mid1[i] * mid2[i];
            }
            return res;
        }
}
