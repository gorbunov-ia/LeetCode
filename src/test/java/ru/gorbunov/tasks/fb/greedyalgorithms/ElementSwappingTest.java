package ru.gorbunov.tasks.fb.greedyalgorithms;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ElementSwappingTest {

    private ElementSwapping component;

    @BeforeEach
    void setUp() {
        component = new ElementSwapping();
    }

    @Test
    void example1() {
        int[] arr = new int[]{5, 3, 1};
        int k = 2;

        int[] result = component.findMinArray(arr, k);

        Assertions.assertArrayEquals(new int[]{1, 5, 3}, result);
    }

    @Test
    void example2() {
        int[] arr = new int[]{8, 9, 11, 2, 1};
        int k = 3;

        int[] result = component.findMinArray(arr, k);

        Assertions.assertArrayEquals(new int[]{2, 8, 9, 11, 1}, result);
    }
}