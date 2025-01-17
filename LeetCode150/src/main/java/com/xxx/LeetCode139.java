package com.xxx;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LeetCode139 {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordSet = new HashSet<>(wordDict);  // 将 wordDict 转为 HashSet 以加快查找速度
        int[] dp = new int[s.length() + 1];
        int length = s.length();
        dp[0] = 1;
        for (int i = 1; i <= length; i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] == 1 && wordSet.contains(s.substring(j, i))) {
                    dp[i] = 1;
                    break;  // 发现一个满足条件的 j，说明 dp[i] 可以为 true，退出内层循环
                }
            }

        }
        return dp[length] == 1 ? true : false;
    }

    // 添加同类型题目 ： 要求找到有多少种拼接的可能性？
    public int wordBreakCount(String s, List<String> wordDict) {
        Set<String> wordSet = new HashSet<>(wordDict);  // 将 wordDict 转为 HashSet 加速查找
        int[] dp = new int[s.length() + 1];
        dp[0] = 1;  // 空字符串有一种方式（什么都不拼接）

        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] > 0 && wordSet.contains(s.substring(j, i))) {
                    dp[i] += dp[j];  // 将 dp[j] 的值累加到 dp[i]
                }
            }
        }

        return dp[s.length()];
    }
}
