package ru.gorbunov.tasks._0001twosum;

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
        int[] nums = {2, 7, 11, 15};
        int target = 9;

        int[] result = solution.twoSum(nums, target);

        Assertions.assertArrayEquals(new int[]{0, 1}, result);
    }
}