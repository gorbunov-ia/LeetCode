package ru.gorbunov.tasks._0022generateparentheses;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    private Solution solution;

    @BeforeEach
    void setUp() {
        solution = new Solution();
    }

    @Test
    void example1() {
        int size = 3;

        final List<String> result = solution.generateParenthesis(size);

        final List<String> expectedResult = Arrays.asList(
                "((()))",
                "(()())",
                "(())()",
                "()(())",
                "()()()");
        Assertions.assertEquals(new HashSet<>(expectedResult), new HashSet<>(result));
    }
}