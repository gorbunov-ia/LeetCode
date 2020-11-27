package ru.gorbunov.tasks._0105constructbinarytreefrompreorderandinordertraversal;

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
        int[] preorder = new int[]{3, 9, 20, 15, 7};
        int[] inorder = new int[]{9, 3, 15, 20, 7};

        TreeNode result = solution.buildTree(preorder, inorder);

        assertTree(result);
    }

    private void assertTree(TreeNode node) {
        Assertions.assertEquals(3, node.val);
        Assertions.assertEquals(9, node.left.val);
        Assertions.assertNull(node.left.left);
        Assertions.assertNull(node.left.right);
        node = node.right;
        Assertions.assertEquals(20, node.val);
        Assertions.assertEquals(15, node.left.val);
        Assertions.assertEquals(7, node.right.val);

        Assertions.assertNull(node.left.left);
        Assertions.assertNull(node.left.right);

        Assertions.assertNull(node.right.left);
        Assertions.assertNull(node.right.right);
    }
}