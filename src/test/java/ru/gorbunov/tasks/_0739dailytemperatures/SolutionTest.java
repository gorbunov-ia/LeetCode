package ru.gorbunov.tasks._0739dailytemperatures;

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
        int[] temperatures = new int[]{73, 74, 75, 71, 69, 72, 76, 73};

        int[] result = solution.dailyTemperatures(temperatures);

        Assertions.assertEquals(temperatures.length, result.length);
        Assertions.assertEquals(1, result[0]);
        Assertions.assertEquals(1, result[1]);
        Assertions.assertEquals(4, result[2]);
        Assertions.assertEquals(2, result[3]);
        Assertions.assertEquals(1, result[4]);
        Assertions.assertEquals(1, result[5]);
        Assertions.assertEquals(0, result[6]);
        Assertions.assertEquals(0, result[7]);
    }

    @Test
    void example2() {
        int[] temperatures = new int[]{30, 40, 50, 60};

        int[] result = solution.dailyTemperatures(temperatures);

        Assertions.assertEquals(temperatures.length, result.length);
        Assertions.assertEquals(1, result[0]);
        Assertions.assertEquals(1, result[1]);
        Assertions.assertEquals(1, result[2]);
        Assertions.assertEquals(0, result[3]);
    }

    @Test
    void example3() {
        int[] temperatures = new int[]{30, 60, 90};

        int[] result = solution.dailyTemperatures(temperatures);

        Assertions.assertEquals(temperatures.length, result.length);
        Assertions.assertEquals(1, result[0]);
        Assertions.assertEquals(1, result[1]);
        Assertions.assertEquals(0, result[2]);
    }

}