package com.xxx;

public class LeetCode108 {
    /**
     * 二叉搜索树（BST）：左子树所有节点值小于根节点，右子树所有节点值大于根节点。
     * 平衡二叉树：左右子树的高度差不超过1。
     * 升序数组：由于数组已经升序排列，可以利用中间值作为根节点，左半部分作为左子树，右半部分作为右子树。
     */

    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0) {
            return new TreeNode();
        }
        if (nums.length == 1) {
            return new TreeNode(nums[0]);
        }

        return buildTree(nums, 0, nums.length - 1);
    }

    private TreeNode buildTree(int[] nums, int start, int end) {
        // 递归终止条件
        if (start > end) {
            return null;
        }

        // 找到中间位置
        int mid = start + (end - start) / 2;

        // 创建根节点
        TreeNode root = new TreeNode(nums[mid]);

        // 构建左子树
        root.left = buildTree(nums, start, mid - 1);

        // 构建右子树
        root.right = buildTree(nums, mid + 1, end);

        return root;
    }
}
