package com.xxx;

import java.util.PriorityQueue;

public class LeetCode215 {
    public int findKthLargest(int[] nums, int k) {
        // 创建一个小顶堆
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        // 遍历数组中的每个元素
        for (int num : nums) {
            minHeap.add(num);
            // 如果堆的大小超过 k，移除堆顶元素
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        // 最后小顶堆的堆顶元素就是第 k 个最大的元素
        return minHeap.peek();
    }
}
