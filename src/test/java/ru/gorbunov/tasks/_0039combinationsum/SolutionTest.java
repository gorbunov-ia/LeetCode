package ru.gorbunov.tasks._0039combinationsum;

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
        int[] arr = new int[]{2, 3, 6, 7};

        final List<List<Integer>> results = solution.combinationSum(arr, 7);
        sortResults(results);

        Assertions.assertEquals(2, results.size());
        assertList(results, Collections.singletonList(7));
        assertList(results, Arrays.asList(2, 2, 3));
    }

    @Test
    void example2() {
        int[] arr = new int[]{2, 3, 5};

        final List<List<Integer>> results = solution.combinationSum(arr, 8);
        sortResults(results);

        Assertions.assertEquals(3, results.size());
        assertList(results, Arrays.asList(2, 2, 2, 2));
        assertList(results, Arrays.asList(2, 3, 3));
        assertList(results, Arrays.asList(3, 5));
    }


    private void sortResults(List<List<Integer>> results) {
        for (List<Integer> result : results) {
            Collections.sort(result);
        }
    }

    private void assertList(List<List<Integer>> results, List<Integer> target) {
        for (List<Integer> result : results) {
            if (result.equals(target)) {
                return;
            }
        }
        Assertions.fail();
    }
}