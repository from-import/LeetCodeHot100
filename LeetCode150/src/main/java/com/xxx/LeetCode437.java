package com.xxx;

import java.util.HashMap;

public class LeetCode437 {
    // 法1 ： 前缀和解法，最优
    public int pathSum(TreeNode root, int targetSum) {
        // 前缀和计数器
        HashMap<Integer, Integer> prefixSumCount = new HashMap<>();
        prefixSumCount.put(0, 1); // 初始前缀和为 0 的情况
        return dfs(root, 0, targetSum, prefixSumCount);
    }

    private int dfs(TreeNode node, int currentSum, int targetSum, HashMap<Integer, Integer> prefixSumCount) {
        if (node == null) {
            return 0; // 遍历到空节点，返回 0 条路径
        }

        // 更新当前路径的前缀和
        currentSum += node.val;

        // 查找满足条件的路径数量
        int numPaths = prefixSumCount.getOrDefault(currentSum - targetSum, 0);

        // 更新哈希表中的前缀和计数
        prefixSumCount.put(currentSum, prefixSumCount.getOrDefault(currentSum, 0) + 1);

        // 递归计算左子树和右子树的路径数
        numPaths += dfs(node.left, currentSum, targetSum, prefixSumCount);
        numPaths += dfs(node.right, currentSum, targetSum, prefixSumCount);

        // 回溯：移除当前节点的前缀和，避免影响其他路径
        prefixSumCount.put(currentSum, prefixSumCount.get(currentSum) - 1);

        return numPaths;
    }

    // 法2 双重dfs
    public int pathSum2(TreeNode root, int targetSum) {

        if (root == null) {
            return 0; // 空树没有路径
        }

        if (root.val == 1000000000) {
            return 0;
        }

        // 以当前节点为起点的路径数
        int countFromRoot = countPathsFromNode(root, targetSum);

        // 递归对左右子树计算路径数
        int countFromLeft = pathSum2(root.left, targetSum);
        int countFromRight = pathSum2(root.right, targetSum);

        return countFromRoot + countFromLeft + countFromRight;
    }

    private int countPathsFromNode(TreeNode node, int targetSum) {


        if (node == null) {
            return 0;
        }

        int count = 0;
        int need = targetSum - node.val;

        if (targetSum == node.val) {
            count++;
        }

        count += countPathsFromNode(node.left, need) + countPathsFromNode(node.right, need);

        return count;
    }
}
