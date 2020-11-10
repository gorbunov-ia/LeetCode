package ru.gorbunov.tasks._0096uniquebinarysearchtrees;

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
        int n = 3;

        int result = solution.numTrees(n);

        Assertions.assertEquals(5, result);
    }

    @Test
    void example2() {
        int n = 2;

        int result = solution.numTrees(n);

        Assertions.assertEquals(2, result);
    }
}