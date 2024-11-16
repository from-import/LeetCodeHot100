package com.xxx;

import java.util.ArrayList;
import java.util.List;

public class LeetCode94 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        function(root, res);
        return res;
    }

    public void function(TreeNode root, List<Integer> res){
        if (root == null) {
            return;
        }
        function(root.left, res);
        res.add(root.val);
        function(root.right, res);
    }
}
