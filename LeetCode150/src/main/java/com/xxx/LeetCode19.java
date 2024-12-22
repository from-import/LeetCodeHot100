package com.xxx;

public class LeetCode19 {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        // 如果 head 是空的，直接返回 null，防止 NullPointerException
        if (head == null || n <= 0) {
            return head;
        }

        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode fast = dummy;
        ListNode slow = dummy;

        // 让 fast 指针先走 n + 1 步
        for (int i = 0; i < n + 1; i++) {
            // 如果 fast 到达 null，说明 n 大于链表的长度，返回原链表
            if (fast == null) {
                return head;
            }
            fast = fast.next;
        }

        // 同时移动 fast 和 slow，直到 fast 到达链表末尾
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }

        // 删除倒数第 n 个节点
        slow.next = slow.next.next;

        return dummy.next;
    }

    // 简单的实现
    public ListNode removeNthFromEnd2(ListNode head, int n) {
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode fast = dummy;
        ListNode slow = dummy;
        for (int i = 0; i < n + 1; i++) {
            fast = fast.next;
        }
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return dummy.next;
    }

}
