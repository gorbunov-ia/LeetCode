package ru.gorbunov.tasks._0031nextpermutation;

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
        int[] nums = new int[]{1, 2, 3};

        solution.nextPermutation(nums);

        Assertions.assertEquals(1, nums[0]);
        Assertions.assertEquals(3, nums[1]);
        Assertions.assertEquals(2, nums[2]);
    }

    @Test
    void example2() {
        int[] nums = new int[]{3, 2, 1};

        solution.nextPermutation(nums);

        Assertions.assertEquals(1, nums[0]);
        Assertions.assertEquals(2, nums[1]);
        Assertions.assertEquals(3, nums[2]);
    }

    @Test
    void example3() {
        int[] nums = new int[]{1, 1, 5};

        solution.nextPermutation(nums);

        Assertions.assertEquals(1, nums[0]);
        Assertions.assertEquals(5, nums[1]);
        Assertions.assertEquals(1, nums[2]);
    }

    @Test
    void example4() {
        int[] nums = new int[]{1, 3, 2};

        solution.nextPermutation(nums);

        Assertions.assertEquals(2, nums[0]);
        Assertions.assertEquals(1, nums[1]);
        Assertions.assertEquals(3, nums[2]);
    }

    @Test
    void example5() {
        int[] nums = new int[]{4,2,0,2,3,2,0};

        solution.nextPermutation(nums);

        Assertions.assertEquals(4, nums[0]);
        Assertions.assertEquals(2, nums[1]);
        Assertions.assertEquals(0, nums[2]);
        Assertions.assertEquals(3, nums[3]);
        Assertions.assertEquals(0, nums[4]);
        Assertions.assertEquals(2, nums[5]);
        Assertions.assertEquals(2, nums[6]);
    }
}
