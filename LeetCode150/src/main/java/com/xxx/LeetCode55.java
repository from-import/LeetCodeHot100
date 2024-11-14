package com.xxx;

public class LeetCode55 {
    public static boolean canJump(int[] nums) {
        int maxReach = 0;
        for (int i = 0; i < nums.length; i++) {
            maxReach = Math.max(maxReach, i + nums[i]);
            if (maxReach >= nums.length - 1) {
                return true;
            }
            if (maxReach == i) {
                return false;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2,0,0};
        System.out.println(canJump(nums));
    }
}
