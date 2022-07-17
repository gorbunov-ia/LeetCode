package ru.gorbunov.tasks._0073setmatrixzeroes;

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
        int[][] matrix = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};

        solution.setZeroes(matrix);

        Assertions.assertArrayEquals(new int[][]{{1, 0, 1}, {0, 0, 0}, {1, 0, 1}}, matrix);
    }

    @Test
    void example2() {
        int[][] matrix = {{0, 1, 2, 0}, {3, 4, 5, 2}, {1, 3, 1, 5}};

        solution.setZeroes(matrix);

        Assertions.assertArrayEquals(new int[][]{{0, 0, 0, 0}, {0, 4, 5, 0}, {0, 3, 1, 0}}, matrix);
    }

}