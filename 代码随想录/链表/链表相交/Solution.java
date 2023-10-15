package 代码随想录.链表.链表相交;


/**
 * 链表相交 Leetcode160 <a href="https://leetcode.cn/problems/intersection-of-two-linked-lists/">
 *
 * @author phix
 * @date 2023/10/15
 */
public class Solution {

    public static void main(String[] args) {
        ListNode node = createList(new int[]{8, 4, 5});
        ListNode list1 = createList(new int[]{4, 1});
        list1.next.next = node;
        ListNode list2 = createList(new int[]{5, 0, 1});
        list2.next.next.next = node;

        ListNode intersectionNode = getIntersectionNode(list1, list2);
        while(intersectionNode != null) {
            System.out.println(intersectionNode.val);
            intersectionNode = intersectionNode.next;
        }
    }
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        int indexA = 0;
        int indexB = 0;
        ListNode preA = headA;
        while (preA != null) {
            preA = preA.next;
            indexA++;
        }
        ListNode preB = headB;
        while (preB != null) {
            preB = preB.next;
            indexB++;
        }
        if (indexA > indexB) {
            for (int i = 0; i < indexA - indexB; i++) {
                headA = headA.next;
            }
        } else {
            for (int i = 0; i < indexB - indexA; i++) {
                headB = headB.next;
            }
        }

        while (headA != null) {
            if (headA == headB) {
                return headA;
            }
            headA = headA.next;
            headB = headB.next;
        }
        return null;
    }

    private static ListNode createList(int[] nums) {
        ListNode dummy = new ListNode(0);
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

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

}
