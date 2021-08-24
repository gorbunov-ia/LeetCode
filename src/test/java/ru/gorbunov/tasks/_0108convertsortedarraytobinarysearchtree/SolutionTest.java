package ru.gorbunov.tasks._0108convertsortedarraytobinarysearchtree;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.gorbunov.tasks.structure.tree.TreeNode;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class SolutionTest {

    private Solution solution;

    @BeforeEach
    void setUp() {
        solution = new Solution();
    }

    @Test
    void example1() {
        int[] nums = new int[]{-10, -3, 0, 5, 9};

        TreeNode result = solution.sortedArrayToBST(nums);

        assertEquals(0, result.val);
        assertLeft(result.left);
        assertRight(result.right);
    }

    private void assertLeft(TreeNode current) {
        assertEquals(-3, current.val);
        assertNull(current.right);
        current = current.left;
        assertEquals(-10, current.val);
        assertNull(current.left);
        assertNull(current.right);
    }

    private void assertRight(TreeNode current) {
        assertEquals(9, current.val);
        assertNull(current.right);
        current = current.left;
        assertEquals(5, current.val);
        assertNull(current.left);
        assertNull(current.right);
    }

    @Test
    void example2() {
        int[] nums = new int[]{1, 3};

        TreeNode result = solution.sortedArrayToBST(nums);

        assertEquals(3, result.val);
        assertNull(result.right);
        TreeNode current = result.left;
        assertEquals(1, current.val);
        assertNull(current.left);
        assertNull(current.right);
    }
}