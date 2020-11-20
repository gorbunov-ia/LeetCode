package ru.gorbunov.tasks.fb.greedyalgorithms;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SlowSumsTest {

    private SlowSums component;

    @BeforeEach
    void setUp() {
        component = new SlowSums();
    }

    @Test
    void example1() {
        int[] input = new int[]{4, 2, 1, 3};

        int result = component.getTotalTime(input);

        Assertions.assertEquals(26, result);
    }

    @Test
    void example2() {
        int[] input = new int[]{2, 3, 9, 8, 4};

        int result = component.getTotalTime(input);

        Assertions.assertEquals(88, result);
    }

    @Test
    void example3() {
        int[] input = new int[]{2, 100, 100, 1, 99};

        int result = component.getTotalTime(input);

        Assertions.assertEquals(1102, result);
    }


    @Test
    void example4() {
        int[] input = new int[]{7, 8, 1, 6, 7, 7};

        int result = component.getTotalTime(input);

        Assertions.assertEquals(137, result);
    }


    @Test
    void example5() {
        int[] input = new int[]{7, 8, 1, 7, 8, 7};

        int result = component.getTotalTime(input);

        Assertions.assertEquals(144, result);
    }
}