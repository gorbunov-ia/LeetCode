package ru.gorbunov.tasks._0398randompickindex;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class SolutionTest {

    @Test
    void example1() {
        int[] nums = new int[]{1, 2, 3, 3, 3};

        Solution solution = new Solution(nums);
//        SpaceSolution solution = new SpaceSolution(nums);

        Assertions.assertThat(solution.pick(3)).isIn(2, 3, 4);
        Assertions.assertThat(solution.pick(1)).isEqualTo(0);
        Assertions.assertThat(solution.pick(3)).isIn(2, 3, 4);
    }

}