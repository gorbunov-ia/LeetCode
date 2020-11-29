package ru.gorbunov.tasks._0121besttimetobuyandsellstock;

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
        int[] input = new int[]{7, 1, 5, 3, 6, 4};

        int result = solution.maxProfit(input);

        Assertions.assertEquals(5, result);
    }


    @Test
    void example2() {
        int[] input = new int[]{7, 6, 4, 3, 1};

        int result = solution.maxProfit(input);

        Assertions.assertEquals(0, result);
    }
}