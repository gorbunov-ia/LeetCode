package ru.gorbunov.tasks._0046permutations;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

class SolutionTest {

    private Solution solution;

    @BeforeEach
    void setUp() {
        solution = new Solution();
    }

    @Test
    void example1() {
        int[] nums = new int[]{1, 2, 3};

        final List<List<Integer>> result = solution.permute(nums);

        Assertions.assertEquals(6, result.size());
        assertCombination(result, Arrays.asList(1, 2, 3));
        assertCombination(result, Arrays.asList(1, 3, 2));
        assertCombination(result, Arrays.asList(2, 1, 3));
        assertCombination(result, Arrays.asList(2, 3, 1));
        assertCombination(result, Arrays.asList(3, 1, 2));
        assertCombination(result, Arrays.asList(3, 2, 1));
    }

    private void assertCombination(List<List<Integer>> combinations, List<Integer> values) {
        for (List<Integer> combination : combinations) {
            if (combination.equals(values)) {
                return;
            }
        }
        Assertions.fail();
    }
}