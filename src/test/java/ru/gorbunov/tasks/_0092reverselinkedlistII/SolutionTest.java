package ru.gorbunov.tasks._0092reverselinkedlistII;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.gorbunov.tasks.structure.tree.ListNode;

class SolutionTest {

    private Solution solution;

    @BeforeEach
    void setUp() {
        solution = new Solution();
    }

    @Test
    void example1() {
        ListNode head = defaultList();

        final ListNode result = solution.reverseBetween(head, 2, 4);

        assertList1(result, 1, 4, 3, 2, 5);
    }

    @Test
    void example2() {
        ListNode head = defaultList();

        final ListNode result = solution.reverseBetween(head, 1, 3);

        assertList1(result, 3, 2, 1, 4, 5);
    }

    @Test
    void example3() {
        ListNode head = defaultList();

        final ListNode result = solution.reverseBetween(head, 4, 5);

        assertList1(result, 1, 2, 3, 5, 4);
    }

    @Test
    void example4() {
        ListNode head = defaultList();

        final ListNode result = solution.reverseBetween(head, 1, 5);

        assertList1(result, 5, 4, 3, 2, 1);
    }

    private void assertList1(ListNode head, int... values) {
        if (values.length == 0) {
            throw new IllegalArgumentException();
        }
        ListNode current = head;
        for (int value : values) {
            Assertions.assertEquals(value, current.val);
            current = current.next;
        }
        Assertions.assertNull(current);
    }

    private ListNode defaultList() {
        return createList(1, 2, 3, 4, 5);
    }

    private ListNode createList(int... items) {
        ListNode node = null;
        for (int i = items.length - 1; i >= 0; i--) {
            node = new ListNode(items[i], node);
        }
        return node;
    }
}