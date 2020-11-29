package ru.gorbunov.tasks._0136singlenumber;

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
        int[] nums = new int[]{2,2,1};

        int result = solution.singleNumber(nums);

        Assertions.assertEquals(1, result);
    }

    @Test
    void example2() {
        int[] nums = new int[]{4,1,2,1,2};

        int result = solution.singleNumber(nums);

        Assertions.assertEquals(4, result);
    }

    @Test
    void example3() {
        int[] nums = new int[]{1};

        int result = solution.singleNumber(nums);

        Assertions.assertEquals(1, result);
    }

}