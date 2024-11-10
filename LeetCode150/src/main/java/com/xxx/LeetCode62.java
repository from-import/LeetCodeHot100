package com.xxx;

public class LeetCode62 {
    // 方法 1 : 动态规划
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];

        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int j = 0; j < n; j++) {
            dp[0][j] = 1;
        }

        // 填充 dp 数组，从 (1, 1) 开始
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++){
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }

    // 方法 2 : 组合数学
    public int uniquePaths2(int m, int n) {
        long result = 1;
        for (int i = 0; i < Math.min(m - 1, n - 1); i++) {
            result = result * (m + n - 2 - i) / (i + 1);
        }
        return (int) result;
    }
}
