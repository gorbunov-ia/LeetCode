package ru.gorbunov.tasks._0101symmetrictree;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.gorbunov.tasks._0101symmetrictree.Solution.TreeNode;

class SolutionTest {

    private Solution solution;

    @BeforeEach
    void setUp() {
        solution = new Solution();
    }

    @Test
    void example1() {
        final TreeNode left = new TreeNode(2, new TreeNode(3), new TreeNode(4));
        final TreeNode right = new TreeNode(2, new TreeNode(4), new TreeNode(3));
        TreeNode root = new TreeNode(1, left, right);

        boolean result = solution.isSymmetric(root);

        Assertions.assertTrue(result);
    }


    @Test
    void example2() {
        final TreeNode left = new TreeNode(2, null, new TreeNode(3));
        final TreeNode right = new TreeNode(2, null, new TreeNode(3));
        TreeNode root = new TreeNode(1, left, right);

        boolean result = solution.isSymmetric(root);

        Assertions.assertFalse(result);
    }
}