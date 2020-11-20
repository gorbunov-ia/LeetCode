package ru.gorbunov.tasks._0002addtwonumbers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.gorbunov.tasks.structure.list.ListNode;

import java.util.StringJoiner;

class SolutionTest {

    private Solution solution;

    @BeforeEach
    void setUp() {
        solution = new Solution();
    }

    @Test
    void example1() {
        ListNode l1 = createListNodes(2, 4, 3);
        ListNode l2 = createListNodes(5, 6, 4);

        final ListNode result = solution.addTwoNumbers(l1, l2);

        Assertions.assertEquals("[7,0,8]", convertToString(result));
    }

    private static String convertToString(ListNode listNode) {
        StringJoiner joiner = new StringJoiner(",", "[", "]");
        while (listNode.next != null) {
            joiner.add(String.valueOf(listNode.val));
            listNode = listNode.next;
        }
        joiner.add(String.valueOf(listNode.val));
        return joiner.toString();
    }

    private static ListNode createListNodes(int... values) {
        if (values == null || values.length == 0) {
            throw new IllegalArgumentException();
        }
        ListNode head = new ListNode(values[0]);
        ListNode previousNode = head;
        for (int i = 1; i < values.length; i++) {
            ListNode listNode = new ListNode(values[i]);
            previousNode.next = listNode;
            previousNode = listNode;
        }
        return head;
    }
}