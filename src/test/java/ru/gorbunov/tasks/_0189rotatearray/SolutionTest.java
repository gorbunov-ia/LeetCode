package ru.gorbunov.tasks._0189rotatearray;

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
        int[] nums = new int[]{1, 2, 3, 4, 5, 6, 7};
        int k = 3;

        solution.rotate(nums, k);

        Assertions.assertArrayEquals(new int[]{5, 6, 7, 1, 2, 3, 4}, nums);
    }

    @Test
    void example2() {
        int[] nums = new int[]{-1, -100, 3, 99};
        int k = 2;

        solution.rotate(nums, k);

        Assertions.assertArrayEquals(new int[]{3, 99, -1, -100}, nums);
    }

    @Test
    void example3() {
        int[] nums = new int[]{1, 2, 3, 4, 5, 6};
        int k = 2;

        solution.rotate(nums, k);

        Assertions.assertArrayEquals(new int[]{5, 6, 1, 2, 3, 4}, nums);
    }

    @Test
    void example4() {
        int[] nums = new int[]{1, 2, 3, 4, 5, 6};
        int k = 3;

        solution.rotate(nums, k);

        Assertions.assertArrayEquals(new int[]{4, 5, 6, 1, 2, 3}, nums);
    }
}