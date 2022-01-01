package ru.gorbunov.tasks._0169majorityelement;

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
        int[] nums = new int[]{3, 2, 3};

        int result = solution.majorityElement(nums);

        Assertions.assertEquals(3, result);
    }

    @Test
    void example2() {
        int[] nums = new int[]{2, 2, 1, 1, 1, 2, 2};

        int result = solution.majorityElement(nums);

        Assertions.assertEquals(2, result);
    }
}