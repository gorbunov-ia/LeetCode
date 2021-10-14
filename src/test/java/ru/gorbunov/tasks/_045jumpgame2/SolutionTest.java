package ru.gorbunov.tasks._045jumpgame2;

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
        int[] nums = {2, 3, 1, 1, 4};

        int result = solution.jump(nums);

        Assertions.assertEquals(2, result);
    }


    @Test
    void example2() {
        int[] nums = {2,3,0,1,4};

        int result = solution.jump(nums);

        Assertions.assertEquals(2, result);
    }

    @Test
    void example3() {
        int[] nums = {4,2,0};

        int result = solution.jump(nums);

        Assertions.assertEquals(1, result);
    }

}