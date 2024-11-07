package com.xxx;

public class LeetCode24 {
    public ListNode swapPairs(ListNode head) {
        // 1. 考虑特殊情况
        if(head == null || head.next == null){
            return head;
        }

        // 2. 新建dummy，防止出现异常
        ListNode dummy = new ListNode();
        dummy.next = head;

        // 3. 采用prev(head 和 prev 都需要更新到下一对节点的开始位置)
        ListNode prev = dummy;
        while(head != null && head.next != null){
            ListNode slow = head;
            ListNode fast = head.next;
            // 两两交换
            slow.next = fast.next;
            fast.next = slow;
            prev.next = fast;

            // 更新指针位置
            prev = slow;
            head = slow.next;
        }

        return dummy.next;
    }
}
