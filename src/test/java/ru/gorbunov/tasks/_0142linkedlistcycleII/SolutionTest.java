package ru.gorbunov.tasks._0142linkedlistcycleII;

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
        ListNode l3 = new ListNode(-4);
        ListNode l2 = new ListNode(0, l3);
        ListNode l1 = new ListNode(2, l2);
        ListNode l0 = new ListNode(3, l1);
        l3.next = l1;

        ListNode result = solution.detectCycle(l0);

        Assertions.assertEquals(l1, result);
    }

    @Test
    void example2() {
        ListNode l1 = new ListNode(2);
        ListNode l0 = new ListNode(1, l1);
        l1.next = l0;

        ListNode result = solution.detectCycle(l0);

        Assertions.assertEquals(l0, result);
    }


    @Test
    void example3() {
        ListNode l0 = new ListNode(1);

        ListNode result = solution.detectCycle(l0);

        Assertions.assertNull(result);
    }

}