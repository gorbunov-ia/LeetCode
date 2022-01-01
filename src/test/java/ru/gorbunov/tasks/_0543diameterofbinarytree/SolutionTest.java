package ru.gorbunov.tasks._0543diameterofbinarytree;

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
        TreeNode root = new TreeNode(1, new TreeNode(2, new TreeNode(4), new TreeNode(5)), new TreeNode(3));

        int result = solution.diameterOfBinaryTree(root);

        Assertions.assertEquals(3, result);
    }

    @Test
    void example2() {
        TreeNode root = new TreeNode(1, new TreeNode(2), null);

        int result = solution.diameterOfBinaryTree(root);

        Assertions.assertEquals(1, result);
    }

}