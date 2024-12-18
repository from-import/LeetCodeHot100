package com.xxx;

public class LeetCode73 {
    public void setZeroes(int[][] matrix) {
        boolean firstRow = false;
        boolean firstCol = false;
        for (int i = 0; i < matrix[0].length; i++) {
            if (matrix[0][i] == 0) {
                firstRow = true;
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][0] == 0) {
                firstCol = true;
            }
        }

        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }

        for (int i = 1; i < matrix[0].length; i++) {
            if (matrix[0][i] == 0) {
                setZeroCol(matrix, i);
            }
        }
        for (int i = 1; i < matrix.length; i++) {
            if (matrix[i][0] == 0) {
                setZeroRow(matrix, i);
            }
        }

        // 如果第一行需要置零
        if (firstRow) {
            setZeroRow(matrix, 0);
        }

        // 如果第一列需要置零
        if (firstCol) {
            setZeroCol(matrix, 0);
        }


    }

    // 将指定行的所有列设置为 0
    public void setZeroRow(int[][] matrix, int row) {
        for (int i = 0; i < matrix[0].length; i++) { // 遍历列
            matrix[row][i] = 0; // 修改当前行的每一列
        }
    }

    // 将指定列的所有行设置为 0
    public void setZeroCol(int[][] matrix, int col) {
        for (int i = 0; i < matrix.length; i++) { // 遍历行
            matrix[i][col] = 0; // 修改当前列的每一行
        }
    }

}
