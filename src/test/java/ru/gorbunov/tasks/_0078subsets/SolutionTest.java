package ru.gorbunov.tasks._0078subsets;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class SolutionTest {

    private Solution solution;

    @BeforeEach
    void setUp() {
        solution = new Solution();
    }

    @Test
    void example1() {
        int[] nums = {1, 2, 3};

        final List<List<Integer>> result = solution.subsets(nums);

        Assertions.assertEquals(8, result.size());
        Set<List<Integer>> set = new HashSet<>(result);
        assertHas(set, Collections.emptyList());
        assertHas(set, Collections.singletonList(1));
        assertHas(set, Collections.singletonList(2));
        assertHas(set, Collections.singletonList(3));
        assertHas(set, Arrays.asList(1, 2));
        assertHas(set, Arrays.asList(1, 3));
        assertHas(set, Arrays.asList(2, 3));
        assertHas(set, Arrays.asList(1, 2, 3));
    }

    private void assertHas(Set<List<Integer>> set, List<Integer> list) {
        Assertions.assertTrue(set.contains(list));
    }
}