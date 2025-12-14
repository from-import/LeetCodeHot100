package com.xxx;

public class LeetCode153 {
    public int findMin(int[] nums) {
        int place = findRevPlace(nums);
        return nums[place];
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

    public int findMin2(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int middle = left + (right - left) / 2;
            // if right is sorted
            if (nums[middle] <= nums[right]) {
                right = middle;
            } else {
                left = middle + 1;
            }
        }
        return nums[left];
    }

    public int findMin3(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int minValue = nums[0];
        while (left <= right) {
            int middle = (left + right) / 2;
            // if left is sorted
            if (nums[left] <= nums[middle]) {
                minValue = Math.min(minValue, nums[left]);
                left = middle + 1;
            } else {
                minValue = Math.min(minValue, nums[middle]);
                right = middle - 1;
            }
        }
        return minValue;
    }
}
