package com.xxx;

public class LeetCode234 {
    // O(n) 时间复杂度 + O(1) 空间复杂度
    public boolean isPalindrome(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        fast = head;
        slow = transListNode(slow);
        while (slow != null) {
            if (fast.val != slow.val) {
                return false;
            }
            fast = fast.next;
            slow = slow.next;
        }
        return true;
    }

    // 翻转链表
    public ListNode transListNode(ListNode head) {
        ListNode pre = null;
        ListNode node = head;
        while (node != null) {
            ListNode temp = node.next;
            node.next = pre;
            pre = node;
            node = temp;
        }
        return pre;
    }
}
