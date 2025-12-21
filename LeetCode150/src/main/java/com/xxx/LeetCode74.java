package com.xxx;

public class LeetCode74 {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0) {
            return false;
        }
        int[] firstCol = new int[matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            firstCol[i] = matrix[i][0];
        }
        int firstColLowerThanTarget = upperBinarySearch(firstCol, target) - 1;
        if (firstColLowerThanTarget < 0) {
            return false;
        }
        int left = 0;
        int right = matrix[firstColLowerThanTarget].length - 1;

        while (left <= right) {
            int middle = left + (right - left) / 2;
            int value = matrix[firstColLowerThanTarget][middle];
            if (value >= target) {
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }
        if (left >= matrix[firstColLowerThanTarget].length) {
            return false;
        }
        return matrix[firstColLowerThanTarget][left] == target;

    }
    private int upperBinarySearch(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int middle = left + (right - left) / 2;
            int middleValue = nums[middle];
            if (middleValue > target) {
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }
        return left;
    }

}
