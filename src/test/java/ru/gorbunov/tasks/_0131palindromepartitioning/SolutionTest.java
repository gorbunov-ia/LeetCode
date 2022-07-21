package ru.gorbunov.tasks._0131palindromepartitioning;

import org.assertj.core.api.Assertions;
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
        String s = "aab";

        List<List<String>> result = solution.partition(s);

        Assertions.assertThat(result).containsOnly(Arrays.asList("a", "a", "b"), Arrays.asList("aa", "b"));
    }

    @Test
    void example2() {
        String s = "a";

        List<List<String>> result = solution.partition(s);

        Assertions.assertThat(result).containsOnly(List.of("a"));
    }
}