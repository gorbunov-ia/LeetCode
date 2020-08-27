package ru.gorbunov.tasks.fb.tree;

/**
 * Number of Visible Nodes
 * <p>
 * There is a binary tree with N nodes. You are viewing the tree from its left side and can see only the leftmost nodes
 * at each level. Return the number of visible nodes.
 * Note: You can see only the leftmost nodes, but that doesn't mean they have to be left nodes. The leftmost node at
 * a level could be a right node.
 * Signature
 * int visibleNodes(Node root) {
 * Input
 * The root node of a tree, where the number of nodes is between 1 and 1000, and the value of each node is between 0
 * and 1,000,000,000
 * Output
 * An int representing the number of visible nodes.
 * Example
 *             8  <------ root
 *            / \
 *          3    10
 *         / \     \
 *        1   6     14
 *           / \    /
 *          4   7  13
 *
 * output = 4
 */
public class NumberOfVisibleNodes {
    class Node {
        int data;
        Node left;
        Node right;
        Node() {
            this.data = 0;
            this.left = null;
            this.right = null;
        }
        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    // Add any helper functions you may need here
    private int getLength(Node node) {
        if (node == null) {
            return 0;
        }
        return Math.max(getLength(node.left), getLength(node.right)) + 1;
    }

    int visibleNodes(Node root) {
        // Write your code here
        return getLength(root);
    }
}
