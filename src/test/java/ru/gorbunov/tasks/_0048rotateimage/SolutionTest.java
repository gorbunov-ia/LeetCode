package ru.gorbunov.tasks._0048rotateimage;

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
        int[][] matrix = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};

        solution.rotate(matrix);

        Assertions.assertEquals(3, matrix.length);
        Assertions.assertArrayEquals(new int[]{7, 4, 1}, matrix[0]);
        Assertions.assertArrayEquals(new int[]{8, 5, 2}, matrix[1]);
        Assertions.assertArrayEquals(new int[]{9, 6, 3}, matrix[2]);
    }

    @Test
    void example2() {
        int[][] matrix = new int[][]{{5, 1, 9, 11}, {2, 4, 8, 10}, {13, 3, 6, 7}, {15, 14, 12, 16}};

        solution.rotate(matrix);

        Assertions.assertEquals(4, matrix.length);
        Assertions.assertArrayEquals(new int[]{15, 13, 2, 5}, matrix[0]);
        Assertions.assertArrayEquals(new int[]{14, 3, 4, 1}, matrix[1]);
        Assertions.assertArrayEquals(new int[]{12, 6, 8, 9}, matrix[2]);
        Assertions.assertArrayEquals(new int[]{16, 7, 10, 11}, matrix[3]);
    }

    @Test
    void example3() {
        int[][] matrix = new int[][]{{1}};

        solution.rotate(matrix);

        Assertions.assertEquals(1, matrix.length);
        Assertions.assertArrayEquals(new int[]{1}, matrix[0]);
    }

    @Test
    void example4() {
        int[][] matrix = new int[][]{{1, 2}, {3, 4}};

        solution.rotate(matrix);

        Assertions.assertEquals(2, matrix.length);
        Assertions.assertArrayEquals(new int[]{3, 1}, matrix[0]);
        Assertions.assertArrayEquals(new int[]{4, 2}, matrix[1]);
    }

}