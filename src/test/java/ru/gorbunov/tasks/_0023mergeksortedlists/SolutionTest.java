package ru.gorbunov.tasks._0023mergeksortedlists;

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
        ListNode l1 = new ListNode(1, new ListNode(4, new ListNode(5)));
        ListNode l2 = new ListNode(1, new ListNode(3, new ListNode(4)));
        ListNode l3 = new ListNode(2, new ListNode(6));
        ListNode[] lists = new ListNode[]{l1, l2, l3};

        ListNode result = solution.mergeKLists(lists);

        assertResultList(result);
    }

    private void assertResultList(ListNode result) {
        Assertions.assertEquals(1, result.val);
        result = result.next;
        Assertions.assertEquals(1, result.val);
        result = result.next;
        Assertions.assertEquals(2, result.val);
        result = result.next;
        Assertions.assertEquals(3, result.val);
        result = result.next;
        Assertions.assertEquals(4, result.val);
        result = result.next;
        Assertions.assertEquals(4, result.val);
        result = result.next;
        Assertions.assertEquals(5, result.val);
        result = result.next;
        Assertions.assertEquals(6, result.val);
        Assertions.assertNull(result.next);
    }

    @Test
    void example2() {
        ListNode[] lists = new ListNode[0];

        ListNode result = solution.mergeKLists(lists);

        Assertions.assertNull(result);
    }

    @Test
    void example3() {
        ListNode[] lists = new ListNode[]{null};

        ListNode result = solution.mergeKLists(lists);

        Assertions.assertNull(result);
    }

}