package com.xxx;

import java.util.Random;

public class LeetCode470 {
    public static int rand7() {
        Random r = new Random();
        return r.nextInt(6) + 1;
    }

    public int rand10() {
            while(true) {
            int idx = (rand7() - 1) * 7 + rand7();
            if (idx <= 40) {
                return(idx % 10 + 1);
            }
        }
    }

    // 使用二维数组和拒绝采样来生成 1 到 10 的随机数
    public int newRand10() {
        // 创建一个二维数组来表示 1 到 49 的映射
        int[][] matrix = new int[7][7];
        int value = 1;

        // 填充二维数组
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 7; j++) {
                matrix[i][j] = value++;
            }
        }

        while (true) {
            // 随机生成行和列的索引（注意 rand7() 是 1 到 7 的范围）
            int row = rand7() - 1; // 转为 0 到 6 的索引
            int col = rand7() - 1;

            // 获取二维数组中的值
            int idx = matrix[row][col];

            // 如果 idx 在 1 到 40 范围内，则返回对应的 1 到 10 的结果
            if (idx <= 40) {
                return (idx - 1) % 10 + 1;
            }
            // 否则拒绝，并重新采样
        }
    }

}
