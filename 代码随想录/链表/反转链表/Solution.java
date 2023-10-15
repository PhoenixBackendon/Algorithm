package 代码随想录.链表.反转链表;

/**
 * 反转链表 Leetcode206 <a href="https://leetcode.cn/problems/reverse-linked-list">
 *
 * @author phix
 * @date 2023/10/15
 */
public class Solution {

    public static void main(String[] args) {
        ListNode listNode = reverseList2(createList(new int[]{1, 2, 3, 4, 5,}));
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }

    public static ListNode reverseList1(ListNode head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return head;
        }

        ListNode node = reverseList1(head.next);
        head.next.next = head;
        head.next = null;
        return node;
    }

    public static ListNode reverseList2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode cur = head;
        ListNode pre = null;
        while(cur != null) {
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;
    }

    private static ListNode createList(int[] nums) {
        ListNode dummy = new ListNode();
        ListNode pre =dummy;
        for (int num : nums) {
            pre.next = new ListNode(num);
            pre = pre.next;
        }
        return dummy.next;
    }

    static class ListNode {
        int val;

        ListNode next;

        public ListNode() {
        }

        public ListNode(int val) {
            this.val = val;
        }

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
