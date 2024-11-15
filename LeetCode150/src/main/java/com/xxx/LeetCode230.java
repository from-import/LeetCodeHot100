package com.xxx;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode230 {
    // 方法1 ： 遍历，转数组，排序输出，时间复杂度O(nlogn)
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> nums = new ArrayList<>();

        inOrderTraversal(root, nums);
        int[] res = new int[nums.size()];

        for (int i = 0; i < nums.size(); i++) {
            res[i] = nums.get(i);
        }
        Arrays.sort(res);
        return res[k - 1];
    }

    private void inOrderTraversal(TreeNode node, List<Integer> nums) {
        if (node == null) {
            return;
        }

        // 递归遍历左子树
        inOrderTraversal(node.left, nums);
        // 访问当前节点
        nums.add(node.val);
        // 递归遍历右子树
        inOrderTraversal(node.right, nums);
    }

    // 优化方法: 直接中序遍历
    /**
     * 在中序遍历过程中：
     *
     *     维护一个计数器 count 来记录已访问的节点数量。
     *     当 count == k 时，直接返回当前节点值，无需继续遍历。
     */
    private int count = 0; // 用于计数
    private int result = 0; // 用于存储第k小值

    public int kthSmallest2(TreeNode root, int k) {
        inOrderTraversal(root, k);
        return result;
    }

    private void inOrderTraversal(TreeNode node, int k) {
        if (node == null) {
            return;
        }

        // 递归遍历左子树
        inOrderTraversal(node.left, k);

        // 处理当前节点
        count++;
        if (count == k) {
            result = node.val;
            return; // 找到结果后提前结束
        }

        // 递归遍历右子树
        inOrderTraversal(node.right, k);
    }
}
