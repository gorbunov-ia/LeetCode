package ru.gorbunov.tasks._0102binarytreelevelordertraversal;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.gorbunov.tasks.structure.tree.TreeNode;

import java.util.Collections;
import java.util.List;

import static java.util.Arrays.asList;

class SolutionTest {

    private Solution solution;

    @BeforeEach
    void setUp() {
        solution = new Solution();
    }

    @Test
    void example1() {
        TreeNode root = new TreeNode(3, new TreeNode(9),
                new TreeNode(20, new TreeNode(15), new TreeNode(7)));

        List<List<Integer>> result = solution.levelOrder(root);

        Assertions.assertEquals(asList(Collections.singletonList(3), asList(9, 20), asList(15, 7)), result);
    }

    @Test
    void example2() {
        TreeNode root = null;

        List<List<Integer>> result = solution.levelOrder(root);

        Assertions.assertEquals(Collections.emptyList(), result);
    }
}