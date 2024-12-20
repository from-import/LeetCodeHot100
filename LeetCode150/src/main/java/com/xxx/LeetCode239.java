package com.xxx;

import java.util.ArrayDeque;
import java.util.Deque;

public class LeetCode239 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] res = new int[nums.length - k + 1];
        int maxNum = 0;
        for(int i = 0; i<nums.length - k + 1; i++){
            maxNum = nums[i];
            for(int j = i; j < i + k; j++){
                maxNum = Math.max(maxNum, nums[j]);
            }
            res[i] = maxNum;
        }
        return res;

    }

    public int[] maxSlidingWindow2(int[] nums, int k) {
        int n = nums.length;
        if (n * k == 0) return new int[0]; // 边界情况，如果数组为空或窗口大小为0，直接返回空数组
        if (k == 1) return nums; // 如果窗口大小为1，滑动窗口的最大值就是每个元素自身

        int[] leftMax = new int[n];  // 从左到右记录每块的最大值
        int[] rightMax = new int[n]; // 从右到左记录每块的最大值

        // 初始化 leftMax 和 rightMax 数组
        leftMax[0] = nums[0];
        rightMax[n - 1] = nums[n - 1];

        // 填充 leftMax 数组，从左到右
        for (int i = 1; i < n; i++) {
            // 如果是每个块的开始位置（i % k == 0），则重新开始记录最大值
            leftMax[i] = (i % k == 0) ? nums[i] : Math.max(leftMax[i - 1], nums[i]);
        }

        // 填充 rightMax 数组，从右到左
        for (int i = n - 2; i >= 0; i--) {
            // 如果是每个块的结束位置（i % k == k - 1），则重新开始记录最大值
            rightMax[i] = (i % k == k - 1) ? nums[i] : Math.max(rightMax[i + 1], nums[i]);
        }

        // 计算每个滑动窗口的最大值
        int[] res = new int[n - k + 1];
        for (int i = 0; i < n - k + 1; i++) {
            // 每个滑动窗口的最大值为 leftMax 和 rightMax 中较大的值
            res[i] = Math.max(rightMax[i], leftMax[i + k - 1]);
        }

        return res;
    }

    // 双端队列解法
    public int[] maxSlidingWindow3(int[] nums, int k) {
        if (nums == null || k <= 0) {
            return new int[0];
        }
        int n = nums.length;
        int[] result = new int[n - k + 1];
        Deque<Integer> deque = new ArrayDeque<>(); // 双端队列

        for (int i = 0; i < n; i++) {
            // 移除队列中不在当前窗口内的元素
            if (!deque.isEmpty() && deque.peekFirst() < i - k + 1) {
                deque.pollFirst();
            }

            // 移除队列中所有小于当前元素的元素
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }

            // 添加当前元素的索引
            deque.offerLast(i);

            // 当窗口大小达到k时，将队列头部的元素加入结果
            if (i >= k - 1) {
                result[i - k + 1] = nums[deque.peekFirst()];
            }
        }
        return result;
    }
}
