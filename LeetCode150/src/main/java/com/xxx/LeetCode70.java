package com.xxx;

public class LeetCode70 {
    // LogN 时间复杂度 ，矩阵快速幂法求解
    public int climbStairs(int n) {
        // 特判
        if (n < 2) {
            return n;
        }

        // 初始转移矩阵 M
        int[][] M = {{1, 1},
                {1, 0}};

        // 计算 M^n
        int[][] Mn = matrixPower(M, n);

        // 矩阵 M^n 的 (0,0) 元素即为 F_{n+1}，也是题目要求的结果
        return Mn[0][0];
    }

    /**
     * 快速幂：计算矩阵 m 的 n 次方
     * 时间复杂度 O(log n)
     */
    private int[][] matrixPower(int[][] m, int n) {
        // 创建 2×2 单位矩阵 I
        int[][] result = {{1, 0},
                {0, 1}};

        int[][] base = m;

        while (n > 0) {
            // 如果当前 n 为奇数，则先乘一次 base
            if ((n & 1) == 1) {
                result = multiply(result, base);
            }
            // base 自身平方
            base = multiply(base, base);
            // n 右移一位，相当于整除 2
            n >>= 1;
        }

        return result;
    }

    /**
     * 2×2 矩阵乘法
     */
    private int[][] multiply(int[][] a, int[][] b) {
        int[][] c = new int[2][2];
        c[0][0] = a[0][0] * b[0][0] + a[0][1] * b[1][0];
        c[0][1] = a[0][0] * b[0][1] + a[0][1] * b[1][1];
        c[1][0] = a[1][0] * b[0][0] + a[1][1] * b[1][0];
        c[1][1] = a[1][0] * b[0][1] + a[1][1] * b[1][1];
        return c;
    }
}
