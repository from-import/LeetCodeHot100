package com.xxx;

public class LeetCode101 {
    public boolean isSymmetric(TreeNode root) {
        return function(root.left, root.right);

    }
    public boolean function(TreeNode left, TreeNode right){
        if (left == null && right == null) {
            return true;
        }
        else if ((left != null && right == null) || (left == null && right != null)) {
            return false;
        }

        return(left.val == right.val) && (function(left.left,right.right)) && (function(left.right, right.left));
    }
}
