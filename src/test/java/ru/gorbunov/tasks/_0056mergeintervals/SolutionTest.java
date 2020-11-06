package ru.gorbunov.tasks._0056mergeintervals;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    private Solution solution;

    @BeforeEach
    void setUp() {
        solution = new Solution();
    }

    @Test
    void example1() {
        int[][] intervals = {{1,3},{2,6},{8,10},{15,18}};

        final int[][] result = solution.merge(intervals);

        Assertions.assertArrayEquals(new int[][]{{1,6},{8,10},{15,18}}, result);
    }

    @Test
    void example2() {
        int[][] intervals = {{1,4},{4,5}};

        final int[][] result = solution.merge(intervals);

        Assertions.assertArrayEquals(new int[][]{{1,5}}, result);
    }

    @Test
    void example3() {
        int[][] intervals = {{1,4},{2,3}};

        final int[][] result = solution.merge(intervals);

        Assertions.assertArrayEquals(new int[][]{{1,4}}, result);
    }
}