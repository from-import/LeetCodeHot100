package com.xxx;

public class LeetCode236 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        /**
         * 如果 left 和 right 都不为空：
         *     说明 pp 和 qq 分别位于当前节点的左子树和右子树。
         *     因此，当前节点 root 就是 pp 和 qq 的最近公共祖先。
         *
         * 如果只有 left 非空：
         *     说明 pp 和 qq 都在左子树中，左子树中返回的节点就是最近公共祖先。
         *
         * 如果只有 right 非空：
         *     说明 pp 和 qq 都在右子树中，右子树中返回的节点就是最近公共祖先。
         *
         * 如果 left 和 right 都为空：
         *     说明当前子树中没有 pp 或 qq，直接返回 null。
         */
        if (left != null && right != null) {
            return root;
        }
        if (left == null && right == null) {
            return null;
        }
        return left != null ? left : right;
    }
}
