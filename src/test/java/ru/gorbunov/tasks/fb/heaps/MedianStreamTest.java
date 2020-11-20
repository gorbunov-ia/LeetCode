package ru.gorbunov.tasks.fb.heaps;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MedianStreamTest {

    private MedianStream component;

    @BeforeEach
    void setUp() {
        component = new MedianStream();
    }

    @Test
    void example1() {
        int[] arr = new int[]{5, 15, 1, 3};

        int[] result = component.findMedian(arr);

        Assertions.assertArrayEquals(new int[]{5, 10, 5, 4}, result);
    }

    @Test
    void example2() {
        int[] arr = new int[]{1, 2};

        int[] result = component.findMedian(arr);

        Assertions.assertArrayEquals(new int[]{1, 1}, result);
    }
}