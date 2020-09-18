package ru.gorbunov.tasks._0067addbinary;

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
        String a = "11";
        String b = "1";

        final String sum = solution.addBinary(a, b);

        Assertions.assertEquals("100", sum);
    }

    @Test
    void example2() {
        String a = "1010";
        String b = "1011";

        final String sum = solution.addBinary(a, b);

        Assertions.assertEquals("10101", sum);
    }
}