package ru.gorbunov.tasks._0114flattenbinarytreetolinkedlist;

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
        TreeNode root = new TreeNode(1,
                new TreeNode(2, new TreeNode(3), new TreeNode(4)),
                new TreeNode(5, null, new TreeNode(6)));

        solution.flatten(root);

        assertTree(root);
    }

    @Test
    void example2() {
        TreeNode root = new TreeNode(0);

        solution.flatten(root);

        Assertions.assertEquals(0, root.val);
        Assertions.assertNull(root.left);
        Assertions.assertNull(root.right);
    }

    private void assertTree(TreeNode node) {
        for (int i = 1; i <= 6; i++) {
            node = assertRight(node, i);
        }
        Assertions.assertNull(node);
    }

    private TreeNode assertRight(TreeNode node, int val) {
        Assertions.assertEquals(val, node.val);
        Assertions.assertNull(node.left);
        return node.right;
    }

}