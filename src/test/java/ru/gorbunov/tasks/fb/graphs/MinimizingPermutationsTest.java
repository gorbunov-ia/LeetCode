package ru.gorbunov.tasks.fb.graphs;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MinimizingPermutationsTest {

    private MinimizingPermutations component;

    @BeforeEach
    void setUp() {
        component = new MinimizingPermutations();
    }

    @Test
    void example1() {
        int[] arr = new int[]{3, 1, 2};

        final int minOperationNumber = component.minOperations(arr);

        Assertions.assertEquals(2, minOperationNumber);
    }

    @Test
    void example2() {
        int[] arr = new int[]{4, 3, 1, 2};

        final int minOperationNumber = component.minOperations(arr);

        Assertions.assertEquals(2, minOperationNumber);
    }
}