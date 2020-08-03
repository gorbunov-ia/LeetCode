package ru.gorbunov.tasks._0020validparentheses;

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
        String input = "()";

        final boolean result = solution.isValid(input);

        Assertions.assertTrue(result);
    }

    @Test
    void example2() {
        String input = "()[]{}";

        final boolean result = solution.isValid(input);

        Assertions.assertTrue(result);
    }

    @Test
    void example3() {
        String input = "(]";

        final boolean result = solution.isValid(input);

        Assertions.assertFalse(result);
    }

    @Test
    void example4() {
        String input = "([)]";

        final boolean result = solution.isValid(input);

        Assertions.assertFalse(result);
    }

    @Test
    void example5() {
        String input = "{[]}";

        final boolean result = solution.isValid(input);

        Assertions.assertTrue(result);
    }

}