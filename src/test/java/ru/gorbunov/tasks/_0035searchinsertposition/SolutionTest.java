package ru.gorbunov.tasks._0035searchinsertposition;

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
        int[] nums = new int[]{1, 3, 5, 6};
        int target = 5;

        int result = solution.searchInsert(nums, target);

        Assertions.assertEquals(2, result);
    }

    @Test
    void example2() {
        int[] nums = new int[]{1, 3, 5, 6};
        int target = 2;

        int result = solution.searchInsert(nums, target);

        Assertions.assertEquals(1, result);
    }

    @Test
    void example3() {
        int[] nums = new int[]{1, 3, 5, 6};
        int target = 7;

        int result = solution.searchInsert(nums, target);

        Assertions.assertEquals(4, result);
    }

    @Test
    void example4() {
        int[] nums = new int[]{1, 3, 5, 6};
        int target = 0;

        int result = solution.searchInsert(nums, target);

        Assertions.assertEquals(0, result);
    }

    @Test
    void example5() {
        int[] nums = new int[]{1};
        int target = 0;

        int result = solution.searchInsert(nums, target);

        Assertions.assertEquals(0, result);
    }

}