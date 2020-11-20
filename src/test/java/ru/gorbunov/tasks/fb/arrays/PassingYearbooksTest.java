package ru.gorbunov.tasks.fb.arrays;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PassingYearbooksTest {

    private PassingYearbooks component;

    @BeforeEach
    void setUp() {
        component = new PassingYearbooks();
    }

    @Test
    void example1() {
        int[] arr = {2, 1};

        int[] result = component.findSignatureCounts(arr);

        Assertions.assertArrayEquals(new int[]{2, 2}, result);
    }

    @Test
    void example2() {
        int[] arr = {1, 2};

        int[] result = component.findSignatureCounts(arr);

        Assertions.assertArrayEquals(new int[]{1, 1}, result);
    }
}