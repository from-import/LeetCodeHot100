package com.xxx;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LeetCode102 {
    // 队列优雅解法
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> finalRes = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if (root != null) {
            queue.offer(root);
        }
        while (!queue.isEmpty()) {
            // 如何确定每次能正好取出一层的全部节点？
            // 在每个循环开始时，用size存储当前queue.size()，然后for遍历即可
            int size = queue.size();
            List<Integer> res = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                res.add(node.val);
                if (null != node.left) {
                    queue.offer(node.left);
                }
                if (null != node.right) {
                    queue.offer(node.right);
                }
            }
            finalRes.add(res);
        }
        return finalRes;
    }
}
