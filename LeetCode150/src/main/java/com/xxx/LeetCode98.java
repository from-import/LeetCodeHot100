package com.xxx;

public class LeetCode98 {
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, null, null);
    }

    public boolean isValidBST(TreeNode node, Integer min, Integer max) {
        // 维护max 和 min, 约束条件为:
        // 1. 左子树的值必须小于当前节点值
        // 2. 右子树的值必须大于当前节点值
        if (node == null) {
            return true;
        }

        // 节点值必须大于 min
        if (min != null && node.val <= min) {
            return false;
        }

        // 节点值必须小于 max
        if (max != null && node.val >= max) {
            return false;
        }

        // 如果均满足,递归遍历node.left, node.right
        return (isValidBST(node.left, min, node.val) &&
                isValidBST(node.right, node.val, max));
    }
}
