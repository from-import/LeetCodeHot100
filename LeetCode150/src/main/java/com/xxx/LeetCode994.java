package com.xxx;

import java.util.LinkedList;
import java.util.Queue;

public class LeetCode994 {
    public int orangesRotting(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        // 方向数组，用于BFS扩散
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        Queue<int[]> queue = new LinkedList<>();
        int freshCount = 0; // 新鲜橘子的计数

        // 初始化队列，统计新鲜橘子的数量
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 2) {
                    queue.offer(new int[]{i, j}); // 将腐烂的橘子坐标加入队列
                } else if (grid[i][j] == 1) {
                    freshCount++; // 统计新鲜橘子的数量
                }
            }
        }

        // 如果没有新鲜橘子，直接返回0
        if (freshCount == 0) return 0;

        int minutes = 0; // 用于记录分钟数

        // BFS 开始
        while (!queue.isEmpty()) {
            int size = queue.size();
            boolean rotted = false; // 记录是否有橘子被腐烂

            for (int i = 0; i < size; i++) {
                int[] current = queue.poll();
                int x = current[0];
                int y = current[1];

                // 遍历四个方向
                for (int[] dir : directions) {
                    int nx = x + dir[0];
                    int ny = y + dir[1];

                    // 检查是否在范围内以及是否为新鲜橘子
                    if (nx >= 0 && nx < rows && ny >= 0 && ny < cols && grid[nx][ny] == 1) {
                        grid[nx][ny] = 2; // 将新鲜橘子变成腐烂
                        queue.offer(new int[]{nx, ny}); // 新腐烂的橘子加入队列
                        freshCount--; // 新鲜橘子数量减少
                        rotted = true;
                    }
                }
            }

            if (rotted) {
                minutes++; // 如果有橘子腐烂了，增加时间
            }
        }

        // 如果没有剩余新鲜橘子，返回分钟数，否则返回 -1
        return freshCount == 0 ? minutes : -1;
    }
}
