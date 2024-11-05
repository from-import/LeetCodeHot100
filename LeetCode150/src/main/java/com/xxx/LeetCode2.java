package com.xxx;

public class LeetCode2 {

    /**
     * 存在int溢出风险
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        char[] res = new char[101];
        int target = 0;
        int ten = 1;
        while(l1 != null){
            target += ten * l1.val;
            l1 = l1.next;
            ten *= 10;
        }
        ten = 1;
        while(l2 != null){
            target += ten * l2.val;
            l2 = l2.next;
            ten *= 10;
        }
        // 特殊情况处理：如果结果为 0，则返回单节点链表 0
        if (target == 0) {
            return new ListNode(0);
        }
        // 将 target 拆分成链表
        ListNode dummyHead = new ListNode(0);
        ListNode current = dummyHead;

        while (target > 0) {
            int digit = target % 10;
            current.next = new ListNode(digit);
            current = current.next;
            target /= 10;
        }

        return dummyHead.next;
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
