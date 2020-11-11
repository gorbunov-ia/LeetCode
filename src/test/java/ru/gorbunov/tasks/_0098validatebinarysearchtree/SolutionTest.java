package ru.gorbunov.tasks._0098validatebinarysearchtree;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static ru.gorbunov.tasks._0098validatebinarysearchtree.Solution.TreeNode;

class SolutionTest {

    private Solution solution;

    @BeforeEach
    void setUp() {
        solution = new Solution();
    }

    @Test
    void example1() {
        TreeNode root = new TreeNode(2, new TreeNode(1), new TreeNode(3));

        boolean result = solution.isValidBST(root);

        Assertions.assertTrue(result);
    }

    @Test
    void example2() {
        TreeNode root = new TreeNode(5, new TreeNode(1), new TreeNode(4, new TreeNode(3), new TreeNode(6)));

        boolean result = solution.isValidBST(root);

        Assertions.assertFalse(result);
    }
}