package ru.gorbunov.tasks._0206reverselinkedlist;

import ru.gorbunov.tasks.structure.tree.ListNode;

/**
 * Reverse Linked List
 * <p>
 * Reverse a singly linked list.
 * Example:
 * Input: 1->2->3->4->5->NULL
 * Output: 5->4->3->2->1->NULL
 * Follow up:
 * A linked list can be reversed either iteratively or recursively. Could you implement both?
 */
public class Solution {

    public ListNode reverseList(ListNode head) {

        ListNode previous = null;
        ListNode current = head;
        while (current != null) {
            ListNode next = current.next;
            current.next = previous;
            previous = current;

            current = next;
        }

        return previous;
    }

}
