package ru.gorbunov.tasks._0070climbingstairs;

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
        int stairs = 2;

        final int result = solution.climbStairs(stairs);

        Assertions.assertEquals(2, result);
    }

    @Test
    void example2() {
        int stairs = 3;

        final int result = solution.climbStairs(stairs);

        Assertions.assertEquals(3, result);
    }

    @Test
    void example3() {
        int stairs = 4;

        final int result = solution.climbStairs(stairs);

        Assertions.assertEquals(5, result);
    }
}