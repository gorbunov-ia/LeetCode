package ru.gorbunov.tasks.fb.strings;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MatchingPairsTest {

    private MatchingPairs component;

    @BeforeEach
    void setUp() {
        component = new MatchingPairs();
    }

    @Test
    void example1() {
        String s = "abcde";
        String t = "adcbe";

        final int result = component.matchingPairs(s, t);

        Assertions.assertEquals(5, result);
    }

    @Test
    void example2() {
        String s = "abcd";
        String t = "abcd";

        final int result = component.matchingPairs(s, t);

        Assertions.assertEquals(2, result);
    }

    @Test
    void example3() {
        String s = "adcbbb";
        String t = "abcbdb";

        final int result = component.matchingPairs(s, t);

        Assertions.assertEquals(6, result);
    }

    @Test
    void example4() {
        String s = "aab";
        String t = "aab";

        final int result = component.matchingPairs(s, t);

        Assertions.assertEquals(3, result);
    }

    @Test
    void example5() {
        String s = "abcd";
        String t = "afcd";

        final int result = component.matchingPairs(s, t);

        Assertions.assertEquals(2, result);
    }

    @Test
    void example6() {
        String s = "aabcd";
        String t = "aafcd";

        final int result = component.matchingPairs(s, t);

        Assertions.assertEquals(4, result);
    }

    @Test
    void example7() {
        String s = "abcd";
        String t = "afgd";

        final int result = component.matchingPairs(s, t);

        Assertions.assertEquals(2, result);
    }
}