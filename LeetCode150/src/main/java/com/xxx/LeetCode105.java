package com.xxx;

public class LeetCode105 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0 || inorder.length == 0) {
            return null; // 如果没有节点，返回空树
        }

        // 当前树的根节点
        int rootVal = preorder[0];
        TreeNode root = new TreeNode(rootVal);

        // 在中序遍历中找到根节点的位置
        int rootIndex = 0;
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == rootVal) {
                rootIndex = i;
                break;
            }
        }

        // 切割出左子树和右子树的前序和中序遍历数组
        int[] leftPreorder = java.util.Arrays.copyOfRange(preorder, 1, rootIndex + 1);
        int[] rightPreorder = java.util.Arrays.copyOfRange(preorder, rootIndex + 1, preorder.length);
        int[] leftInorder = java.util.Arrays.copyOfRange(inorder, 0, rootIndex);
        int[] rightInorder = java.util.Arrays.copyOfRange(inorder, rootIndex + 1, inorder.length);

        // 递归构造左右子树
        root.left = buildTree(leftPreorder, leftInorder);
        root.right = buildTree(rightPreorder, rightInorder);

        return root;
    }
}
