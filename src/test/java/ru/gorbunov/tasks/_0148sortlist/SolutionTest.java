package ru.gorbunov.tasks._0148sortlist;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.gorbunov.tasks.structure.list.ListNode;

class SolutionTest {

    private Solution solution;

    @BeforeEach
    void setUp() {
        solution = new Solution();
    }

    @Test
    void example1() {
        ListNode head = new ListNode(4, new ListNode(2, new ListNode(1, new ListNode(3))));

        final ListNode result = solution.sortList(head);

        assert1(result);
    }

    private void assert1(ListNode node) {
        Assertions.assertEquals(1, node.val);
        node = node.next;
        Assertions.assertEquals(2, node.val);
        node = node.next;
        Assertions.assertEquals(3, node.val);
        node = node.next;
        Assertions.assertEquals(4, node.val);
        Assertions.assertNull(node.next);
    }


    @Test
    void example2() {
        ListNode head = new ListNode(-1, new ListNode(5, new ListNode(3, new ListNode(4, new ListNode(0)))));

        final ListNode result = solution.sortList(head);

        assert2(result);
    }

    private void assert2(ListNode node) {
        Assertions.assertEquals(-1, node.val);
        node = node.next;
        Assertions.assertEquals(0, node.val);
        node = node.next;
        Assertions.assertEquals(3, node.val);
        node = node.next;
        Assertions.assertEquals(4, node.val);
        node = node.next;
        Assertions.assertEquals(5, node.val);
        Assertions.assertNull(node.next);
    }

    @Test
    void example3() {
        ListNode head = null;

        final ListNode result = solution.sortList(head);

        Assertions.assertNull(result);
    }
}