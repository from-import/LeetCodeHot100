package com.xxx;

public class LeetCode34 {
    public int[] searchRange(int[] nums, int target) {
        int arg1 = lowerBinarySearch(nums, target);
        int arg2 = upperBinarySearch(nums, target) - 1;

        if (arg1 == nums.length || nums[arg1] != target) {
            arg1 = -1;
        }
        if (arg2 == nums.length || arg2 == -1 || nums[arg2] != target) {
            arg2 = -1;
        }

        return new int[]{arg1, arg2};
    }

    // return first place > t
    private int upperBinarySearch(int[] nums, int target) {
        int length = nums.length;
        int left = 0;
        int right = length - 1;
        while (left <= right) {
            int index = (left + right) / 2;
            int value = nums[index];
            if (value <= target) {
                left = index + 1;
            } else {
                right = index - 1;
            }

        }
        return left;
    }

    // return first place ≥ t
    private int lowerBinarySearch(int[] nums, int target) {
        int length = nums.length;
        int left = 0;
        int right = length - 1;
        while (left <= right) {
            int index = (left + right) / 2;
            int value = nums[index];
            if (value >= target) {
                right = index - 1;
            } else {
                left = index + 1;
            }
        }
        return left;
    }
}
