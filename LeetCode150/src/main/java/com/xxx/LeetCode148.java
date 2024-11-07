package com.xxx;

public class LeetCode148 {
    public ListNode sortList(ListNode head) {
        // 基本条件：如果链表为空或只有一个节点，则返回
        if (head == null || head.next == null) return head;

        // 分组：将链表分为比head小的和比head大的两部分
        ListNode[] parts = function(head);

        // 递归排序分组后的链表
        ListNode smallerSorted = sortList(parts[0]);
        ListNode greaterSorted = sortList(parts[1]);

        // 将比head小的部分连接到head，再连接比head大的部分
        head.next = greaterSorted;
        if (smallerSorted == null) {
            return head;
        } else {
            ListNode tail = smallerSorted;
            while (tail.next != null) {
                tail = tail.next;
            }
            tail.next = head;
            return smallerSorted;
        }
    }

    // 分组函数，将链表分为比head小的一组和比head大的另一组
    public ListNode[] function(ListNode head) {
        ListNode smaller = null, smallerTail = null;
        ListNode greater = null, greaterTail = null;
        ListNode current = head.next;

        while (current != null) {
            if (current.val < head.val) {
                if (smaller == null) {
                    smaller = smallerTail = current;
                } else {
                    smallerTail.next = current;
                    smallerTail = smallerTail.next;
                }
            } else {
                if (greater == null) {
                    greater = greaterTail = current;
                } else {
                    greaterTail.next = current;
                    greaterTail = greaterTail.next;
                }
            }
            current = current.next;
        }

        // 断开最后节点的next指针，防止循环链表
        if (smallerTail != null) smallerTail.next = null;
        if (greaterTail != null) greaterTail.next = null;

        return new ListNode[]{smaller, greater};
    }

    public ListNode sortList2(ListNode head) {
        // 基本条件：链表为空或只有一个节点时，直接返回
        if (head == null || head.next == null) {
            return head;
        }

        // 使用快慢指针找到链表中点
        ListNode mid = getMiddle(head);
        ListNode rightHalf = mid.next;
        mid.next = null; // 断开链表

        // 递归排序左右两部分
        ListNode left = sortList(head);
        ListNode right = sortList(rightHalf);

        // 合并排序好的两个子链表
        return merge(left, right);
    }

    // 找到链表的中间节点
    private ListNode getMiddle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    // 合并两个有序链表
    private ListNode merge(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                current.next = l1;
                l1 = l1.next;
            } else {
                current.next = l2;
                l2 = l2.next;
            }
            current = current.next;
        }

        // 如果还有剩余节点
        if (l1 != null) current.next = l1;
        if (l2 != null) current.next = l2;

        return dummy.next;
    }
}
