package ru.gorbunov.tasks._0160intersectionoftwolinkedlists;

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
        ListNode a5 = new ListNode(5);
        ListNode a4 = new ListNode(4, a5);
        ListNode a3 = new ListNode(8, a4);
        ListNode a2 = new ListNode(1, a3);
        ListNode a1 = new ListNode(4, a2);

        ListNode b3 = new ListNode(1, a3);
        ListNode b2 = new ListNode(6, b3);
        ListNode b1 = new ListNode(5, b2);

        ListNode result = solution.getIntersectionNode(a1, b1);

        Assertions.assertSame(a3, result);
    }

    @Test
    void example2() {
        ListNode a5 = new ListNode(4);
        ListNode a4 = new ListNode(2, a5);
        ListNode a3 = new ListNode(1, a4);
        ListNode a2 = new ListNode(9, a3);
        ListNode a1 = new ListNode(1, a2);

        ListNode b1 = new ListNode(3, a4);

        ListNode result = solution.getIntersectionNode(a1, b1);

        Assertions.assertSame(a4, result);
    }

    @Test
    void example3() {
        ListNode a3 = new ListNode(4);
        ListNode a2 = new ListNode(6, a3);
        ListNode a1 = new ListNode(2, a2);

        ListNode b2 = new ListNode(5);
        ListNode b1 = new ListNode(1, b2);

        ListNode result = solution.getIntersectionNode(a1, b1);

        Assertions.assertNull(result);
    }
}