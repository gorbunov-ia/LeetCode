package ru.gorbunov.tasks._0617mergetwobinarytrees;

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
        TreeNode root1 = new TreeNode(1, new TreeNode(3, new TreeNode(5), null), new TreeNode(2));
        TreeNode root2 = new TreeNode(2, new TreeNode(1, null, new TreeNode(4)), new TreeNode(3, null, new TreeNode(7)));

        TreeNode result = solution.mergeTrees(root1, root2);

        Assertions.assertEquals(3, result.val);
        TreeNode left = result.left;
        Assertions.assertEquals(4, left.val);
        Assertions.assertEquals(5, left.left.val);
        assertLeaf(left.left);
        Assertions.assertEquals(4, left.right.val);
        assertLeaf(left.right);

        TreeNode right = result.right;
        Assertions.assertEquals(5, right.val);
        Assertions.assertNull(right.left);
        Assertions.assertEquals(7, right.right.val);
        assertLeaf(right.right);
    }

    @Test
    void example2() {
        TreeNode root1 = new TreeNode(1);
        TreeNode root2 = new TreeNode(1, new TreeNode(2), null);

        TreeNode result = solution.mergeTrees(root1, root2);

        Assertions.assertEquals(2, result.val);
        Assertions.assertEquals(2, result.left.val);
        assertLeaf(result.left);
        Assertions.assertNull(result.right);
    }

    private void assertLeaf(TreeNode node) {
        Assertions.assertNull(node.left);
        Assertions.assertNull(node.right);
    }
}