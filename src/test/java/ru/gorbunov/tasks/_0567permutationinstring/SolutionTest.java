package ru.gorbunov.tasks._0567permutationinstring;

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
        String s1 = "ab";
        String s2 = "eidbaooo";

        final boolean result = solution.checkInclusion(s1, s2);

        Assertions.assertTrue(result);
    }


    @Test
    void example2() {
        String s1 = "ab";
        String s2 = "eidboaoo";

        final boolean result = solution.checkInclusion(s1, s2);

        Assertions.assertFalse(result);
    }

    @Test
    void example3() {
        String s1 = "cd";
        String s2 = "abcd";

        final boolean result = solution.checkInclusion(s1, s2);

        Assertions.assertTrue(result);
    }

}