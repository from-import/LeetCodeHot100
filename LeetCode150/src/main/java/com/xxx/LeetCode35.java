package com.xxx;

public class LeetCode35 {
    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int place = 0;
        int mid = (right + left) / 2;

        while(right > left){
            mid = (right + left) / 2;
            if(nums[mid] == target){
                return mid;
            }
            else if (nums[mid] < target){
                left = mid + 1; // 注意
            }
            else if (nums[mid] > target){
                right = mid - 1; // 注意
            }

        }
        return (left + right)/2 ;
    }
}
