package ru.gorbunov.tasks._1460maketwoarraysequal;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SolutionTest {

    private Solution solution;

    @BeforeEach
    void setUp() {
        solution = new Solution();
    }

    /**
     * Input: target = [1,2,3,4], arr = [2,4,1,3]
     * Output: true
     * Explanation: You can follow the next steps to convert arr to target:
     * 1- Reverse sub-array [2,4,1], arr becomes [1,4,2,3]
     * 2- Reverse sub-array [4,2], arr becomes [1,2,4,3]
     * 3- Reverse sub-array [4,3], arr becomes [1,2,3,4]
     * There are multiple ways to convert arr to target, this is not the only way to do so.
     */
    @Test
    void example1() {
        int[] target = {1, 2, 3, 4};
        int[] arr = {2, 4, 1, 3};

        final boolean result = solution.canBeEqual(target, arr);

        Assertions.assertTrue(result);
    }

    @Test
    void example2() {
        int[] target = {7};
        int[] arr = {7};

        final boolean result = solution.canBeEqual(target, arr);

        Assertions.assertTrue(result);
    }

    @Test
    void example3() {
        int[] target = {1, 12};
        int[] arr = {12, 1};

        final boolean result = solution.canBeEqual(target, arr);

        Assertions.assertTrue(result);
    }

    @Test
    void example4() {
        int[] target = {3, 7, 9};
        int[] arr = {3, 7, 11};

        final boolean result = solution.canBeEqual(target, arr);

        Assertions.assertFalse(result);
    }

    @Test
    void example5() {
        int[] target = {1,1,1,1,1};
        int[] arr = {1,1,1,1,1};

        final boolean result = solution.canBeEqual(target, arr);

        Assertions.assertTrue(result);
    }

}