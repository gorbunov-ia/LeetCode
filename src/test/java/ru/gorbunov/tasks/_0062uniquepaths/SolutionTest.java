package ru.gorbunov.tasks._0062uniquepaths;

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
        int m = 3;
        int n = 7;

        final int result = solution.uniquePaths(m, n);

        Assertions.assertEquals(28, result);
    }

    @Test
    void example2() {
        int m = 3;
        int n = 2;

        final int result = solution.uniquePaths(m, n);

        Assertions.assertEquals(3, result);
    }

    @Test
    void example3() {
        int m = 7;
        int n = 3;

        final int result = solution.uniquePaths(m, n);

        Assertions.assertEquals(28, result);
    }

    @Test
    void example4() {
        int m = 3;
        int n = 3;

        final int result = solution.uniquePaths(m, n);

        Assertions.assertEquals(6, result);
    }
}