package ru.gorbunov.tasks._0024swapnodesinpairs;

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
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))));

        ListNode result = solution.swapPairs(head);

        Assertions.assertEquals(2, result.val);
        result = result.next;
        Assertions.assertEquals(1, result.val);
        result = result.next;
        Assertions.assertEquals(4, result.val);
        result = result.next;
        Assertions.assertEquals(3, result.val);
        Assertions.assertNull(result.next);
    }

    @Test
    void example2() {
        ListNode result = solution.swapPairs(null);

        Assertions.assertNull(result);
    }

    @Test
    void example3() {
        ListNode head = new ListNode(1);

        ListNode result = solution.swapPairs(head);

        Assertions.assertEquals(1, result.val);
        Assertions.assertNull(result.next);
    }
}