package com.xxx;

import java.util.Arrays;

public class LeetCode33 {
    public int search(int[] nums, int target) {
        // per half 1. check if is 单调递增 2. binarySearch
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int middle = (left + right) / 2;
            if (nums[middle] == target) {
                return middle;
            }

            // if left if sorted
            if (nums[left] < nums[middle]) {

                // check if value is at the part
                if (nums[left] < target && target < nums[middle]) {
                    right = middle - 1;
                } else {
                    left = middle + 1;
                }
            } else {
                // right is sorted
                // check if value is at the part
                if (nums[middle] < target && target < nums[right]) {
                    left = middle + 1;
                } else {
                    right = middle - 1;
                }
            }
        }
        return left;
    }

}
