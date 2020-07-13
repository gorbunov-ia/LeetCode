package ru.gorbunov.tasks._0005longestpalindromic;

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
        String str = "babad";

        String result = solution.longestPalindrome(str);

        Assertions.assertEquals("bab", result);
    }

    @Test
    void example2() {
        String str = "cbbd";

        String result = solution.longestPalindrome(str);

        Assertions.assertEquals("bb", result);
    }

    @Test
    void example3() {
        String str = "cbbbabb";

        String result = solution.longestPalindrome(str);

        Assertions.assertEquals("bbabb", result);
    }
}