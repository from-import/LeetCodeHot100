package com.xxx;

public class LeetCode124 {
    private int maxPathSum; // 全局最大路径和

    public int maxPathSum(TreeNode root) {
        maxPathSum = Integer.MIN_VALUE; // 初始化为负无穷
        calculateMaxContribution(root); // 递归计算最大贡献值
        return maxPathSum;
    }

    private int calculateMaxContribution(TreeNode node) {
        if (node == null) {
            return 0; // 空节点的贡献值为 0
        }

        // 递归计算左、右子树的贡献值
        int leftContribution = Math.max(0, calculateMaxContribution(node.left));
        int rightContribution = Math.max(0, calculateMaxContribution(node.right));

        // 更新全局最大路径和
        maxPathSum = Math.max(maxPathSum, node.val + leftContribution + rightContribution);

        // 返回当前节点对父节点的最大贡献值
        return node.val + Math.max(leftContribution, rightContribution);
    }
}
