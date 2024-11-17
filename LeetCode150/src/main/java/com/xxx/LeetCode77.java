package com.xxx;

import java.util.ArrayList;
import java.util.List;

public class LeetCode77 {
    private List<Integer> path = new ArrayList<>();
    private List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {
        backTracking(n, k, 1);
        return res;
    }

    void backTracking(int n, int k, int startIndex) {
        if (path.size() == k) {
            res.add(new ArrayList<>(path));
            return ;
        }

        for (int i = startIndex; i <= n; i++) {
            path.add(i);
            backTracking(n, k, i + 1);
            path.remove(path.size() - 1); // 删除最后一个元素，避免索引问题
        }
    }
}
