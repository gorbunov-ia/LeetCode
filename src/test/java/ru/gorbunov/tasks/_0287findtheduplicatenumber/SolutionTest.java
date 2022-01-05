package ru.gorbunov.tasks._0287findtheduplicatenumber;

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
        int[] nums = new int[]{1, 3, 4, 2, 2};

        int result = solution.findDuplicate(nums);

        Assertions.assertEquals(2, result);
    }

    @Test
    void example2() {
        int[] nums = new int[]{3, 1, 3, 4, 2};

        int result = solution.findDuplicate(nums);

        Assertions.assertEquals(3, result);
    }
}