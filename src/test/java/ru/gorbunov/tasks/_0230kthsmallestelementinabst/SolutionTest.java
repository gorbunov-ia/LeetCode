package ru.gorbunov.tasks._0230kthsmallestelementinabst;

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
        TreeNode root = new TreeNode(3, new TreeNode(1, null, new TreeNode(2)), new TreeNode(4));

        int result = solution.kthSmallest(root, 1);

        Assertions.assertEquals(1, result);
    }

    @Test
    void example2() {
        TreeNode left = new TreeNode(3, new TreeNode(2, new TreeNode(1), null), new TreeNode(4));
        TreeNode right = new TreeNode(6);
        TreeNode root = new TreeNode(5, left, right);

        int result = solution.kthSmallest(root, 3);

        Assertions.assertEquals(3, result);
    }
}