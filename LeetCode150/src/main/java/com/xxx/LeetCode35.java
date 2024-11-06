package com.xxx;

public class LeetCode35 {
    /**
     * 方法：在排序数组中找到目标值的插入位置
     * 功能：给定一个排序数组和目标值，如果找到目标值则返回其索引，
     *       否则返回它按顺序应该插入的位置。
     */
    public int searchInsert(int[] nums, int target) {
        int left = 0; // 左指针初始化为数组的第一个元素索引
        int right = nums.length - 1; // 右指针初始化为数组的最后一个元素索引
        int mid; // 中间指针，用于二分查找过程中的比较

        // 使用二分查找法，当左指针小于或等于右指针时进行查找
        while (right >= left) {
            mid = (left + right) / 2; // 计算当前中间位置索引

            // 检查中间位置的元素是否等于目标值
            if (nums[mid] == target) {
                return mid; // 如果找到目标值，直接返回它的索引
            } else if (nums[mid] < target) {
                // 如果中间位置的元素小于目标值，则目标值在右半部分
                // 将左指针移动到中间索引的右边
                left = mid + 1;
            } else {
                // 如果中间位置的元素大于目标值，则目标值在左半部分
                // 将右指针移动到中间索引的左边
                right = mid - 1;
            }
        }

        // 循环结束后，left 指针指向的是目标值应插入的位置
        // 如果目标值比数组中所有值都大，left 会在最后一个元素的右边
        return left;
    }
}