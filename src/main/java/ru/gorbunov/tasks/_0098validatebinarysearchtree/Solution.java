package ru.gorbunov.tasks._0098validatebinarysearchtree;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Validate Binary Search Tree
 * <p>
 * Given a binary tree, determine if it is a valid binary search tree (BST).
 * Assume a BST is defined as follows:
 *     The left subtree of a node contains only nodes with keys less than the node's key.
 *     The right subtree of a node contains only nodes with keys greater than the node's key.
 *     Both the left and right subtrees must also be binary search trees.
 * Example 1:
 *     2
 *    / \
 *   1   3
 * Input: [2,1,3]
 * Output: true
 * Example 2:
 *     5
 *    / \
 *   1   4
 *      / \
 *     3   6
 * Input: [5,1,4,null,null,3,6]
 * Output: false
 * Explanation: The root node's value is 5 but its right child's value is 4.
 */
public class Solution {

    public boolean isValidBST(TreeNode root) {
        return isValid(root, null, null);
    }

    private boolean isValid(TreeNode node, Integer minLimit, Integer maxLimit) {
        if (node == null) {
            return true;
        }
        if (node.left != null && (node.left.val >= node.val || minLimit != null && node.left.val <= minLimit ) ) {
            return false;
        }
        if (node.right != null && (node.right.val <= node.val || maxLimit != null && node.right.val >= maxLimit)) {
            return false;
        }
        return isValid(node.left, minLimit, node.val) && isValid(node.right, node.val, maxLimit);
    }

    public boolean isValidBstInOrder(TreeNode root) {
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode prev = null;
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (prev != null && prev.val >= root.val) {
                return false;
            }
            prev = root;
            root = root.right;
        }
        return true;
    }


    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
