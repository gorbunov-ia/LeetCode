package ru.gorbunov.tasks._0033searchinrotatedsortedarray;

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
        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        int target = 0;

        final int index = solution.search(nums, target);

        Assertions.assertEquals(4, index);
    }

    @Test
    void example2() {
        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        int target = 3;

        final int index = solution.search(nums, target);

        Assertions.assertEquals(-1, index);
    }

    @Test
    void example3() {
        int[] nums = {1};
        int target = 0;

        final int index = solution.search(nums, target);

        Assertions.assertEquals(-1, index);
    }

    @Test
    void example4() {
        int[] nums = {1};
        int target = 1;

        final int index = solution.search(nums, target);

        Assertions.assertEquals(0, index);
    }

    @Test
    void example5() {
        int[] nums = {1, 3};
        int target = 0;

        final int index = solution.search(nums, target);

        Assertions.assertEquals(-1, index);
    }

    @Test
    void example6() {
        int[] nums = {};
        int target = 1;

        final int index = solution.search(nums, target);

        Assertions.assertEquals(-1, index);
    }
}