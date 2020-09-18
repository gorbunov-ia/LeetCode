package ru.gorbunov.tasks._0065validnumber;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    private Solution solution;

    @BeforeEach
    void setUp() {
        solution = new Solution();
    }

    @Test
    void example1() {
        String s = "0";

        final boolean result = solution.isNumber(s);

        Assertions.assertTrue(result);
    }


    @Test
    void example2() {
        String s = " 0.1";

        final boolean result = solution.isNumber(s);

        Assertions.assertTrue(result);
    }

    @Test
    void example3() {
        String s = "abc";

        final boolean result = solution.isNumber(s);

        Assertions.assertFalse(result);
    }

    @Test
    void example4() {
        String s = "1 a";

        final boolean result = solution.isNumber(s);

        Assertions.assertFalse(result);
    }

    @Test
    void example5() {
        String s = "2e10";

        final boolean result = solution.isNumber(s);

        Assertions.assertTrue(result);
    }

    @Test
    void example6() {
        String s = " -90e3   ";

        final boolean result = solution.isNumber(s);

        Assertions.assertTrue(result);
    }

    @Test
    void example7() {
        String s = " 1e";

        final boolean result = solution.isNumber(s);

        Assertions.assertFalse(result);
    }

    @Test
    void example8() {
        String s = "e3";

        final boolean result = solution.isNumber(s);

        Assertions.assertFalse(result);
    }

    @Test
    void example9() {
        String s = " 6e-1";

        final boolean result = solution.isNumber(s);

        Assertions.assertTrue(result);
    }

    @Test
    void example10() {
        String s = " 99e2.5";

        final boolean result = solution.isNumber(s);

        Assertions.assertFalse(result);
    }

    @Test
    void example11() {
        String s = "53.5e93";

        final boolean result = solution.isNumber(s);

        Assertions.assertTrue(result);
    }

    @Test
    void example12() {
        String s = " --6";

        final boolean result = solution.isNumber(s);

        Assertions.assertFalse(result);
    }

    @Test
    void example13() {
        String s = "-+3";

        final boolean result = solution.isNumber(s);

        Assertions.assertFalse(result);
    }

    @Test
    void example14() {
        String s = "95a54e53";

        final boolean result = solution.isNumber(s);

        Assertions.assertFalse(result);
    }

    @Test
    void example15() {
        String s = ".1";

        final boolean result = solution.isNumber(s);

        Assertions.assertTrue(result);
    }

    @Test
    void example16() {
        String s = "3.";

        final boolean result = solution.isNumber(s);

        Assertions.assertTrue(result);
    }

    @Test
    void example17() {
        String s = "..";

        final boolean result = solution.isNumber(s);

        Assertions.assertFalse(result);
    }

    @Test
    void example18() {
        String s = ".";

        final boolean result = solution.isNumber(s);

        Assertions.assertFalse(result);
    }

    @Test
    void example19() {
        String s = ".e1";

        final boolean result = solution.isNumber(s);

        Assertions.assertFalse(result);
    }

    @Test
    void example20() {
        String s = " -.";

        final boolean result = solution.isNumber(s);

        Assertions.assertFalse(result);
    }

    @Test
    void example21() {
        String s = "+.8";

        final boolean result = solution.isNumber(s);

        Assertions.assertTrue(result);
    }

    @Test
    void example22() {
        String s = " +0e-";

        final boolean result = solution.isNumber(s);

        Assertions.assertFalse(result);
    }

    @Test
    void example23() {
        String s = " 005047e+6";

        final boolean result = solution.isNumber(s);

        Assertions.assertTrue(result);
    }
}
