package com.xxx;

public class LeetCode240 {
    // 鉴定为数学题
    public boolean searchMatrix(int[][] matrix, int target) {
        int i = matrix.length - 1, j = 0;
        int length1 = matrix[0].length;
        while(i >= 0 && j < length1)
        {
            if(matrix[i][j] > target) i--;
            else if(matrix[i][j] < target) j++;
            else return true;
        }
        return false;
    }
}
