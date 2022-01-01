package ru.gorbunov.tasks._0226invertbinarytree;

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
        TreeNode left = new TreeNode(2, new TreeNode(1), new TreeNode(3));
        TreeNode right = new TreeNode(7, new TreeNode(6), new TreeNode(9));
        TreeNode root = new TreeNode(4, left, right);

        TreeNode result = solution.invertTree(root);

        Assertions.assertEquals(4, result.val);
        assertThree(result.left, 7, 9, 6);
        assertThree(result.right, 2, 3, 1);
    }

    @Test
    void example2() {
        TreeNode root = new TreeNode(2, new TreeNode(1), new TreeNode(3));

        TreeNode result = solution.invertTree(root);

        assertThree(result, 2, 3, 1);
    }

    @Test
    void example3() {
        TreeNode root = null;

        TreeNode result = solution.invertTree(root);

        Assertions.assertNull(result);
    }

    private void assertThree(TreeNode node, int root, int left, int right) {
        Assertions.assertEquals(root, node.val);
        Assertions.assertEquals(left, node.left.val);
        Assertions.assertNull(node.left.left);
        Assertions.assertNull(node.left.right);
        Assertions.assertEquals(right, node.right.val);
        Assertions.assertNull(node.right.left);
        Assertions.assertNull(node.right.right);
    }

    // * Example 3:
    // * Input: root = []
}