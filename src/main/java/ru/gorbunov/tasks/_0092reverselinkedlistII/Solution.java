package ru.gorbunov.tasks._0092reverselinkedlistII;

import ru.gorbunov.tasks.structure.tree.ListNode;

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

    public ListNode newReverseBetween(ListNode head, int m, int n) {

        // Empty list
        if (head == null) {
            return null;
        }

        // Move the two pointers until they reach the proper starting point
        // in the list.
        ListNode cur = head, prev = null;
        while (m > 1) {
            prev = cur;
            cur = cur.next;
            m--;
            n--;
        }

        // The two pointers that will fix the final connections.
        ListNode con = prev, tail = cur;

        // Iteratively reverse the nodes until n becomes 0.
        ListNode third = null;
        while (n > 0) {
            third = cur.next;
            cur.next = prev;
            prev = cur;
            cur = third;
            n--;
        }

        // Adjust the final connections as explained in the algorithm
        if (con != null) {
            con.next = prev;
        } else {
            head = prev;
        }

        tail.next = cur;
        return head;
    }
}
