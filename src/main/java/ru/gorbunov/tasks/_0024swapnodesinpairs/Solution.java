package ru.gorbunov.tasks._0024swapnodesinpairs;

import ru.gorbunov.tasks.structure.list.ListNode;

/**
 * 24. Swap Nodes in Pairs
 * <p>
 * Given a linked list, swap every two adjacent nodes and return its head. You must solve the problem without modifying
 * the values in the list's nodes (i.e., only nodes themselves may be changed.)
 * <p>
 * Example 1:
 * Input: head = [1,2,3,4]
 * Output: [2,1,4,3]
 * Example 2:
 * Input: head = []
 * Output: []
 * Example 3:
 * Input: head = [1]
 * Output: [1]
 * Constraints:
 * The number of nodes in the list is in the range [0, 100].
 * 0 <= Node.val <= 100
 */
public class Solution {

    public ListNode swapPairs(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode dummy = new ListNode(-1, head);

        ListNode p0 = dummy;
        ListNode p1 = dummy.next;
        ListNode p2 = p1.next;
        ListNode p3 = p2 != null ? p2.next : null;
        while (p2 != null) {
            p0.next = p2;
            p1.next = p3;
            p2.next = p1;

            p0 = p1;
            p1 = p0.next;
            p2 = p1 != null ? p1.next : null;
            p3 = p2 != null ? p2.next : null;
        }

        return dummy.next;
    }
}
