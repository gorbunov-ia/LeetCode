package ru.gorbunov.tasks._0152maximumproductsubarray;

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
        int[] nums = {2, 3, -2, 4};

        int result = solution.maxProduct(nums);

        Assertions.assertEquals(6, result);
    }

    @Test
    void example2() {
        int[] nums = {-2, 0, -1};

        int result = solution.maxProduct(nums);

        Assertions.assertEquals(0, result);
    }

    @Test
    void example3() {
        int[] nums = {0, 2};

        int result = solution.maxProduct(nums);

        Assertions.assertEquals(2, result);
    }

    @Test
    void example4() {
        int[] nums = {-3, -1, -1};

        int result = solution.maxProduct(nums);

        Assertions.assertEquals(3, result);
    }

    @Test
    void example5() {
        int[] nums = {-1, 5, 10};

        int result = solution.maxProduct(nums);

        Assertions.assertEquals(50, result);
    }

    @Test
    void example6() {
        int[] nums = {-1, 5, -10};

        int result = solution.maxProduct(nums);

        Assertions.assertEquals(50, result);
    }

}