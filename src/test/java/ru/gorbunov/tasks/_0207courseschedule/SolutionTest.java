package ru.gorbunov.tasks._0207courseschedule;

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
        int numCourses = 2;
        int[][] prerequisites = new int[][]{{1, 0}};

        boolean result = solution.canFinish(numCourses, prerequisites);

        Assertions.assertTrue(result);
    }

    @Test
    void example2() {
        int numCourses = 2;
        int[][] prerequisites = new int[][]{{1, 0}, {0, 1}};

        boolean result = solution.canFinish(numCourses, prerequisites);

        Assertions.assertFalse(result);
    }

    @Test
    void example3() {
        int numCourses = 4;
        int[][] prerequisites = new int[][]{{1, 2}, {2, 3}, {3, 4}, {4, 2}};

        boolean result = solution.canFinish(numCourses, prerequisites);

        Assertions.assertFalse(result);
    }

    @Test
    void example4() {
        int numCourses = 4;
        int[][] prerequisites = new int[][]{{1, 0}, {0, 3}, {0, 2}, {3, 2}, {2, 5}, {4, 5}, {5, 6}, {2, 4}};

        boolean result = solution.canFinish(numCourses, prerequisites);

        Assertions.assertTrue(result);
    }

}