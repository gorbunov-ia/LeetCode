package ru.gorbunov.tasks._0160intersectionoftwolinkedlists;

import ru.gorbunov.tasks.structure.list.ListNode;

/**
 * 160. Intersection of Two Linked Lists
 * <p>
 * Given the heads of two singly linked-lists headA and headB, return the node at which the two lists intersect.
 * If the two linked lists have no intersection at all, return null.
 * Example 1:
 * Input: intersectVal = 8, listA = [4,1,8,4,5], listB = [5,6,1,8,4,5], skipA = 2, skipB = 3
 * Output: Intersected at '8'
 * Example 2:
 * Input: intersectVal = 2, listA = [1,9,1,2,4], listB = [3,2,4], skipA = 3, skipB = 1
 * Output: Intersected at '2'
 * Example 3:
 * Input: intersectVal = 0, listA = [2,6,4], listB = [1,5], skipA = 3, skipB = 2
 * Output: No intersection
 * Explanation: The two lists do not intersect, so return null.
 * Constraints:
 * The number of nodes of listA is in the m.
 * The number of nodes of listB is in the n.
 * 1 <= m, n <= 3 * 10^4
 * 1 <= Node.val <= 10^5
 * 0 <= skipA < m
 * 0 <= skipB < n
 * intersectVal is 0 if listA and listB do not intersect.
 * intersectVal == listA[skipA] == listB[skipB] if listA and listB intersect.
 * Follow up: Could you write a solution that runs in O(m + n) time and use only O(1) memory?
 */
public class Solution {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode node = headA;
        while (node != null) {
            node.val *= -1;
            node = node.next;
        }

        node = headB;
        while (node != null) {
            if (node.val < 0) {
                break;
            }
            node = node.next;
        }
        ListNode result = node;

        node = headA;
        while (node != null) {
            node.val *= -1;
            node = node.next;
        }

        return result;
    }
}
