package ru.gorbunov.tasks._0437pathsum3;

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
        TreeNode n9 = new TreeNode(1);
        TreeNode n8 = new TreeNode(-2);
        TreeNode n7 = new TreeNode(3);
        TreeNode n6 = new TreeNode(11);
        TreeNode n5 = new TreeNode(2, null, n9);
        TreeNode n4 = new TreeNode(3, n7, n8);
        TreeNode n3 = new TreeNode(-3, null, n6);
        TreeNode n2 = new TreeNode(5, n4, n5);
        TreeNode n1 = new TreeNode(10, n2, n3);

        int result = solution.pathSum(n1, 8);

        Assertions.assertEquals(3, result);
    }

    @Test
    void example2() {
        TreeNode n10 = new TreeNode(1);
        TreeNode n9 = new TreeNode(5);
        TreeNode n8 = new TreeNode(2);
        TreeNode n7 = new TreeNode(7);
        TreeNode n6 = new TreeNode(4);
        TreeNode n5 = new TreeNode(13, n9, n10);
        TreeNode n4 = new TreeNode(11, n7, n8);
        TreeNode n3 = new TreeNode(8, n5, n6);
        TreeNode n2 = new TreeNode(4, n4, null);
        TreeNode n1 = new TreeNode(5, n2, n3);

        int result = solution.pathSum(n1, 22);

        Assertions.assertEquals(3, result);
    }

    @Test
    void example3() {
        TreeNode n1 = new TreeNode(2, new TreeNode(2, new TreeNode(-4, new TreeNode(4), null), null), null);

        int result = solution.pathSum(n1, 4);

        Assertions.assertEquals(3, result);
    }

}