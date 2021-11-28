package ru.gorbunov.tasks._0199binarytreerightsideview;

import ru.gorbunov.tasks.structure.tree.TreeNode;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 199. Binary Tree Right Side View
 * <p>
 * Given the root of a binary tree, imagine yourself standing on the right side of it, return the values of the nodes
 * you can see ordered from top to bottom.
 * Example 1:
 *    1
 *   / \
 *  2   3
 *   \   \
 *   5    4
 * Input: root = [1,2,3,null,5,null,4]
 * Output: [1,3,4]
 * Example 2:
 * Input: root = [1,null,3]
 * Output: [1,3]
 * Example 3:
 * Input: root = []
 * Output: []
 */
public class Solution {

    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }
        List<Integer> view = new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(root);
        while (!queue.isEmpty()) {
            int sizeOfLine = queue.size();

            TreeNode last = null;
            for (int i = 0; i < sizeOfLine; i++) {
                last = queue.poll();
                addIfNotNull(queue, last.left);
                addIfNotNull(queue, last.right);
            }
            view.add(last.val);
        }

        return view;
    }

    private void addIfNotNull(Queue<TreeNode> queue, TreeNode node) {
        if (node != null) {
            queue.add(node);
        }
    }
}
