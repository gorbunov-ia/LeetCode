package ru.gorbunov.tasks._0206reverselinkedlist;

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
        final ListNode head = createList(1, 2, 3, 4, 5);

        final ListNode result = solution.reverseList(head);

        assertResult(result);
    }

    private void assertResult(ListNode head) {
        Assertions.assertEquals(5, head.val);
        head = head.next;
        Assertions.assertEquals(4, head.val);
        head = head.next;
        Assertions.assertEquals(3, head.val);
        head = head.next;
        Assertions.assertEquals(2, head.val);
        head = head.next;
        Assertions.assertEquals(1, head.val);
        Assertions.assertNull(head.next);
    }

    private ListNode createList(int... items) {
        ListNode node = null;
        for (int i = items.length - 1; i >= 0 ; i--) {
            node = new ListNode(items[i], node);
        }
        return node;
    }
}