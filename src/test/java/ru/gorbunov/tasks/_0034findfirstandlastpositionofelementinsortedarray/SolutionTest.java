package ru.gorbunov.tasks._0034findfirstandlastpositionofelementinsortedarray;

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
        int[] nums = new int[]{5, 7, 7, 8, 8, 10};

        final int[] range = solution.searchRange(nums, 8);

        Assertions.assertArrayEquals(new int[]{3, 4}, range);
    }


    @Test
    void example2() {
        int[] nums = new int[]{5, 7, 7, 8, 8, 10};

        final int[] range = solution.searchRange(nums, 6);

        Assertions.assertArrayEquals(new int[]{-1, -1}, range);
    }
}