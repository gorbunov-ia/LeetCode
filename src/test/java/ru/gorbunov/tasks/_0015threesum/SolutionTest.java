package ru.gorbunov.tasks._0015threesum;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

class SolutionTest {

    private Solution solution;

    @BeforeEach
    void setUp() {
        solution = new Solution();
    }

    @Test
    void example1() {
        int[] nums = new int[]{-1, 0, 1, 2, -1, -4};

        final List<List<Integer>> result = solution.threeSum(nums);

        Assertions.assertEquals(2, result.size());
        assertSums(result);
    }

    @Test
    void example2() {
        int[] nums = new int[]{0,0,0,0};

        final List<List<Integer>> result = solution.threeSum(nums);

        Assertions.assertEquals(1, result.size());
        assertSums(result);
    }

    private void assertSums(List<List<Integer>> nums) {
        for (List<Integer> num : nums) {
            Assertions.assertEquals(3, num.size());
            Assertions.assertEquals(0, num.get(0) + num.get(1) + num.get(2));
        }

    }
}