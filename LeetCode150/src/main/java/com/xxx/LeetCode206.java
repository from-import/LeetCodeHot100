package com.xxx;

public class LeetCode206 {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head; // 空链表或只有一个节点，不需要反转
        }

        ListNode pre = null; // 前一个节点，初始为空
        ListNode cur = head; // 当前节点，从头节点开始

        while (cur != null) {
            ListNode nextTemp = cur.next; // 暂存当前节点的下一个节点
            cur.next = pre; // 将当前节点的 next 指向前一个节点，完成反转
            pre = cur; // 更新前一个节点为当前节点
            cur = nextTemp; // 当前节点前进到原来它的下一个节点
        }

        return pre; // 最终前一个节点就是新的头节点
    }
}
