package ru.gorbunov.tasks._0153findminimuminrotatedsortedarray;

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
        int[] nums = new int[]{3, 4, 5, 1, 2};

        int result = solution.findMin(nums);

        Assertions.assertEquals(1, result);
    }

    @Test
    void example2() {
        int[] nums = new int[]{4, 5, 6, 7, 0, 1, 2};

        int result = solution.findMin(nums);

        Assertions.assertEquals(0, result);
    }

    @Test
    void example3() {
        int[] nums = new int[]{11, 13, 15, 17};

        int result = solution.findMin(nums);

        Assertions.assertEquals(11, result);
    }

    @Test
    void example4() {
        int[] nums = new int[]{2, 3, 4, 5, 1};

        int result = solution.findMin(nums);

        Assertions.assertEquals(1, result);
    }
}