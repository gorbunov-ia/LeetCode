package ru.gorbunov.tasks._0199binarytreerightsideview;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.gorbunov.tasks.structure.tree.TreeNode;

import java.util.List;

class SolutionTest {

    private Solution solution;

    @BeforeEach
    void setUp() {
        solution = new Solution();
    }

    @Test
    void example1() {
        TreeNode root = new TreeNode(1, new TreeNode(2, null, new TreeNode(5)), new TreeNode(3, null, new TreeNode(4)));

        List<Integer> result = solution.rightSideView(root);

        Assertions.assertEquals(3, result.size());
        Assertions.assertEquals(1, result.get(0));
        Assertions.assertEquals(3, result.get(1));
        Assertions.assertEquals(4, result.get(2));
    }

    @Test
    void example2() {
        TreeNode root = new TreeNode(1, null, new TreeNode(3));

        List<Integer> result = solution.rightSideView(root);

        Assertions.assertEquals(2, result.size());
        Assertions.assertEquals(1, result.get(0));
        Assertions.assertEquals(3, result.get(1));
    }

    @Test
    void example3() {
        List<Integer> result = solution.rightSideView(null);

        Assertions.assertTrue(result.isEmpty());
    }
}