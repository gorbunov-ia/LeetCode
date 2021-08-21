package ru.gorbunov.tasks._0234palindromelinkedlist;

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
        ListNode l3 = new ListNode(1);
        ListNode l2 = new ListNode(2, l3);
        ListNode l1 = new ListNode(2, l2);
        ListNode l0 = new ListNode(1, l1);

        boolean result = solution.isPalindrome(l0);

        Assertions.assertTrue(result);
    }

    @Test
    void example2() {
        ListNode l1 = new ListNode(2);
        ListNode l0 = new ListNode(1, l1);

        boolean result = solution.isPalindrome(l0);

        Assertions.assertFalse(result);
    }

    @Test
    void example3() {
        ListNode l4 = new ListNode(1);
        ListNode l3 = new ListNode(2, l4);
        ListNode l2 = new ListNode(3, l3);
        ListNode l1 = new ListNode(2, l2);
        ListNode l0 = new ListNode(1, l1);

        boolean result = solution.isPalindrome(l0);

        Assertions.assertTrue(result);
    }
}