package com.xxx;

public class LeetCode200 {
    public int numIslands(char[][] grid) {
        int numIslands = 0;
        int rows = grid.length;
        int cols = grid[0].length;

        // 遍历网格
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                // 如果当前是陆地
                if (grid[i][j] == '1') {
                    numIslands++;  // 找到一个新的岛屿
                    // 使用DFS将连通的陆地标记为0（视为水）
                    dfs(grid, i, j);
                }
            }
        }
        return numIslands;
    }


    private void dfs(char[][] grid, int i, int j){
        int rows = grid.length;
        int cols = grid[0].length;

        // 边界条件判断：超出网格范围或当前格子是水
        if (i < 0 || i >= rows || j < 0 || j >= cols || grid[i][j] == '0') {
            return;
        }

        // 将当前陆地标记为水，表示已经访问过
        grid[i][j] = '0';

        // 继续搜索相邻的四个方向
        dfs(grid, i - 1, j);  // 上
        dfs(grid, i + 1, j);  // 下
        dfs(grid, i, j - 1);  // 左
        dfs(grid, i, j + 1);  // 右
    }
}
