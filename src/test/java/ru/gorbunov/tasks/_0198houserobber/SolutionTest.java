package ru.gorbunov.tasks._0198houserobber;

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
        int[] nums = new int[]{1, 2, 3, 1};

        int result = solution.rob(nums);

        Assertions.assertEquals(4, result);
    }

    @Test
    void example2() {
        int[] nums = new int[]{2, 7, 9, 3, 1};

        int result = solution.rob(nums);

        Assertions.assertEquals(12, result);
    }

    @Test
    void example3() {
        int[] nums = new int[]{5, 1, 1, 5};

        int result = solution.rob(nums);

        Assertions.assertEquals(10, result);
    }
}