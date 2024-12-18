package com.xxx;

public class LeetCode41 {
    public int firstMissingPositive(int[] nums) {
        int length = nums.length;

        for (int i = 0; i < length; i++) {
            // 遍历数组中的每一个元素，i 是当前元素的索引
            while (nums[i] > 0 && nums[i] < length && nums[i] != nums[nums[i] - 1]) {
                // 1. nums[i] > 0：跳过非正数（负数或零），因为我们只关心正整数。
                // 2. nums[i] < length：如果 nums[i] >= length，说明它超出范围，跳过处理。
                // 3. nums[i] != nums[nums[i] - 1]：检查当前数字 nums[i] 是否已经放在正确位置。
                //    - nums[i] 应该在索引 nums[i] - 1 的位置上。

                // 如果以上条件都满足，就交换 nums[i] 和 nums[nums[i] - 1]，将当前数字放到它的目标位置。
                swap(nums, i, nums[i] - 1);
            }
        }
        for (int i = 0; i < length; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        return length + 1;
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
