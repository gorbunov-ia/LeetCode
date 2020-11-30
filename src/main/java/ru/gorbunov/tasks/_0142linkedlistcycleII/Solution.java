package ru.gorbunov.tasks._0142linkedlistcycleII;

import ru.gorbunov.tasks.structure.list.ListNode;

/**
 * Linked List Cycle II
 * <p>
 * Given a linked list, return the node where the cycle begins. If there is no cycle, return null.
 * There is a cycle in a linked list if there is some node in the list that can be reached again by continuously
 * following the next pointer. Internally, pos is used to denote the index of the node that tail's next pointer is connected to. Note that pos is not passed as a parameter.
 * Notice that you should not modify the linked list.
 * Example 1:
 * Input: head = [3,2,0,-4], pos = 1
 * Output: tail connects to node index 1
 * Explanation: There is a cycle in the linked list, where tail connects to the second node.
 * Example 2:
 * Input: head = [1,2], pos = 0
 * Output: tail connects to node index 0
 * Explanation: There is a cycle in the linked list, where tail connects to the first node.
 * Example 3:
 * Input: head = [1], pos = -1
 * Output: no cycle
 * Explanation: There is no cycle in the linked list.
 * Constraints:
 * The number of the nodes in the list is in the range [0, 104].
 * -105 <= Node.val <= 105
 * pos is -1 or a valid index in the linked-list.
 * Follow up: Can you solve it using O(1) (i.e. constant) memory?
 */
public class Solution {
    private static final int minVal = -100_000;
    private static final int maxVal = 100_000;
    private static final int mark = maxVal - minVal + 1;

    public ListNode detectCycle(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode previous = null;
        ListNode current = head;
        while (current != null) {
            ListNode next = current.next;
            if (!inRange(current.val)) {
                break;
            }
            current.val += mark;
            current.next = previous;
            previous = current;

            current = next;
        }

        ListNode cycle = current;
        while (previous != null) {
            ListNode next = previous.next;
            previous.val -= mark;
            previous.next = current;
            current = previous;

            previous = next;
        }

        return cycle;
    }

    private boolean inRange(int val) {
        return val >= minVal && val <= maxVal;
    }

    /**
     * Floyd's algorithm
     */
    public ListNode withOutModifyingDetectCycle(ListNode head) {
        if (head == null || head.next == null) return null;
        ListNode slow = head, fast = head, start = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                while (slow != start) {
                    slow = slow.next;
                    start = start.next;
                }
                return start;
            }
        }
        return null;
    }


}
