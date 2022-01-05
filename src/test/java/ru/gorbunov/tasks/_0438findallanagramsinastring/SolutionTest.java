package ru.gorbunov.tasks._0438findallanagramsinastring;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

class SolutionTest {

    private Solution solution;

    @BeforeEach
    void setUp() {
        solution = new Solution();
    }

    @Test
    void example1() {
        String s = "cbaebabacd";
        String p = "abc";

        List<Integer> result = solution.findAnagrams(s, p);

        Assertions.assertEquals(new HashSet<>(Arrays.asList(0, 6)), new HashSet<>(result));
    }

    @Test
    void example2() {
        String s = "abab";
        String p = "ab";

        List<Integer> result = solution.findAnagrams(s, p);

        Assertions.assertEquals(new HashSet<>(Arrays.asList(0, 1, 2)), new HashSet<>(result));
    }

}