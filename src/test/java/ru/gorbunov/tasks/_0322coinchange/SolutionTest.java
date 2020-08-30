package ru.gorbunov.tasks._0322coinchange;

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
        int[] coins = new int[]{1, 2, 5};
        int amount = 11;

        final int result = solution.coinChange(coins, amount);

        Assertions.assertEquals(3, result);
    }


    @Test
    void example2() {
        int[] coins = new int[]{2};
        int amount = 3;

        final int result = solution.coinChange(coins, amount);

        Assertions.assertEquals(-1, result);
    }

}