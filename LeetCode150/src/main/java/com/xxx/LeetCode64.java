package com.xxx;

public class LeetCode64 {

    // 方法 1 : 二维dp
    // 时间复杂度：O(m * n) 空间复杂度：O(m * n)
    public int minPathSum(int[][] grid) {
        int[][] dp = new int[grid.length][grid[0].length];

        // 初始化 dp 数组的第一列，累加路径和
        dp[0][0] = grid[0][0];
        for (int i = 1; i < grid.length; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }

        // 初始化 dp 数组的第一行，累加路径和
        for (int j = 1; j < grid[0].length; j++) {
            dp[0][j] = dp[0][j - 1] + grid[0][j];
        }


        for (int i = 1; i < grid.length; i++) {
            for (int j = 1; j < grid[0].length; j++) {
                dp[i][j] = Math.min(dp[i][j-1], dp[i-1][j]) + grid[i][j];
            }
        }
        return dp[grid.length - 1][grid[0].length - 1];
    }

    // 方法 2 : 一维dp
    // 时间复杂度：O(m * n) 空间复杂度：O(n),其中 n 是列数
    public int minPathSum2(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[] dp = new int[n];

        // 初始化 dp 数组的第一个元素
        dp[0] = grid[0][0];

        // 初始化 dp 数组的第一行（左到右）
        for (int j = 1; j < n; j++) {
            dp[j] = dp[j - 1] + grid[0][j];
        }

        // 遍历每一行，并更新 dp 数组
        for (int i = 1; i < m; i++) {
            // 更新每行的第一个元素（只能从上方到达）
            dp[0] += grid[i][0];

            // 更新当前行的其他元素
            for (int j = 1; j < n; j++) {
                dp[j] = Math.min(dp[j], dp[j - 1]) + grid[i][j];
            }
        }

        return dp[n - 1];
    }

}
