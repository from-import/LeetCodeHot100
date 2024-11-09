package com.xxx;

public class LeetCode34 {
    public int[] searchRange(int[] nums, int target) {
        if (nums.length == 0) {
            return new int[]{-1, -1};
        }

        int left = 0, right = nums.length - 1;
        int findMe = -1; // 修改 findMe 的初始值

        // 二分查找找到 target 的任意一个位置
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                findMe = mid;
                break;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        // 如果没有找到 target，返回 [-1, -1]
        if (findMe == -1) {
            return new int[]{-1, -1};
        }

        // 扩展 findMe 找到左右边界
        left = findMe;
        right = findMe;

        // 向左扩展边界，找到起始位置
        while (left > 0 && nums[left - 1] == target) {
            left--;
        }

        // 向右扩展边界，找到结束位置
        while (right < nums.length - 1 && nums[right + 1] == target) {
            right++;
        }

        return new int[]{left, right};
    }

    /**
     * 两次二分找左右
     * @param nums
     * @param target
     * @return
     */
    public int[] searchRange2(int[] nums, int target) {
        // 思路 ： 两次二分，分别找到左右边界
        int finalLeft = 0;
        int finalRight = 0;
        if (nums.length == 0) {
            return new int[]{-1, -1};
        }
        // 第1次二分，找到最左边界
        int left = 0;
        int right = nums.length - 1;
        while (right >= left) {
            int mid = left + (right - left) / 2;
            if (nums[mid] >= target){
                right = mid - 1;
            }
            else if (nums[mid] < target) {
                left = mid + 1;
            }
        }
        // 判断 left 是否在数组range 且 nums[left] == target
        if (left <= nums.length - 1 && nums[left] == target){
            finalLeft = left;
        } else {
            return new int[]{-1, -1};
        }

        // 第2次二分，找到最右边界
        left = 0;
        right = nums.length - 1;
        while (right >= left) {
            int mid = left + (right - left) / 2;
            if (nums[mid] <= target){
                left = mid + 1;
            }
            else if (nums[mid] > target) {
                right = mid - 1;
            }
        }
        finalRight = right;
        return new int[]{finalLeft, finalRight};
    }
}
