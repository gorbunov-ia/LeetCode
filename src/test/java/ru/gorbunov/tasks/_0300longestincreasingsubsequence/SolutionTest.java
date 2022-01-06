package ru.gorbunov.tasks._0300longestincreasingsubsequence;

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
        int[] nums = new int[]{10, 9, 2, 5, 3, 7, 101, 18};

        int result = solution.lengthOfLIS(nums);

        Assertions.assertEquals(4, result);
    }

    @Test
    void example2() {
        int[] nums = new int[]{0, 1, 0, 3, 2, 3};

        int result = solution.lengthOfLIS(nums);

        Assertions.assertEquals(4, result);
    }

    @Test
    void example3() {
        int[] nums = new int[]{7, 7, 7, 7, 7, 7, 7};

        int result = solution.lengthOfLIS(nums);

        Assertions.assertEquals(1, result);
    }

    @Test
    void example4() {
        int[] nums = new int[]{1, 2, 3};

        int result = solution.lengthOfLIS(nums);

        Assertions.assertEquals(3, result);
    }
}