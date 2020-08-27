package ru.gorbunov.tasks._0053maximumsubarray;

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
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};

        final int result = solution.maxSubArray(nums);

        Assertions.assertEquals(6, result);
    }

    @Test
    void example2() {
        int[] nums = {-2, -3, -4, -5};

        final int result = solution.maxSubArray(nums);

        Assertions.assertEquals(-2, result);
    }
}