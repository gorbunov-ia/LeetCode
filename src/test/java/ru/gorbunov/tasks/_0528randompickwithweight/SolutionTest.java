package ru.gorbunov.tasks._0528randompickwithweight;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;


class SolutionTest {

    @Test
    void example1() {
        int[] w = new int[]{1};

        Solution solution = create(w);

        Assertions.assertThat(solution.pickIndex()).isEqualTo(0);
        Assertions.assertThat(solution.pickIndex()).isEqualTo(0);
    }

    @Test
    void example2() {
        int[] w = new int[]{1, 3};

        Solution solution = create(w);

        assertOneOf(solution.pickIndex(), 0, 1);
        assertOneOf(solution.pickIndex(), 0, 1);
        assertOneOf(solution.pickIndex(), 0, 1);
        assertOneOf(solution.pickIndex(), 0, 1);
        assertOneOf(solution.pickIndex(), 0, 1);
    }

    @Test
    void example3() {
        int[] w = new int[]{1,3,1};

        Solution solution = create(w);

        assertOneOf(solution.pickIndex(), 0, 1, 2);
        assertOneOf(solution.pickIndex(), 0, 1, 2);
        assertOneOf(solution.pickIndex(), 0, 1, 2);
        assertOneOf(solution.pickIndex(), 0, 1, 2);
        assertOneOf(solution.pickIndex(), 0, 1, 2);

    }

    private void assertOneOf(int actual, Integer... expected) {
        System.out.println("result index: " + actual);
        Assertions.assertThat(actual).isIn(expected);
    }

    private Solution create(int[] w) {
//        return new ArraySolution(w);
//        return new TreeSolution(w);
        return new SpaceArraySolution(w);
    }

}