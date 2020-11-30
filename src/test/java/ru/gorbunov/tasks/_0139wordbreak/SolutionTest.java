package ru.gorbunov.tasks._0139wordbreak;

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
        String s = "leetcode";
        List<String> wordDict = Arrays.asList("leet", "code");

        boolean result = solution.wordBreak(s, wordDict);

        Assertions.assertTrue(result);
    }

    @Test
    void example2() {
        String s = "applepenapple";
        List<String> wordDict = Arrays.asList("apple", "pen");

        boolean result = solution.wordBreak(s, wordDict);

        Assertions.assertTrue(result);
    }

    @Test
    void example3() {
        String s = "catsandog";
        List<String> wordDict = Arrays.asList("cats", "dog", "sand", "and", "cat");

        boolean result = solution.wordBreak(s, wordDict);

        Assertions.assertFalse(result);
    }


    @Test
    void example4() {
        String s = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" +
                "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab";
        List<String> wordDict = Arrays.asList("a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa");

        boolean result = solution.wordBreak(s, wordDict);

        Assertions.assertFalse(result);
    }

    @Test
    void example5() {
        String s = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabaabaaaaaaaaaaaaaaaaa" +
                "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
        List<String> wordDict = Arrays.asList("aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa","ba");

        boolean result = solution.wordBreak(s, wordDict);

        Assertions.assertFalse(result);
    }
}