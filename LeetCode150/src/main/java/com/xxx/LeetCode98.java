package com.xxx;

import java.util.ArrayList;
import java.util.List;

public class LeetCode98 {
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, null, null);
    }

    public boolean isValidBST(TreeNode node, Integer min, Integer max) {
        // node.val 满足约束条件
        // val > min && val < max
        // 对于左子树：值必须 小于当前节点的值，但仍然要大于它祖先节点规定的最小值（min）。
        // 对于右子树：值必须 大于当前节点的值，但仍然要小于它祖先节点规定的最大值（max）。
        if (node == null) {
            return true;
        }

        if ((min != null && node.val <= min) || (max != null && node.val >= max)) {
            return false;
        }

        return isValidBST(node.left, min, node.val) && isValidBST(node.right, node.val, max);
    }

    // 巧解: 对于二叉搜索树（BST），中序遍历的结果应该是一个严格递增的序列。
    public boolean isValidBST2(TreeNode root) {
        List<Integer> nums = new ArrayList<>();

        // 中序遍历将节点值存入列表
        inOrderTraversal(root, nums);

        // 检查数组是否严格递增
        for (int i = 1; i < nums.size(); i++) {
            if (nums.get(i) <= nums.get(i - 1)) {
                return false;
            }
        }

        return true;
    }

    private void inOrderTraversal(TreeNode node, List<Integer> nums) {
        if (node == null) {
            return;
        }

        // 递归遍历左子树
        inOrderTraversal(node.left, nums);
        // 访问当前节点
        nums.add(node.val);
        // 递归遍历右子树
        inOrderTraversal(node.right, nums);
    }
}
