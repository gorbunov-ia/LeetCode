package ru.gorbunov.tasks._0094binarytreeinordertraversal;

import ru.gorbunov.tasks.structure.tree.TreeNode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * Binary Tree Inorder Traversal
 * <p>
 * Given the root of a binary tree, return the inorder traversal of its nodes' values.
 * Example 1:
 * Input: root = [1,null,2,3]
 * Output: [1,3,2]
 * Example 2:
 * Input: root = []
 * Output: []
 * Example 3:
 * Input: root = [1]
 * Output: [1]
 * Example 4:
 * Input: root = [1,2]
 * Output: [2,1]
 * Example 5:
 * Input: root = [1,null,2]
 * Output: [1,2]
 * Constraints:
 * The number of nodes in the tree is in the range [0, 100].
 * -100 <= Node.val <= 100
 * Follow up:
 * Recursive solution is trivial, could you do it iteratively?
 */
public class Solution {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> output = new LinkedList<>();
        go(root, output);
        return output;
    }


    private void go(TreeNode root, List<Integer> output) {
        if (root == null) {
            return;
        }
        go(root.left, output);
        output.add(root.val);
        go(root.right, output);
    }

    public List<Integer> iterativeInorderTraversal(TreeNode root) {
        List<Integer> output = new LinkedList<>();

        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode curr = root;
        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            output.add(curr.val);
            curr = curr.right;
        }
        return output;
    }
}
