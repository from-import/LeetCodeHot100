package com.xxx;

public class LeetCode134 {
    // O(n)时间复杂度 一次遍历实现加油站
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int length = gas.length;
        int totalGas = 0;
        int totalCost = 0;
        for (int singleGas : gas) {
            totalGas += singleGas;
        }
        for (int singleCost : cost) {
            totalCost += singleCost;
        }
        if (totalGas < totalCost) {
            return -1;
        }

        int gasNow = gas[0] - cost[0];
        int start = 0;
        for (int i = 0; i < length; i++) {
            // 如果发现到达某个站点Gas已变成负数或0，则证明这个站点及之前均不为解
            if (gasNow <= 0) {
                start = i;
                gasNow = gas[i] - cost[i];
                continue;
            }
            gasNow += (gas[i] - cost[i]);
        }
        return start;
    }
}
