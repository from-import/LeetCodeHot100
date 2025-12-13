package com.xxx;

public class LeetCode74 {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || target < matrix[0][0]) {
            return false;
        }

        // 找到第一列的第一个比target小的数的位置
        int[] tempMartix = new int[matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            tempMartix[i] = matrix[i][0];
        }
        int row = upperBinarySearch(tempMartix, target) - 1;
        if (row == -1) {
            return false;
        }

        int col = lowerBinarySearch(matrix[row], target);
        return (col < matrix[0].length && matrix[row][col] == target);
    }

    // 返回第一个 > t 的位置
    private int upperBinarySearch(int[] nums, int target) {
        int length = nums.length;
        int left = 0;
        int right = length - 1;
        while (left <= right) {
            int index = (left + right) / 2;
            int value = nums[index];
            if (value <= target) {
                left = index + 1;
            } else {
                right = index - 1;
            }

        }
        return left;
    }

    // 返回第一个 ≥ t 的位置
    private int lowerBinarySearch(int[] nums, int target) {
        int length = nums.length;
        int left = 0;
        int right = length - 1;
        while (left <= right) {
            int index = (left + right) / 2;
            int value = nums[index];
            if (value >= target) {
                right = index - 1;
            } else {
                left = index + 1;
            }
        }
        return left;
    }

}
