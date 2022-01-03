package ru.gorbunov.tasks._0128longestconsecutivesequence;

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
        int[] nums = new int[]{100, 4, 200, 1, 3, 2};

        int result = solution.longestConsecutive(nums);

        Assertions.assertEquals(4, result);
    }


    @Test
    void example2() {
        int[] nums = new int[]{0, 3, 7, 2, 5, 8, 4, 6, 0, 1};

        int result = solution.longestConsecutive(nums);

        Assertions.assertEquals(9, result);
    }

    @Test
    void example3() {
        int[] nums = new int[]{1, 2, 4, 3, 5};

        int result = solution.longestConsecutive(nums);

        Assertions.assertEquals(5, result);
    }
}