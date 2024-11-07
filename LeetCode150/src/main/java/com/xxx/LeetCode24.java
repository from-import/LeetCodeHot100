package com.xxx;

public class LeetCode24 {
    public ListNode swapPairs(ListNode head) {
        // 1. 处理特殊情况：链表为空或只有一个节点
        if (head == null || head.next == null) {
            return head;
        }

        // 2. 创建虚拟头节点，简化边界条件处理
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        // 3. 初始化前驱节点
        ListNode prev = dummy;

        // 4. 遍历链表，两两交换相邻节点
        while (head != null && head.next != null) {
            ListNode first = head;
            ListNode second = head.next;

            // 交换节点
            first.next = second.next;
            second.next = first;
            prev.next = second;

            // 更新指针位置
            prev = first;
            head = first.next;
        }

        return dummy.next;
    }
}
