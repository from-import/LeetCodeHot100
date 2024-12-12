package com.xxx;

public class LeetCode189 {
    // 空间复杂度 O(n)
    public void rotate(int[] nums, int k) {
        if (k > nums.length) {
            k = k % nums.length;
        }
        int place = nums.length - k;
        int[] res = new int[nums.length];
        for (int i = 0; i < k; i++) {
            res[i] = nums[place++];
        }
        for (int i = 0; i < nums.length - k; i++) {
            res[k + i] = nums[i];
        }
        int count = 0;
        for (int num : res) {
            nums[count++] = num;
        }
    }
}
