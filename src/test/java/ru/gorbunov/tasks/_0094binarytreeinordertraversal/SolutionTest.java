package ru.gorbunov.tasks._0094binarytreeinordertraversal;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.gorbunov.tasks.structure.tree.TreeNode;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class SolutionTest {

    private Solution solution;

    @BeforeEach
    void setUp() {
        solution = new Solution();
    }

    @Test
    void example1() {
        TreeNode tree = createTree();

        final List<Integer> result = solution.inorderTraversal(tree);

        Assertions.assertEquals(Arrays.asList(1, 3, 2), result);
    }

    private TreeNode createTree() {
        TreeNode l3 = new TreeNode(3);
        TreeNode l2 = new TreeNode(2, l3, null);
        return new TreeNode(1, null, l2);
    }

    @Test
    void example2() {
        TreeNode tree = null;

        final List<Integer> result = solution.inorderTraversal(tree);

        Assertions.assertTrue(result.isEmpty());
    }

    @Test
    void example3() {
        TreeNode tree = new TreeNode(1);

        final List<Integer> result = solution.inorderTraversal(tree);

        Assertions.assertEquals(Collections.singletonList(1), result);
    }

    @Test
    void example4() {
        TreeNode tree = new TreeNode(1, new TreeNode(2), null);

        final List<Integer> result = solution.inorderTraversal(tree);

        Assertions.assertEquals(Arrays.asList(2, 1), result);
    }

    @Test
    void example5() {
        TreeNode tree = new TreeNode(1, null, new TreeNode(2));

        final List<Integer> result = solution.inorderTraversal(tree);

        Assertions.assertEquals(Arrays.asList(1, 2), result);
    }
}