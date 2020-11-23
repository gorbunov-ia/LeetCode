package ru.gorbunov.tasks._0743networkdelaytime;

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
        int[][] times = new int[][]{{2, 1, 1}, {2, 3, 1}, {3, 4, 1}};
        int n = 4;
        int k = 2;

        int result = solution.networkDelayTime(times, n, k);

        Assertions.assertEquals(2, result);
    }

    @Test
    void example2() {
        int[][] times = new int[][]{{1, 2, 1}};
        int n = 2;
        int k = 2;

        int result = solution.networkDelayTime(times, n, k);

        Assertions.assertEquals(-1, result);
    }
}