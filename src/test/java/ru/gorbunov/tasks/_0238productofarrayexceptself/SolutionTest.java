package ru.gorbunov.tasks._0238productofarrayexceptself;

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
        int[] nums = new int[]{1, 2, 3, 4};

        int[] result = solution.productExceptSelf(nums);

        Assertions.assertArrayEquals(new int[]{24, 12, 8, 6}, result);
    }

    @Test
    void example2() {
        int[] nums = new int[]{-1, 1, 0, -3, 3};

        int[] result = solution.productExceptSelf(nums);

        Assertions.assertArrayEquals(new int[]{0, 0, 9, 0, 0}, result);
    }

    @Test
    void example3() {
        int[] nums = new int[]{-2, 3, 4};

        int[] result = solution.productExceptSelf(nums);

        Assertions.assertArrayEquals(new int[]{12, -8, -6}, result);
    }

    @Test
    void example4() {
        int[] nums = new int[]{2, -3, 4};

        int[] result = solution.productExceptSelf(nums);

        Assertions.assertArrayEquals(new int[]{-12, 8, -6}, result);
    }

    @Test
    void example5() {
        int[] nums = new int[]{1, -1, 1};

        int[] result = solution.productExceptSelf(nums);

        Assertions.assertArrayEquals(new int[]{-1, 1, -1}, result);
    }

}