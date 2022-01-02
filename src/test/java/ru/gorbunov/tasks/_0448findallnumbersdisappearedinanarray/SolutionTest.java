package ru.gorbunov.tasks._0448findallnumbersdisappearedinanarray;

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
        int[] nums = new int[]{4, 3, 2, 7, 8, 2, 3, 1};

        List<Integer> result = solution.findDisappearedNumbers(nums);

        Assertions.assertEquals(Arrays.asList(5, 6), result);
    }


    @Test
    void example2() {
        int[] nums = new int[]{1, 1};

        List<Integer> result = solution.findDisappearedNumbers(nums);

        Assertions.assertEquals(Collections.singletonList(2), result);
    }
}