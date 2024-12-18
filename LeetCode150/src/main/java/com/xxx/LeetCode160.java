package com.xxx;

import java.util.HashMap;

public class LeetCode160 {
    public class Solution {
        // 解法1. 双指针解法
        public ListNode getIntersectionNode1(ListNode headA, ListNode headB) {
            ListNode node1 = headA;
            ListNode node2 = headB;

            while (node1 != node2) {
                node1 = (node1 == null) ? headB : node1.next;
                node2 = (node2 == null) ? headA : node2.next;
            }
            return node1;
        }

        // 解法2. HashMap解法
        public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
            if (headA == null || headB == null){
                return null;
            }
            HashMap<ListNode, Integer> map = new HashMap<>();
            while(headA != null){
                map.put(headA, 1);
                headA = headA.next;
            }
            while(headB != null){
                if(map.get(headB) != null){
                    return headB;
                }
                headB = headB.next;
            }
            return null;

        }

        // 解法3. 计算len1 和 len2，提前走len1 - len2步
        public ListNode getIntersectionNode3(ListNode headA, ListNode headB) {
            if (headA == null || headB == null){
                return null;
            }
            ListNode node1 = headA;
            ListNode node2 = headB;
            int len1 = 0, len2 = 0;
            while (node1 != null){
                len1++;
                node1 = node1.next;
            }
            while (node2 != null){
                len2++;
                node2 = node2.next;
            }
            if (len1 > len2){
                for (int i = 0; i < len1 - len2; i++){
                    headA = headA.next;
                }
                while(headA != null){
                    if(headA == headB){
                        return headA;
                    }
                    headA = headA.next;
                    headB = headB.next;
                }
                return null;
            }
            else{
                for (int i = 0; i < len2 - len1; i++){
                    headB = headB.next;
                }
                while(headB != null){
                    if(headA == headB){
                        return headB;
                    }
                    headA = headA.next;
                    headB = headB.next;
                }
                return null;
            }
        }

        // 解法4. 将链表A的结尾接到链表B，快慢指针判环
        public ListNode getIntersectionNode4(ListNode headA, ListNode headB) {
            if (headA == null || headB == null) {
                return null;
            }

            // 找到链表A的尾节点
            ListNode tailA = headA;
            while (tailA.next != null) {
                tailA = tailA.next;
            }

            // 将链表A的尾节点指向链表B的头部
            tailA.next = headB;

            // 使用快慢指针检查链表是否有环
            ListNode slow = headA;
            ListNode fast = headA;
            boolean hasCycle = false;

            while (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
                if (slow == fast) {
                    hasCycle = true;
                    break;
                }
            }

            // 如果没有环，则链表不相交，恢复链表结构并返回null
            if (!hasCycle) {
                tailA.next = null; // 恢复链表结构
                return null;
            }

            // 有环，寻找环的起点
            slow = headA;
            while (slow != fast) {
                slow = slow.next;
                fast = fast.next;
            }

            // 恢复链表结构
            tailA.next = null;

            // 返回相交的节点
            return slow;
        }




    }
}
