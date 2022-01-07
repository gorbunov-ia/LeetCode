package ru.gorbunov.tasks._0347topkfrequentelements;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.stream.Collectors;

class SolutionTest {

    private Solution solution;

    @BeforeEach
    void setUp() {
        solution = new Solution();
    }

    @Test
    void example1() {
        int[] nums = new int[]{1, 1, 1, 2, 2, 3};
        int k = 2;

        int[] result = solution.topKFrequent(nums, k);

        Assertions.assertEquals(new HashSet<>(Arrays.asList(1, 2)),
                Arrays.stream(result).boxed().collect(Collectors.toSet()));
    }

    @Test
    void example2() {
        int[] nums = new int[]{1};
        int k = 1;

        int[] result = solution.topKFrequent(nums, k);

        Assertions.assertArrayEquals(new int[]{1}, result);
    }
}