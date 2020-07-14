package ru.gorbunov.tasks._0011containerwithmostwater;

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
        int[] arr = new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7};

        int maxArea = solution.maxArea(arr);

        Assertions.assertEquals(49, maxArea);
    }
}