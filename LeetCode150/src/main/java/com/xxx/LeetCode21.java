package com.xxx;

public class LeetCode21 {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode head1 = list1;
        ListNode head2 = list2;
        ListNode dummy = new ListNode();
        ListNode ori = dummy;
        while (head1 != null && head2 != null) {
            if (head2.val > head1.val) {
                dummy.next = head1;
                head1 = head1.next;
            }
            else {
                dummy.next = head2;
                head2 = head2.next;
            }
            dummy = dummy.next;
        }
        if (head1 == null) {
            dummy.next = head2;
        }
        else {
            dummy.next = head1;
        }
        return ori.next;

    }
}
