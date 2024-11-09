package com.xxx;

public class LeetCode74 {
    public boolean searchMatrix(int[][] matrix, int target) {
        // 思路：先二分找到行，然后再二分找到列，两次二分解决
        int[] col = halfSearch2(matrix, target);
        return halfSearch(col, target);

    }

    public boolean halfSearch(int[] nums, int target){
        int left = 0;
        int right = nums.length - 1;
        while(right >= left) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target){
                return true;
            }
            else if (nums[mid] > target) {
                right = mid - 1;
            }
            else if (nums[mid] < target) {
                left = mid + 1;
            }
        }
        return false;
    }

    public int[] halfSearch2(int[][] nums, int target){
        int left = 0;
        int right = nums.length - 1;
        while(right >= left) {
            int mid = left + (right - left) / 2;
            if (nums[mid][0] == target){
                return nums[mid];
            }
            else if (nums[mid][0] > target) {
                right = mid - 1;
            }
            else if (nums[mid][0] < target) {
                left = mid + 1;
            }
        }
        return left >= 1 ? nums[left - 1] : nums[left];
    }
}
