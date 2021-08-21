package ru.gorbunov.tasks._0234palindromelinkedlist;

import ru.gorbunov.tasks.structure.list.ListNode;

/**
 * 234. Palindrome Linked List
 * <p>
 * Given the head of a singly linked list, return true if it is a palindrome.
 * Example 1:
 * Input: head = [1,2,2,1]
 * Output: true
 * Example 2:
 * Input: head = [1,2]
 * Output: false
 * Constraints:
 * The number of nodes in the list is in the range [1, 105].
 * 0 <= Node.val <= 9
 * Follow up: Could you do it in O(n) time and O(1) space?
 */
public class Solution {

    /*
     * Runtime complexity O(N)
     * Space complexity O(N)
     */
    public boolean isPalindrome(ListNode head) {
        if (head == null) {
            return false;
        }
        ListNode tail = new ListNode(head.val);

        ListNode node = head.next;
        while (node != null) {
            tail = new ListNode(node.val, tail);
            node = node.next;
        }

        node = head;
        while (node != null && tail != null) {
            if (node.val != tail.val) {
                return false;
            }
            node = node.next;
            tail = tail.next;
        }

        return node == null && tail == null;
    }

    /*
     * Runtime complexity O(N)
     * Space complexity O(1)
     */
    public boolean isPalindromeSpace(ListNode head) {
        if (head == null) {
            return false;
        }

        ListNode previous = null;
        ListNode slow = head;
        ListNode fast = head;

        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;

            ListNode next = slow.next;
            slow.next = previous;
            previous = slow;
            slow = next;
        }

        ListNode toTail = slow.next;
        ListNode toHead;
        if (fast.next == null) {
            //odd
            toHead = previous;
        } else {
            //even
            toHead = slow;
            slow.next = previous;
        }

        while (toHead != null && toTail != null) {
            if (toHead.val != toTail.val) {
                return false;
            }
            toHead = toHead.next;
            toTail = toTail.next;
        }

        return toHead == null && toTail == null;
    }
}
