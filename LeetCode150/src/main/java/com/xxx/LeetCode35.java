package com.xxx;

public class LeetCode35 {
    public int searchInsert(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        return lowerBinarySearch(nums, target);
    }

    private int lowerBinarySearch(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int middle = left + (right - left) / 2;
            int middleValue = nums[middle];
            if (middleValue < target) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }
        return left;
    }
}