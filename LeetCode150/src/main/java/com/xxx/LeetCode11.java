package com.xxx;

public class LeetCode11 {
    public int maxArea(int[] height) {
        int length = height.length;
        int left = 0;
        int right = length - 1;
        int maxWater = 0;

        while (right > left) {
            int water = (right - left) * Math.min(height[left], height[right]);
            maxWater = Math.max(maxWater, water);
            if (height[left] > height[right]) {
                right--;
            }
            else {
                left++;
            }
        }
        return maxWater;
    }
}
