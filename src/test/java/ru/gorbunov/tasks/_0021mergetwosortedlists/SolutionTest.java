package ru.gorbunov.tasks._0021mergetwosortedlists;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static ru.gorbunov.tasks._0021mergetwosortedlists.Solution.ListNode;

class SolutionTest {

    private Solution solution;

    @BeforeEach
    void setUp() {
        solution = new Solution();
    }

    @Test
    void example1() {
        final ListNode l1 = createList(1, 2, 4);
        final ListNode l2 = createList(1, 3, 4);

        final ListNode result = solution.mergeTwoLists(l1, l2);

        assertList6(result);
    }

    @Test
    void example2() {
        final ListNode l1 = createList(1, 2, 3);
        final ListNode l2 = new ListNode(1);

        final ListNode result = solution.mergeTwoLists(l1, l2);

        assertList4(result);
    }

    @Test
    void example3() {
        final ListNode l1 = new ListNode(1);
        final ListNode l2 = createList(1, 2, 3);

        final ListNode result = solution.mergeTwoLists(l1, l2);

        assertList4(result);
    }

    private void assertList6(ListNode list) {
        Assertions.assertEquals(1, list.val);
        list = list.next;
        Assertions.assertEquals(1, list.val);
        list = list.next;
        Assertions.assertEquals(2, list.val);
        list = list.next;
        Assertions.assertEquals(3, list.val);
        list = list.next;
        Assertions.assertEquals(4, list.val);
        list = list.next;
        Assertions.assertEquals(4, list.val);
        Assertions.assertNull(list.next);
    }

    private void assertList4(ListNode list) {
        Assertions.assertEquals(1, list.val);
        list = list.next;
        Assertions.assertEquals(1, list.val);
        list = list.next;
        Assertions.assertEquals(2, list.val);
        list = list.next;
        Assertions.assertEquals(3, list.val);
        Assertions.assertNull(list.next);
    }

    private ListNode createList(int first, int second, int third) {
        final ListNode n3 = new ListNode(third);
        final ListNode n2 = new ListNode(second, n3);
        return new ListNode(first, n2);
    }
}