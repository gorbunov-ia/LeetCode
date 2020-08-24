package ru.gorbunov.tasks._0295findmedianfromdatastream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MedianFinderTest {

    private MedianFinder medianFinder;

    @BeforeEach
    void setUp() {
        medianFinder = new MedianFinder();
    }

    @Test
    void example1() {
        medianFinder.addNum(1);
        medianFinder.addNum(2);

        final double result = medianFinder.findMedian();

        Assertions.assertEquals(1.5, result);
    }

    @Test
    void example2() {
        medianFinder.addNum(1);
        medianFinder.addNum(2);
        medianFinder.addNum(3);

        final double result = medianFinder.findMedian();

        Assertions.assertEquals(2, result);
    }
}