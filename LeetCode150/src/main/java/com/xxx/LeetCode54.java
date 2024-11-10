package com.xxx;

import java.util.ArrayList;
import java.util.List;

public class LeetCode54 {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();

        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return result;
        }

        int m = matrix.length;
        int n = matrix[0].length;

        // 初始化访问状态矩阵
        boolean[][] visited = new boolean[m][n];

        // 定义方向数组，顺时针的顺序是右、下、左、上
        int[] dx = {0, 1, 0, -1};  // 行方向
        int[] dy = {1, 0, -1, 0};  // 列方向

        int x = 0, y = 0, dir = 0; // 初始位置 (0,0) 和初始方向向右

        for (int i = 0; i < m * n; i++) {
            result.add(matrix[x][y]);
            visited[x][y] = true;

            // 计算下一个位置
            int nextX = x + dx[dir];
            int nextY = y + dy[dir];

            // 判断是否需要改变方向
            if (nextX < 0 || nextX >= m || nextY < 0 || nextY >= n || visited[nextX][nextY]) {
                // 切换到下一个方向
                dir = (dir + 1) % 4;
                nextX = x + dx[dir];
                nextY = y + dy[dir];
            }

            // 移动到下一个位置
            x = nextX;
            y = nextY;
        }

        return result;
    }
}
