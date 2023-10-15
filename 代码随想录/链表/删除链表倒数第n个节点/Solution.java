package 代码随想录.链表.删除链表倒数第n个节点;

/**
 * 删除链表倒数第n个节点 Leetcode19 <a href="https://leetcode.cn/problems/remove-nth-node-from-end-of-list">
 *
 * @author phix
 * @date 2023/10/15
 */
public class Solution {

    public static void main(String[] args) {
        output(removeNthFromEnd(createList(new int[]{1, 2, 3, 4, 5}), 2));
        output(removeNthFromEnd(createList(new int[]{1}), 1));
        output(removeNthFromEnd(createList(new int[]{1, 2}), 1));

    }

    private static void output(ListNode listNode1) {
        while (listNode1 != null) {
            System.out.println(listNode1.val);
            listNode1 = listNode1.next;
        }
        System.out.println("-----------------");
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode slow = dummy;
        ListNode fast = head;
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }

        while(fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;

        return dummy.next;
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
