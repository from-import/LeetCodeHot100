package com.xxx;

public class LeetCode25 {
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode groupPrev = dummy;

        while (true) {
            // 找到当前组的第 k 个节点
            ListNode kth = getKthNode(groupPrev, k);
            if (kth == null) break;

            // 记录第 k 个节点之后的节点
            ListNode groupNext = kth.next;

            // 反转当前组的 k 个节点并记录
            ListNode[] reversedNodes = reverseNode(groupPrev.next, k);
            ListNode newGroupHead = reversedNodes[0];
            ListNode newGroupTail = reversedNodes[1];

            // 将反转后的组连接到剩余的链表
            groupPrev.next = newGroupHead;
            newGroupTail.next = groupNext;

            // 更新 groupPrev 指向反转后的组的尾节点
            groupPrev = newGroupTail;
        }
        return dummy.next;
    }

    // 辅助函数，用于找到从当前节点开始的第 k 个节点
    private ListNode getKthNode(ListNode node, int k) {
        while (node != null && k > 0) {
            node = node.next;
            k--;
        }
        return node;
    }

    public ListNode[] reverseNode(ListNode head, int count){
        int countMe = 0;
        ListNode cur = head;
        ListNode pre = null;
        while (cur != null) {
            countMe++;
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
            if(countMe == count){
                break;
            }
        }
        // pre 是反转后的新头节点，head（传入的头）现在是反转后的尾节点
        return new ListNode[]{pre, head};
    }
}
