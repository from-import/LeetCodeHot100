package com.xxx;

public class LeetCode2 {

    // 逻辑最易懂的写法 时间复杂度 O(Max(M,N))
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        boolean check = false;
        ListNode ori = new ListNode();
        ListNode dummy = new ListNode();
        dummy.next = ori;

        while (l1 != null && l2 != null) {
            int res = l1.val + l2.val;
            if (check) {
                res += 1;
                check = false;
            }
            if (res >= 10) {
                res -= 10;
                check = true;
            }
            ori.next = new ListNode(res);
            ori = ori.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        ListNode notNull = (l1 == null) ? l2 : l1;
        while (notNull != null) {
            int res = notNull.val;
            if (check) {
                res += 1;
                check = false;
            }
            if (res == 10) {
                res = 0;
                check = true;
            }
            ori.next = new ListNode(res);
            ori = ori.next;
            notNull = notNull.next;
        }
        if (check) {
            ori.next = new ListNode(1);
        }
        return dummy.next.next;
    }

    /**
     * 无溢出风险，直接构造链表
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode current = dummyHead;
        int carry = 0;

        while (l1 != null || l2 != null) {
            int x = (l1 != null) ? l1.val : 0;
            int y = (l2 != null) ? l2.val : 0;
            int sum = x + y + carry;
            carry = sum / 10;

            current.next = new ListNode(sum % 10);
            current = current.next;

            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }

        // 如果最后有进位，则再添加一个新节点
        if (carry > 0) {
            current.next = new ListNode(carry);
        }

        return dummyHead.next;
    }
}
