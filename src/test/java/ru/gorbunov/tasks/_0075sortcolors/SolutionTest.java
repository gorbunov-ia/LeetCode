package ru.gorbunov.tasks._0075sortcolors;

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
        int[] nums = {2, 0, 2, 1, 1, 0};

        solution.sortColors(nums);

        Assertions.assertArrayEquals(new int[]{0, 0, 1, 1, 2, 2}, nums);
    }

    @Test
    void example2() {
        int[] nums = {2, 0, 1};

        solution.sortColors(nums);

        Assertions.assertArrayEquals(new int[]{0, 1, 2}, nums);
    }

    @Test
    void example3() {
        int[] nums = {0};

        solution.sortColors(nums);

        Assertions.assertArrayEquals(new int[]{0}, nums);
    }

    @Test
    void example4() {
        int[] nums = {1};

        solution.sortColors(nums);

        Assertions.assertArrayEquals(new int[]{1}, nums);
    }
}