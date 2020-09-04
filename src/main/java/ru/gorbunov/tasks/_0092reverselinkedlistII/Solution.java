package ru.gorbunov.tasks._0092reverselinkedlistII;

/**
 * Reverse Linked List II
 * <p>
 * Reverse a linked list from position m to n. Do it in one-pass.
 * Note: 1 ≤ m ≤ n ≤ length of list.
 * Example:
 * Input: 1->2->3->4->5->NULL, m = 2, n = 4
 * Output: 1->4->3->2->5->NULL
 */
public class Solution {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode dummy = new ListNode(-1, head);

        int index = 1;

        ListNode zero = dummy;
        ListNode first = null;
        ListNode previous = null;
        ListNode current = dummy.next;

        while(current != null) {
            ListNode next = current.next;
            if (first != null) {
                if (index <= n) {
                    // swap 2
                    current.next = previous;
                    previous = current;
                }
                if (index == n) {
                    // update zero, first
                    zero.next = current;
                    first.next = next;
                    break;
                }
            }
            if (index == m - 1) {
                zero = current;
            }
            if (index == m) {
                first = current;
                previous = current;
            }

            current = next;
            index++;
        }


        return dummy.next;
    }
}
