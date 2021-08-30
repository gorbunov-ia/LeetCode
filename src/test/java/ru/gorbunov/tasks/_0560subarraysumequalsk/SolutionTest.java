package ru.gorbunov.tasks._0560subarraysumequalsk;

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
        int[] nums = new int[]{1, 1, 1};
        int k = 2;

        int result = solution.subarraySum(nums, k);

        Assertions.assertEquals(2, result);
    }

    @Test
    void example2() {
        int[] nums = new int[]{1, 2, 3};
        int k = 3;

        int result = solution.subarraySum(nums, k);

        Assertions.assertEquals(2, result);
    }

    @Test
    void example3() {
        int[] nums = new int[]{0, 5};
        int k = 10;

        int result = solution.subarraySum(nums, k);

        Assertions.assertEquals(0, result);
    }

    @Test
    void example4() {
        int[] nums = new int[]{2, 3};
        int k = 5;

        int result = solution.subarraySum(nums, k);

        Assertions.assertEquals(1, result);
    }

    @Test
    void example5() {
        int[] nums = new int[]{2, 3, 0};
        int k = 5;

        int result = solution.subarraySum(nums, k);

        Assertions.assertEquals(2, result);
    }

    @Test
    void example6() {
        int[] nums = new int[]{1};
        int k = 0;

        int result = solution.subarraySum(nums, k);

        Assertions.assertEquals(0, result);
    }

    @Test
    void example7() {
        int[] nums = new int[]{1, 0};
        int k = 0;

        int result = solution.subarraySum(nums, k);

        Assertions.assertEquals(1, result);
    }

    @Test
    void example8() {
        int[] nums = new int[]{0};
        int k = 0;

        int result = solution.subarraySum(nums, k);

        Assertions.assertEquals(1, result);
    }

    @Test
    void example9() {
        int[] nums = new int[]{1, -1};
        int k = 0;

        int result = solution.subarraySum(nums, k);

        Assertions.assertEquals(1, result);
    }
}