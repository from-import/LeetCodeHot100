package com.xxx;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class LeetCode46 {
    private boolean[] used = new boolean[10];
    private List<Integer> path = new ArrayList<>();
    private List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        used = new boolean[nums.length]; // 根据 nums 长度初始化
        backTracking(nums);
        return res;
    }

    void backTracking(int[] nums) {
        if (path.size() == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (used[i]) {
                continue;
            }
            // 添加结果到path
            used[i] = true;
            path.add(nums[i]);

            // 递归调用
            backTracking(nums);
            path.remove(path.size() - 1); // 回溯
            used[i] = false;
        }
    }
}

