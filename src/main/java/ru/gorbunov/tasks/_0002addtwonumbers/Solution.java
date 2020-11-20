package ru.gorbunov.tasks._0002addtwonumbers;

import ru.gorbunov.tasks.structure.list.ListNode;

/**
 * Add Two Numbers
 * <p>
 * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse
 * order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 * Example 1:
 * Input: l1 = [2,4,3], l2 = [5,6,4]
 * Output: [7,0,8]
 * Explanation: 342 + 465 = 807.
 * Example 2:
 * Input: l1 = [0], l2 = [0]
 * Output: [0]
 * Example 3:
 * Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
 * Output: [8,9,9,9,0,0,0,1]
 * Constraints:
 * The number of nodes in each linked list is in the range [1, 100].
 * 0 <= Node.val <= 9
 * It is guaranteed that the list represents a number that does not have leading zeros.
 */
public class Solution {

    public ListNode addTwoNumbers(ListNode inputList1, ListNode inputList2) {
        ListNode head = new ListNode(0);
        ListNode list1 = inputList1;
        ListNode list2 = inputList2;
        ListNode currentNode = head;
        int sum;
        boolean reserve = false;

        while (list1 != null || list2 != null) {

            sum = reserve ? 1 : 0;
            if (list1 != null) {
                sum += list1.val;
                list1 = list1.next;
            }
            if (list2 != null) {
                sum += list2.val;
                list2 = list2.next;
            }
            if (sum < 10) {
                currentNode.next = new ListNode(sum);
                reserve = false;
            } else {
                currentNode.next = new ListNode(sum - 10);
                reserve = true;
            }
            currentNode = currentNode.next;
        }
        if (reserve) {
            currentNode.next = new ListNode(1);
        }

        return head.next;
    }
}
