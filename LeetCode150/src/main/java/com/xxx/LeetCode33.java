package com.xxx;

import java.util.Arrays;

public class LeetCode33 {
    public int search(int[] nums, int target) {
        // 思路：找到翻转的点，然后分为翻转前半部分和翻转后半部分，分别二分查找
        int place = findRevPlace(nums);
        // 分割为 [0 : mid) 和 [mid : length)
        int[] leftPart = Arrays.copyOfRange(nums, 0, place);
        int[] rightPart = Arrays.copyOfRange(nums, place, nums.length);
        int res1 = halfSearch(leftPart, target);
        int res2 = halfSearch(rightPart, target);
        if (res1 != -1) {
            return res1;
        } else {
            return res2 == -1 ? -1 : leftPart.length + res2;
        }
    }

    // 函数用于找到翻转的点
    public int findRevPlace(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        // 如果数组没有旋转，比如 [1, 2, 3, 4, 5]
        if (nums[left] <= nums[right]) {
            return 0;
        }

        while (left <= right) {
            int mid = left + (right - left) / 2;

            // 找到翻转点：`nums[mid] > nums[mid + 1]`
            if (mid < nums.length - 1 && nums[mid] > nums[mid + 1]) {
                return mid + 1;
            }

            // 如果 `nums[mid] >= nums[left]`，说明 `mid` 在左侧递增部分
            if (nums[mid] >= nums[left]) {
                left = mid + 1;
            } else {
                // 否则 `mid` 在右侧递增部分
                right = mid - 1;
            }
        }

        return 0; // 未找到翻转点，数组未旋转
    }

    // 函数用于二分查找target下标，未找到则return -1
    public int halfSearch(int nums[], int target){
        int left = 0;
        int right = nums.length - 1;
        while (right >= left) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            else if (nums[mid] > target) {
                right = mid - 1;
            }
            else if (nums[mid] < target) {
                left = mid + 1;
            }
        }
        return -1;
    }
}
