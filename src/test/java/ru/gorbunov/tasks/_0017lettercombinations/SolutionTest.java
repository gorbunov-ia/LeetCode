package ru.gorbunov.tasks._0017lettercombinations;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static java.util.Arrays.asList;

class SolutionTest {

    private Solution solution;

    @BeforeEach
    void setUp() {
        solution = new Solution();
    }

    @Test
    void example1() {
        String digits = "23";

        Set<String> result = new HashSet<>(solution.letterCombinations(digits));

        Assertions.assertEquals(new HashSet<>(asList("ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf")), result);
    }

    @Test
    void example2() {
        String digits = "234";

        Set<String> result = new HashSet<>(solution.letterCombinations(digits));

        Set<String> expected = new HashSet<>(asList("aeg", "aei", "beh", "ceg", "aeh", "beg", "cei", "bei", "ceh",
                "afh", "bfg", "afg", "adh", "bdg", "bfi", "cfh", "adg", "afi", "bfh", "cfg", "bdi", "cdh", "adi", "bdh",
                "cdg", "cfi", "cdi"));
        Assertions.assertEquals(expected, result);
    }
}