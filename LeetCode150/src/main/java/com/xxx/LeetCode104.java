package com.xxx;

public class LeetCode104 {
    public int maxDepth(TreeNode root) {
        int depth = 0;
        return function(root, depth);

    }
    public int function(TreeNode root,int depth){
        if (null == root) {
            return depth;
        }
        int left = function(root.left, depth + 1);
        int right = function(root.right, depth + 1);
        return Math.max(left, right);
    }
}
