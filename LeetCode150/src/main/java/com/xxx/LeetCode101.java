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

    public boolean isSymmetric2(TreeNode root) {
        if (root == null) {
            return true;
        }
        return check(root.left, root.right);
    }

    private boolean check(TreeNode left, TreeNode right) {
        if (left == null && right != null) {
            return false;
        }
        if (left != null && right == null) {
            return false;
        }
        if (left == null && right == null) {
            return true;
        }
        return (left.val == right.val
                && check(left.left, right.right)
                && check(left.right, right.left));
    }
}
