package ru.gorbunov.tasks.fb.arrays;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ContiguousSubarraysTest {

    private ContiguousSubarrays component;

    @BeforeEach
    void setUp() {
        component = new ContiguousSubarrays();
    }

    @Test
    void example1() {
        int[] arr = new int[]{3, 4, 1, 6, 2};

        int[] result = component.countSubarrays(arr);

        Assertions.assertArrayEquals(new int[]{1, 3, 1, 5, 1}, result);
    }
}