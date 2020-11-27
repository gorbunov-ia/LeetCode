package ru.gorbunov.tasks._0104maximumdepthofbinarytree;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.gorbunov.tasks.structure.tree.TreeNode;

class SolutionTest {

    private Solution solution;

    @BeforeEach
    void setUp() {
        solution = new Solution();
    }

    @Test
    void example1() {
        TreeNode root = new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)));

        int result = solution.maxDepth(root);

        Assertions.assertEquals(3, result);
    }

    @Test
    void example2() {
        TreeNode root = new TreeNode(1, null, new TreeNode(2));

        int result = solution.maxDepth(root);

        Assertions.assertEquals(2, result);
    }

    @Test
    void example3() {
        TreeNode root = null;

        int result = solution.maxDepth(root);

        Assertions.assertEquals(0, result);
    }

    @Test
    void example4() {
        TreeNode root = new TreeNode(0);

        int result = solution.maxDepth(root);

        Assertions.assertEquals(1, result);
    }
}