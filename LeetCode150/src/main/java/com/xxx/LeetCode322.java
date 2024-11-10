package com.xxx;

public class LeetCode322 {
    public int coinChange(int[] coins, int amount) {

        // 初始化dp数组
        int[] dp = new int[amount + 1];
        for (int i = 1; i <= amount; i++) {
            dp[i] = amount + 1; // 这里用一个不可能的高值初始化，类似于"无穷大"
        }
        dp[0] = 0; // 0金额时，硬币数为0

        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++){
                int price = coins[j];
                if (price <= i) { // 硬币面值不能超过当前金额
                    dp[i] = Math.min(dp[i], dp[i - price] + 1);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }
}
