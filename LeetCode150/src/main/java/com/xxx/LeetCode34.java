package com.xxx;

public class LeetCode34 {
    public int[] searchRange(int[] nums, int target) {
        int arg1 = leftBinarySearch(nums, target);
        int arg2 = rightBinarySearch(nums, target) - 1;

        if (arg1 == nums.length || nums[arg1] != target) {
            arg1 = -1;
        }
        if (arg2 == nums.length || arg2 == -1 || nums[arg2] != target) {
            arg2 = -1;
        }

        return new int[]{arg1, arg2};
    }
    public int leftBinarySearch(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            int index = (start + end) / 2;
            int value = nums[index];

            if (value < target) {
                start = index + 1;
            } else {
                end = index - 1;
            }
        }
        return start;
    }
    public int rightBinarySearch(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            int index = (start + end) / 2;
            int value = nums[index];

            if (value > target) {
                end = index - 1;
            } else {
                start = index + 1;
            }
        }
        return start;
    }
}
