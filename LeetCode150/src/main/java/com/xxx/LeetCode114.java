package com.xxx;

import java.util.ArrayList;
import java.util.List;

public class LeetCode114 {
    // 注意区分值传递和引用传递
    public void flatten(TreeNode root) {
        if (root == null) return;

        // 用于存储前序遍历的结果
        List<Integer> res = new ArrayList<>();
        preorder(root, res);

        // 构造新的拉平链表
        TreeNode target = root; // 使用现有的 root 节点构建链表
        for (int i = 1; i < res.size(); i++) {
            target.left = null; // 将左子树置为 null
            target.right = new TreeNode(res.get(i)); // 构造右子树
            target = target.right;
        }
    }

    private void preorder(TreeNode node, List<Integer> res) {
        if (node == null) {
            return; // 递归终止条件
        }
        res.add(node.val); // 访问当前节点
        preorder(node.left, res); // 递归访问左子树
        preorder(node.right, res); // 递归访问右子树
    }
}
