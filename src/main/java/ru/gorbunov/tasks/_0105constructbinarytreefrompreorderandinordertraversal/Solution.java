package ru.gorbunov.tasks._0105constructbinarytreefrompreorderandinordertraversal;

import ru.gorbunov.tasks.structure.tree.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * Construct Binary Tree from Preorder and Inorder Traversal
 * <p>
 * Given preorder and inorder traversal of a tree, construct the binary tree.
 * Note:
 * You may assume that duplicates do not exist in the tree.
 * For example, given
 * preorder = [3,9,20,15,7]
 * inorder = [9,3,15,20,7]
 * Return the following binary tree:
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 */
public class Solution {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0) {
            return null;
        }
        Map<Integer, Integer> indexes = new HashMap<>();
        for (int i = 0 ; i < inorder.length; i++) {
            indexes.put(inorder[i], i);
        }

        return buildTree(preorder, 0, 0, inorder.length - 1, indexes);
    }

    private TreeNode buildTree(int[] preorder, int preStart, int inStart, int inEnd, Map<Integer, Integer> inorder) {
        if (preStart > preorder.length - 1 || inStart > inEnd) {
            return null;
        }
        int rootValue = preorder[preStart];
        TreeNode root = new TreeNode(rootValue);

        int rootIndex = inorder.get(rootValue);
        root.left = buildTree(preorder, preStart + 1, inStart, rootIndex - 1, inorder);
        root.right = buildTree(preorder, preStart + (rootIndex - inStart) + 1, rootIndex + 1, inEnd, inorder);
        return root;
    }
}
