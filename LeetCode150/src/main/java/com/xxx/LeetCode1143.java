package com.xxx;

public class LeetCode1143 {
    // 解法1：2维数组解法
    // 时间复杂度 O(m * n)， 空间复杂度 O(m * n)
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        // 创建DP表格，初始值为0
        int[][] dp = new int[m + 1][n + 1];

        // 填充DP表格
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    // 匹配到了
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }
                else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[m][n];

    }


    // 解法2：1维数组解法
    // 时间复杂度 O(m * n)， 空间复杂度 O(n)
    public int longestCommonSubsequence2(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        // 用一维数组代替二维DP表
        int[] dp = new int[n + 1];

        for (int i = 1; i <= m; i++) {
            int prev = 0; // 用于保存 dp[j-1] 的旧值，等价于 dp[i-1][j-1]
            for (int j = 1; j <= n; j++) {
                int temp = dp[j]; // 先保存当前 dp[j] 的值，以备下一轮循环使用
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[j] = prev + 1; // 当前字符匹配，dp[j] 更新为 dp[i-1][j-1] + 1
                } else {
                    dp[j] = Math.max(dp[j], dp[j - 1]); // 当前字符不匹配，取左边和上边的最大值
                }
                prev = temp; // 更新 prev 为当前 dp[j] 的旧值
            }
        }

        // dp[n] 即为最终结果
        return dp[n];
    }
}
