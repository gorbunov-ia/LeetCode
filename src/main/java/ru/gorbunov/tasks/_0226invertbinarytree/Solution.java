package ru.gorbunov.tasks._0226invertbinarytree;

import ru.gorbunov.tasks.structure.tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 226. Invert Binary Tree
 * <p>
 * Given the root of a binary tree, invert the tree, and return its root.
 * Example 1:
 * Input: root = [4,2,7,1,3,6,9]
 * Output: [4,7,2,9,6,3,1]
 * Example 2:
 * Input: root = [2,1,3]
 * Output: [2,3,1]
 * Example 3:
 * Input: root = []
 * Output: []
 * Constraints:
 * The number of nodes in the tree is in the range [0, 100].
 * -100 <= Node.val <= 100
 */
public class Solution {

    public TreeNode invertTree(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        addIfNotNull(root, queue);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();

            swapChildren(node);
            addIfNotNull(node.left, queue);
            addIfNotNull(node.right, queue);
        }
        return root;
    }

    private void swapChildren(TreeNode node) {
        TreeNode tmp = node.left;
        node.left = node.right;
        node.right = tmp;
    }

    private void addIfNotNull(TreeNode node, Queue<TreeNode> accumulator) {
        if (node != null) {
            accumulator.add(node);
        }
    }
}
