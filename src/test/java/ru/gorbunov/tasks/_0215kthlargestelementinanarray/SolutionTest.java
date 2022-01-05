package ru.gorbunov.tasks._0215kthlargestelementinanarray;

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
        int[] nums = new int[]{3, 2, 1, 5, 6, 4};
        int k = 2;

        int result = solution.findKthLargest(nums, k);

        Assertions.assertEquals(5, result);
    }

    @Test
    void example2() {
        int[] nums = new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6};
        int k = 4;

        int result = solution.findKthLargest(nums, k);

        Assertions.assertEquals(4, result);
    }
}