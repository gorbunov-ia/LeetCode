package ru.gorbunov.tasks._0040combinationsum2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class SolutionTest {

    private Solution solution;

    @BeforeEach
    void setUp() {
        solution = new Solution();
    }

    @Test
    void example1() {
        int[] candidates = {10, 1, 2, 7, 6, 1, 5};
        int target = 8;

        List<List<Integer>> result = solution.combinationSum2(candidates, target);

        Assertions.assertEquals(4, result.size());
        result.forEach(Collections::sort);
        assertCombination(result, Arrays.asList(1, 1, 6));
        assertCombination(result, Arrays.asList(1, 2, 5));
        assertCombination(result, Arrays.asList(1, 7));
        assertCombination(result, Arrays.asList(2, 6));
    }

    @Test
    void example2() {
        int[] candidates = {2, 5, 2, 1, 2};
        int target = 5;

        List<List<Integer>> result = solution.combinationSum2(candidates, target);

        Assertions.assertEquals(2, result.size());
        result.forEach(Collections::sort);
        assertCombination(result, Arrays.asList(1, 2, 2));
        assertCombination(result, List.of(5));
    }

    private void assertCombination(List<List<Integer>> result, List<Integer> values) {
        for (List<Integer> combination : result) {
            if (combination.equals(values)) {
                return;
            }
        }
        Assertions.fail("No combination");
    }

}