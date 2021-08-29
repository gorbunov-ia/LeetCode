package ru.gorbunov.tasks._0938rangesumofbst;

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
        TreeNode n6 = new TreeNode(18);
        TreeNode n5 = new TreeNode(7);
        TreeNode n4 = new TreeNode(3);
        TreeNode n3 = new TreeNode(15, null, n6);
        TreeNode n2 = new TreeNode(5, n4, n5);
        TreeNode n1 = new TreeNode(10, n2, n3);

        int result = solution.rangeSumBST(n1, 7, 15);

        Assertions.assertEquals(32, result);
    }


    @Test
    void example2() {
        TreeNode n9 = new TreeNode(6);
        TreeNode n8 = new TreeNode(1);
        TreeNode n7 = new TreeNode(18);
        TreeNode n6 = new TreeNode(13);
        TreeNode n5 = new TreeNode(7, n9, null);
        TreeNode n4 = new TreeNode(3, n8, null);
        TreeNode n3 = new TreeNode(15, n6, n7);
        TreeNode n2 = new TreeNode(5, n4, n5);
        TreeNode n1 = new TreeNode(10, n2, n3);

        int result = solution.rangeSumBST(n1, 6, 10);

        Assertions.assertEquals(23, result);
    }

}