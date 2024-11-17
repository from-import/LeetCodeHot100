package com.xxx;

public class LeetCode79 {
    public boolean exist(char[][] board, String word) {
        int m = board.length, n = board[0].length;
        boolean[][] visited = new boolean[m][n]; // 标记是否访问过

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // 从每个单元格开始查找
                if (backTracking(board, word, 0, i, j, visited)) {
                    return true;
                }
            }
        }
        return false; // 所有路径都找不到
    }

    private boolean backTracking(char[][] board, String word, int index, int x, int y, boolean[][] visited) {
        // 如果单词的所有字符都匹配，返回 true
        if (index == word.length()) {
            return true;
        }

        // 检查边界条件和是否已经访问过
        if (x < 0 || x >= board.length || y < 0 || y >= board[0].length || visited[x][y] || board[x][y] != word.charAt(index)) {
            return false;
        }

        // 标记当前单元格为访问过
        visited[x][y] = true;

        // 递归地检查四个方向
        boolean found = backTracking(board, word, index + 1, x - 1, y, visited) || // 上
                backTracking(board, word, index + 1, x + 1, y, visited) || // 下
                backTracking(board, word, index + 1, x, y - 1, visited) || // 左
                backTracking(board, word, index + 1, x, y + 1, visited);   // 右

        // 回溯：撤销当前单元格的访问状态
        visited[x][y] = false;

        return found;
    }
}
