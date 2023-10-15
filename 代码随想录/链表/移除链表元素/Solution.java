package 代码随想录.链表.移除链表元素;

import java.util.List;

/**
 * 移除链表元素 Leetcode203 <a href="https://leetcode.cn/problems/remove-linked-list-elements/">
 *
 * @author phix
 * @date 2023/10/15
 */
public class Solution {

    public static void main(String[] args) {
        outputResult(removeElements(createList(new int[]{1, 2, 6, 3, 4, 5, 6}), 6));
        outputResult(removeElements(createList(new int[]{}), 1));
        outputResult(removeElements(createList(new int[]{7,7,7,7}), 7));
    }


    /**
     * 时间复杂度O(n)
     * 空间复杂度O(1)
     *
     * @param head
     * @param val
     * @return {@link ListNode}
     */
    public static ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode pre = dummy;
        while (pre.next != null) {
            if (pre.next.val == val) {
                pre.next = pre.next.next;
            } else {
                pre = pre.next;
            }
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

    private static void outputResult(ListNode listNode) {
        while(listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
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
