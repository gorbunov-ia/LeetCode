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

    /*
     * Runtime complexity O(N*log(k))
     * Space complexity O(N)
     */
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

    /*
     * Runtime complexity O(N*log(k))
     * Space complexity O(1)
     */
    public ListNode mergeKListsSpace(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        int interval = 1;
        while (interval < lists.length) {
            for (int i = 0; i + interval < lists.length; i = i + interval * 2) {
                lists[i] = mergeTwoLists(lists[i], lists[i + interval]);
            }
            interval *= 2;
        }

        return lists[0];
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode h = new ListNode(0);
        ListNode ans = h;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                h.next = l1;
                h = h.next;
                l1 = l1.next;
            } else {
                h.next = l2;
                h = h.next;
                l2 = l2.next;
            }
        }
        if (l1 == null) {
            h.next = l2;
        }
        if (l2 == null) {
            h.next = l1;
        }
        return ans.next;
    }
}
