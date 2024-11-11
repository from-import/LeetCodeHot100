package com.xxx;

public class LeetCode72 {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int[][] dp = new int[m + 1][n + 1];

        // 初始化边界条件
        for (int i = 0; i <= m; i++) {
            dp[i][0] = i; // 需要 i 次删除操作
        }
        for (int j = 0; j <= n; j++) {
            dp[0][j] = j; // 需要 j 次插入操作
        }

        // 填充 DP 表格
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    // 如果 word1[i-1] == word2[j-1]，那么不需要任何操作，只需看看 dp[i-1][j-1]。
                    dp[i][j] = dp[i - 1][j - 1];
                }
                else {
                    // 如果 word1[i-1] != word2[j-1]，那么我们需要做一次操作：插入、删除或替换，然后基于之前的最小操作数计算出最少的操作次数。
                    dp[i][j] = Math.min(dp[i - 1][j] + 1, // 删除
                            Math.min(dp[i][j - 1] + 1, // 插入
                                    dp[i - 1][j - 1] + 1)); // 替换
                }
            }
        }
        // 最终结果
        return dp[m][n];
    }
}
