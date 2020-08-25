package ru.gorbunov.tasks._0076minimumwindowsubstring;

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
        String s = "ADOBECODEBANC";
        String t = "ABC";

        final String result = solution.minWindow(s, t);

        Assertions.assertEquals("BANC", result);
    }


    @Test
    void example2() {
        String s = "ABCD";
        String t = "BCB";

        final String result = solution.minWindow(s, t);

        Assertions.assertEquals("", result);
    }

    @Test
    void example3() {
        String s = "cabwefgewcwaefgcf";
        String t = "cae";

        final String result = solution.minWindow(s, t);

        Assertions.assertEquals("cwae", result);
    }
}