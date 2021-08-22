package ru.gorbunov.tasks._0394decodestring;

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
        String s = "3[a]2[bc]";

        String result = solution.decodeString(s);

        Assertions.assertEquals("aaabcbc", result);
    }

    @Test
    void example2() {
        String s = "3[a2[c]]";

        String result = solution.decodeString(s);

        Assertions.assertEquals("accaccacc", result);
    }

    @Test
    void example3() {
        String s = "2[abc]3[cd]ef";

        String result = solution.decodeString(s);

        Assertions.assertEquals("abcabccdcdcdef", result);
    }

    @Test
    void example4() {
        String s = "abc3[cd]xyz";

        String result = solution.decodeString(s);

        Assertions.assertEquals("abccdcdcdxyz", result);
    }
}