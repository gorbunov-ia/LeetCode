package ru.gorbunov.tasks._0072editdistance;

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
        String word1 = "horse";
        String word2 = "ros";

        int result = solution.minDistance(word1, word2);

        Assertions.assertEquals(3, result);
    }

    @Test
    void example2() {
        String word1 = "intention";
        String word2 = "execution";

        int result = solution.minDistance(word1, word2);

        Assertions.assertEquals(5, result);
    }
}