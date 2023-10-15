package 代码随想录.链表.两两交换链表中的节点;

/**
 * 两两交换链表中的节点 Leetcode24 <a href="https://leetcode.cn/problems/swap-nodes-in-pairs/">
 * @author phix
 * @date 2023/10/15
 */
public class Solution {
    public static void main(String[] args) {
        ListNode listNode = swapPairs1(createList(new int[]{1, 2, 3, 4}));
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }

    public static ListNode swapPairs1(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode pre = dummy;
        ListNode cur = head;

        while (cur != null && cur.next != null) {
            ListNode temp1 = cur.next.next;
            ListNode temp2 = cur.next;
            cur.next = temp1;
            pre.next = temp2;
            temp2.next = cur;
            pre = cur;
            cur = temp1;
        }
        return dummy.next;

    }

    public static ListNode swapPairs2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode cur = dummy;

        while (cur.next != null && cur.next.next != null) {
            ListNode temp = cur.next;
            ListNode curTemp = cur.next.next.next;
            cur.next = cur.next.next;
            cur.next.next = temp;
            cur.next.next.next = curTemp;
            cur = cur.next.next;
        }
        return dummy.next;

    }

    private static ListNode createList(int[] nums) {
        ListNode dummy = new ListNode();
        ListNode pre = dummy;
        for (int num : nums) {
            pre.next = new ListNode(num);
            pre = pre.next;
        }
        return dummy.next;
    }


    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
