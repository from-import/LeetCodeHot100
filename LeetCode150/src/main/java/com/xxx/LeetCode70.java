package com.xxx;

public class LeetCode70 {
    // LogN 时间复杂度 ，矩阵快速幂法求解
    public int climbStairs(int n) {
        if (n < 2) return n;
        int[][] M = {{1, 1}, {1, 0}};
        return matrixPower(M, n)[0][0];
    }

    private int[][] matrixPower(int[][] m, int n) {
        int[][] res = {{1, 0}, {0, 1}};
        while (n > 0) {
            if ((n & 1) == 1) res = multiply(res, m);
            m = multiply(m, m);
            n >>= 1;
        }
        return res;
    }

    private int[][] multiply(int[][] a, int[][] b) {
        return new int[][]{
                {a[0][0] * b[0][0] + a[0][1] * b[1][0], a[0][0] * b[0][1] + a[0][1] * b[1][1]},
                {a[1][0] * b[0][0] + a[1][1] * b[1][0], a[1][0] * b[0][1] + a[1][1] * b[1][1]}
        };
    }
}
