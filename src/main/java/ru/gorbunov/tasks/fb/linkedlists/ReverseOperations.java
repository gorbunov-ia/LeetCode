package ru.gorbunov.tasks.fb.linkedlists;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * Reverse Operations
 * <p>
 * You are given a singly-linked list that contains N integers. A subpart of the list is a contiguous set of even
 * elements, bordered either by the end of the list or an odd element. For example, if the list is [1, 2, 8, 9, 12, 16],
 * the subparts of the list are [2, 8] and [12, 16].
 * Then, for each subpart, the order of the elements is reversed. In the example, this would result in the new list,
 * [1, 8, 2, 9, 16, 12].
 * The goal of this question is: given a resulting list, determine the original order of the elements.
 * Implementation detail:
 * You must use the following definition for elements in the linked list:
 * class Node {
 *     int data;
 *     Node next;
 * }
 * Signature
 * Node reverse(Node head)
 * Constraints
 * 1 <= N <= 1000, where N is the size of the list
 * 1 <= Li <= 10^9, where Li is the ith element of the list
 * Example
 * Input:
 * N = 6
 * list = [1, 2, 8, 9, 12, 16]
 * Output:
 * [1, 8, 2, 9, 16, 12]
 */
public class ReverseOperations {

    static class Node {
        int data;
        Node next;
        Node(int x) {
            data = x;
            next = null;
        }
    }

    Node reverse(Node head) {
        // Write your code here
        Node dummy = new Node(-1);
        dummy.next = head;

        Node current = dummy;

        int index = 0;
        int startIndex = 0;
        Deque<Node> stack = new LinkedList<>();
        Node zero = current;

        while(current != null) {
            if (!stack.isEmpty()) {
                if (current.data % 2 == 0) {
                    stack.push(current);
                }
                final boolean last = current.next == null;
                if (last || (current.data % 2 != 0 && (startIndex % 2 == 0 || startIndex == 1))) {
                    Node temp = null;
                    while (!stack.isEmpty()) {
                        Node node = stack.pop();
                        if (temp == null) {
                            zero.next = node;
                        } else {
                            temp.next = node;
                        }
                        temp = node;
                    }
                    temp.next = !last ? current : null;
                }
                if (last) {
                    break;
                }
                if (!last && current.data % 2 != 0 && startIndex % 2 != 0) {
                    stack.clear();
                }
            }
            if (stack.isEmpty() && current.data % 2 == 0) {
                stack.push(current);
                startIndex = index;
            }
            if (stack.isEmpty()) {
                zero = current;
            }
            current = current.next;
            index++;
        }

        return dummy.next;
    }

}
