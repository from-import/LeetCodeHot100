package com.xxx;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode51 {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        char[][] board = new char[n][n];
        // 初始化棋盘
        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }

        backTracking(0, n, board, res);
        return res;
    }

    private void backTracking(int row, int n, char[][] board, List<List<String>> res) {
        // 如果所有皇后都放置完成，记录结果
        if (row == n) {
            res.add(boardToList(board));
            return;
        }

        for (int col = 0; col < n; col++) {
            // 检查当前格子是否可以放置皇后
            if (!isValid(board, row, col, n)) {
                continue;
            }
            // 放置皇后
            // 在这一行放置了皇后，则当前行的其他位置均不可以放置皇后，直接backTracking下一行
            board[row][col] = 'Q';
            // 递归处理下一行
            backTracking(row + 1, n, board, res);
            // 回溯，撤销放置
            board[row][col] = '.';
        }
    }


    private boolean isValid(char[][] board, int row, int col, int n) {
        // 检查列是否有皇后
        for (int i = 0; i < row; i++) {
            if (board[i][col] == 'Q') {
                return false;
            }
        }

        // 检查主对角线是否有皇后
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }

        // 检查副对角线是否有皇后
        for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }

        return true;
    }

    private List<String> boardToList(char[][] board) {
        List<String> result = new ArrayList<>();
        for (char[] row : board) {
            result.add(new String(row));
        }
        return result;
    }
}
