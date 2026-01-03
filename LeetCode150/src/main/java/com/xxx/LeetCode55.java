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

    public boolean canJump2(int[] nums) {
        int far = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > far) {
                return false;
            }
            far = Math.max(far, i + nums[i]);
            if (far >= nums.length - 1) {
                return true;
            }
        }
        return false;

    }
}
