package ru.gorbunov.tasks._0019removenthnode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static ru.gorbunov.tasks._0019removenthnode.Solution.ListNode;

class SolutionTest {

    private Solution solution;

    @BeforeEach
    void setUp() {
        solution = new Solution();
    }

    @Test
    void example1() {
        final ListNode list = buildList();

        final ListNode result = solution.removeNthFromEnd(list, 2);

        assertList(result);
    }

    @Test
    void example2() {
        final ListNode list = new ListNode(1);

        final ListNode result = solution.removeNthFromEnd(list, 1);

        Assertions.assertNull(result);
    }

    @Test
    void example3() {
        final ListNode last = new ListNode(2);
        final ListNode list = new ListNode(1, last);

        final ListNode result = solution.removeNthFromEnd(list, 1);

        Assertions.assertEquals(1, result.val);
        Assertions.assertNull(result.next);
    }

    @Test
    void example4() {
        final ListNode last = new ListNode(2);
        final ListNode list = new ListNode(1, last);

        final ListNode result = solution.removeNthFromEnd(list, 2);

        Assertions.assertEquals(2, result.val);
        Assertions.assertNull(result.next);

    }

    private ListNode buildList() {
        final ListNode n5 = new ListNode(5);
        final ListNode n4 = new ListNode(4, n5);
        final ListNode n3 = new ListNode(3, n4);
        final ListNode n2 = new ListNode(2, n3);
        return new ListNode(1, n2);
    }


    private void assertList(ListNode result) {
        ListNode node = result;
        Assertions.assertEquals(1, node.val);
        node = node.next;
        Assertions.assertEquals(2, node.val);
        node = node.next;
        Assertions.assertEquals(3, node.val);
        node = node.next;
        Assertions.assertEquals(5, node.val);
        Assertions.assertNull(node.next);
    }

}