package com.xxx;

import java.util.HashMap;
import java.util.Map;

public class Solution2 {
    // 实现记忆化，时间复杂度更优

    public boolean isAlwaysWin(int N, int Target) {
        // 记忆化搜索的结果，用 map 来存储
        Map<String, Boolean> map = new HashMap<>();

        // 定义布尔数组来记录哪些数字已经被选中
        boolean[] used = new boolean[N + 1];  // 用于记录数字是否被选中，1 到 N
        return canWin(0, used, N, Target, map);
    }

    // 判断在给定的状态下，是否先报数的玩家能赢
    private boolean canWin(int currentSum, boolean[] used, int N, int Target, Map<String, Boolean> map) {
        // 如果当前总和已经达到或超过目标值，先报数的玩家无法获胜
        if (currentSum >= Target) {
            return false;
        }

        // 将当前状态（布尔数组）转换为字符串，作为哈希表的 key
        String state = arrayToString(used);

        // 如果这个状态已经计算过，直接返回结果
        if (map.containsKey(state)) {
            return map.get(state);
        }

        // 遍历每个可选择的数字
        for (int i = 1; i <= N; i++) {
            if (!used[i]) {  // 如果这个数还没有被选过
                // 选择 i 号数
                used[i] = true;
                // 递归判断对手能否获胜
                if (!canWin(currentSum + i, used, N, Target, map)) {
                    // 如果对手不能赢，那么当前玩家能赢
                    used[i] = false;  // 回溯
                    map.put(state, true);
                    return true;
                }
                used[i] = false;  // 回溯
            }
        }

        // 如果所有选择都不能导致当前玩家获胜，那么他无法获胜
        map.put(state, false);
        return false;
    }

    // 将布尔数组转换为字符串作为 map 的 key
    private String arrayToString(boolean[] used) {
        StringBuilder sb = new StringBuilder();
        for (boolean b : used) {
            sb.append(b ? '1' : '0');
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Solution2 game = new Solution2();
        System.out.println(game.isAlwaysWin(20, 100));  // 输出结果
    }
}
