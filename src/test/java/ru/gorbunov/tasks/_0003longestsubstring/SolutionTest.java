package ru.gorbunov.tasks._0003longestsubstring;

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
        String str = "abcabcbb";

        int result = solution.lengthOfLongestSubstring(str);

        Assertions.assertEquals(3, result);
    }

    @Test
    void example2() {
        String str = "bbbbb";

        int result = solution.lengthOfLongestSubstring(str);

        Assertions.assertEquals(1, result);
    }


    @Test
    void example3() {
        String str = "pwwkew";

        int result = solution.lengthOfLongestSubstring(str);

        Assertions.assertEquals(3, result);
    }
}