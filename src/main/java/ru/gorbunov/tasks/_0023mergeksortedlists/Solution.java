package ru.gorbunov.tasks._0023mergeksortedlists;

import ru.gorbunov.tasks.structure.list.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 23. Merge k Sorted Lists
 * <p>
 * You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.
 * Merge all the linked-lists into one sorted linked-list and return it.
 * Example 1:
 * Input: lists = [[1,4,5],[1,3,4],[2,6]]
 * Output: [1,1,2,3,4,4,5,6]
 * Explanation: The linked-lists are:
 * [
 * 1->4->5,
 * 1->3->4,
 * 2->6
 * ]
 * merging them into one sorted list:
 * 1->1->2->3->4->4->5->6
 * Example 2:
 * Input: lists = []
 * Output: []
 * Example 3:
 * Input: lists = [[]]
 * Output: []
 * Constraints:
 * k == lists.length
 * 0 <= k <= 10^4
 * 0 <= lists[i].length <= 500
 * -10^4 <= lists[i][j] <= 10^4
 * lists[i] is sorted in ascending order.
 * The sum of lists[i].length won't exceed 10^4.
 */
public class Solution {

    public ListNode mergeKLists(ListNode[] lists) {
        ListNode dummy = new ListNode();
        if (lists == null || lists.length == 0) {
            return null;
        }

        PriorityQueue<ListNode> queue = new PriorityQueue<>(Comparator.comparing(l -> l.val));

        for (ListNode list : lists) {
            if (list != null) {
                queue.add(list);
            }
        }

        ListNode node = dummy;
        while (!queue.isEmpty()) {
            ListNode list = queue.poll();

            ListNode next = list.next;
            list.next = null;
            node.next = list;
            node = node.next;

            if (next != null) {
                queue.add(next);
            }
        }

        return dummy.next;
    }
}
