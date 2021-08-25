package ru.gorbunov.tasks._0236lowestcommonancestorofabinarytree;

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
        TreeNode n9 = new TreeNode(4);
        TreeNode n8 = new TreeNode(7);
        TreeNode n7 = new TreeNode(8);
        TreeNode n6 = new TreeNode(0);
        TreeNode n5 = new TreeNode(2, n8, n9);
        TreeNode n4 = new TreeNode(6);
        TreeNode n3 = new TreeNode(1, n6, n7);
        TreeNode n2 = new TreeNode(5, n4, n5);
        TreeNode n1 = new TreeNode(3, n2, n3);

        TreeNode result = solution.lowestCommonAncestor(n1, n2, n3);

        Assertions.assertEquals(n1, result);
    }

    @Test
    void example2() {
        TreeNode n9 = new TreeNode(4);
        TreeNode n8 = new TreeNode(7);
        TreeNode n7 = new TreeNode(8);
        TreeNode n6 = new TreeNode(0);
        TreeNode n5 = new TreeNode(2, n8, n9);
        TreeNode n4 = new TreeNode(6);
        TreeNode n3 = new TreeNode(1, n6, n7);
        TreeNode n2 = new TreeNode(5, n4, n5);
        TreeNode n1 = new TreeNode(3, n2, n3);

        TreeNode result = solution.lowestCommonAncestor(n1, n2, n9);

        Assertions.assertEquals(n2, result);
    }

    @Test
    void example3() {
        TreeNode n2 = new TreeNode(2);
        TreeNode n1 = new TreeNode(1, n2, null);

        TreeNode result = solution.lowestCommonAncestor(n1, n1, n2);

        Assertions.assertEquals(n1, result);
    }
}