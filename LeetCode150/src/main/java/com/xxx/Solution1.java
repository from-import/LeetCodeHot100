package com.xxx;

public class Solution1 {
    // 最简单的实现,时间复杂度较高

    public static boolean isAlwaysWin(int N, int Target) {
        // 调用outcomeFunction并检查返回值是否为1(表示胜利)
        return outcomeFunction(N, Target, 0, 0) == 1;
    }

    private static int outcomeFunction(int N, int Target, int sum, int used) {
        // 如果当前和已经达到或超过目标,当前玩家输(因为是上一个玩家使和达到或超过目标的)
        if (sum >= Target) {
            return -1;
        }

        // 遍历所有可能的数字(从1到N)
        for (int i = 1; i <= N; i++) {
            // 检查数字i是否已经被使用,通过位运算实现
            if ((used & (1 << i)) == 0) {
                // 计算选择数字i后的新和和新的已使用数字位图
                int newSum = sum + i;
                int newUsed = used | (1 << i);

                // 如果新和达到或超过目标,当前玩家直接赢
                if (newSum >= Target) {
                    return 1;
                }

                // 递归调用outcomeFunction来模拟对手的行动
                int opponentOutcome = outcomeFunction(N, Target, newSum, newUsed);
                // 如果对手会输,那么当前玩家就赢了
                if (opponentOutcome == -1) {
                    return 1;
                }
            }
        }
        // 如果所有可能的数字都尝试过了,还没有找到赢的方法,那么当前玩家就输了
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(isAlwaysWin(20, 100));
    }
}