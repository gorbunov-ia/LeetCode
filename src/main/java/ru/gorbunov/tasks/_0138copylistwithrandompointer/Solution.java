package ru.gorbunov.tasks._0138copylistwithrandompointer;

import java.util.HashMap;
import java.util.Map;

/**
 * Copy List with Random Pointer
 * <p>
 * A linked list is given such that each node contains an additional random pointer which could point to any node in the list or null.
 * Return a deep copy of the list.
 * The Linked List is represented in the input/output as a list of n nodes. Each node is represented as a pair of [val, random_index] where:
 * val: an integer representing Node.val
 * random_index: the index of the node (range from 0 to n-1) where random pointer points to, or null if it does not point to any node.
 * Example 1:
 * Input: head = [[7,null],[13,0],[11,4],[10,2],[1,0]]
 * Output: [[7,null],[13,0],[11,4],[10,2],[1,0]]
 * Example 2:
 * Input: head = [[1,1],[2,1]]
 * Output: [[1,1],[2,1]]
 * Example 3:
 * Input: head = [[3,null],[3,0],[3,null]]
 * Output: [[3,null],[3,0],[3,null]]
 * Example 4:
 * Input: head = []
 * Output: []
 * Explanation: Given linked list is empty (null pointer), so return null.
 * Constraints:
 * -10000 <= Node.val <= 10000
 * Node.random is null or pointing to a node in the linked list.
 * The number of nodes will not exceed 1000.
 */
public class Solution {

    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        Map<Node, Integer> indexMap = new HashMap<>();
        Map<Integer, Node> newNodeMap = new HashMap<>();

        Node newDummyHead = new Node(-1);
        Node newPrevious = newDummyHead;
        int index = 0;
        Node previous = head;
        while (previous != null) {
            Node newCurrent = new Node(previous.val);
            newPrevious.next = newCurrent;

            indexMap.put(previous, index);
            newNodeMap.put(index, newCurrent);

            index++;
            newPrevious = newPrevious.next;
            previous = previous.next;
        }

        index = 0;
        previous = head;
        while (previous != null) {
            Node rand = previous.random;
            if (rand != null) {
                int oldIndex = indexMap.get(rand);
                newNodeMap.get(index).random = newNodeMap.get(oldIndex);
            }
            index++;
            previous = previous.next;
        }

        return newDummyHead.next;
    }

    public Node withoutMemoryCopyRandomList(Node head) {
        Node iter = head, next;

        // First round: make copy of each node,
        // and link them together side-by-side in a single list.
        while (iter != null) {
            next = iter.next;

            Node copy = new Node(iter.val);
            iter.next = copy;
            copy.next = next;

            iter = next;
        }

        // Second round: assign random pointers for the copy nodes.
        iter = head;
        while (iter != null) {
            if (iter.random != null) {
                iter.next.random = iter.random.next;
            }
            iter = iter.next.next;
        }

        // Third round: restore the original list, and extract the copy list.
        iter = head;
        Node pseudoHead = new Node(0);
        Node copy, copyIter = pseudoHead;

        while (iter != null) {
            next = iter.next.next;

            // extract the copy
            copy = iter.next;
            copyIter.next = copy;
            copyIter = copy;

            // restore the original list
            iter.next = next;

            iter = next;
        }

        return pseudoHead.next;
    }

    static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
}
