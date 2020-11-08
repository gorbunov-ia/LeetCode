package ru.gorbunov.tasks._0064minimumpathsum;

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
        int[][] grid = {{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};

        final int result = solution.minPathSum(grid);

        Assertions.assertEquals(7, result);
    }

    @Test
    void example2() {
        int[][] grid = {{1, 2, 3}, {4, 5, 6}};

        final int result = solution.minPathSum(grid);

        Assertions.assertEquals(12, result);
    }
}