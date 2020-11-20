package ru.gorbunov.tasks._0019removenthnode;


import ru.gorbunov.tasks.structure.list.ListNode;

/**
 * Remove Nth Node From End of List
 * <p>
 * Given a linked list, remove the n-th node from the end of list and return its head.
 * Example:
 * Given linked list: 1->2->3->4->5, and n = 2.
 * After removing the second node from the end, the linked list becomes 1->2->3->5.
 * <p>
 * Note: Given n will always be valid.
 * Follow up: Could you do this in one pass?
 */
public class Solution {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode node = findParentNode(head, n);
        if (node == null) {
            return head.next;
        }
        removeChildNode(node);
        return head;
    }

    private ListNode findParentNode(ListNode head, int n) {
        ListNode targetNode = null;
        int targetNumber = 1;

        ListNode currentNode = head;
        while (currentNode.next != null) {
            if (targetNumber == n) {
                if (targetNode == null) {
                    targetNode = head;
                } else {
                    targetNode = targetNode.next;
                }
            } else {
                targetNumber++;
            }
            currentNode = currentNode.next;
        }
        return targetNode;
    }

    private void removeChildNode(ListNode node) {
        ListNode child = node.next;
        if (child != null) {
            node.next = child.next;
        }
    }

    public ListNode equalRemoveNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode first = dummy;
        ListNode second = dummy;
        // Advances first pointer so that the gap between first and second is n nodes apart
        for (int i = 1; i <= n + 1; i++) {
            first = first.next;
        }
        // Move first to the end, maintaining the gap
        while (first != null) {
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        return dummy.next;
    }
}


