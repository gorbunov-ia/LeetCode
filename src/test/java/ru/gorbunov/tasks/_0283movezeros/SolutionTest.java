package ru.gorbunov.tasks._0283movezeros;

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
        int[] input = new int[]{0,1,0,3,12};

        solution.moveZeroes(input);

        Assertions.assertArrayEquals(new int[]{1,3,12,0,0}, input);
    }
}