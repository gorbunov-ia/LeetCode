package ru.gorbunov.tasks._0148sortlist;

import ru.gorbunov.tasks.structure.list.ListNode;

/**
 * Sort List
 * <p>
 * Given the head of a linked list, return the list after sorting it in ascending order.
 * Follow up: Can you sort the linked list in O(n logn) time and O(1) memory (i.e. constant space)?
 * Example 1:
 * Input: head = [4,2,1,3]
 * Output: [1,2,3,4]
 * Example 2:
 * Input: head = [-1,5,3,4,0]
 * Output: [-1,0,3,4,5]
 * Example 3:
 * Input: head = []
 * Output: []
 * Constraints:
 * The number of nodes in the list is in the range [0, 5 * 104].
 * -105 <= Node.val <= 105
 */
public class Solution {

    private final ListNode tmp = new ListNode();

    /**
     * Space complexity is O(n) - recursion
     */
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode previous = head;
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            previous = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        previous.next = null;
        return merge(sortList(head), sortList(slow));
    }

    private ListNode merge(ListNode n1, ListNode n2) {
        ListNode node = tmp;
        while (n1 != null && n2 != null) {
            if (n1.val < n2.val) {
                node.next = n1;
                n1 = n1.next;
            } else {
                node.next = n2;
                n2 = n2.next;
            }
            node = node.next;
        }
        if (n1 != null) {
            node.next = n1;
        } else {
            node.next = n2;
        }
        node = tmp.next;
        tmp.next = null;
        return node;
    }
}
