package ru.gorbunov.tasks._0055jumpgame;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SolutionTest {

    private Solution solution;

    @BeforeEach
    void setUp() {
        solution = new Solution();
    }

    @Test
    void example1() {
        int[] nums = {2, 3, 1, 1, 4};

        final boolean result = solution.canJump(nums);

        Assertions.assertTrue(result);
    }


    @Test
    void example2() {
        int[] nums = {3, 2, 1, 0, 4};

        final boolean result = solution.canJump(nums);

        Assertions.assertFalse(result);
    }
}