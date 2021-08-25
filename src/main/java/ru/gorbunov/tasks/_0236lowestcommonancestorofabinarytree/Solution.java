package ru.gorbunov.tasks._0236lowestcommonancestorofabinarytree;

import ru.gorbunov.tasks.structure.tree.TreeNode;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * 236. Lowest Common Ancestor of a Binary Tree
 * Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.
 * According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p and q
 * as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”
 * Example 1:
 * Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
 * Output: 3
 * Explanation: The LCA of nodes 5 and 1 is 3.
 * Example 2:
 * Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
 * Output: 5
 * Explanation: The LCA of nodes 5 and 4 is 5, since a node can be a descendant of itself according to the LCA definition.
 * Example 3:
 * Input: root = [1,2], p = 1, q = 2
 * Output: 1
 * Constraints:
 * The number of nodes in the tree is in the range [2, 10^5].
 * -10^9 <= Node.val <= 10^9
 * All Node.val are unique.
 * p != q
 * p and q will exist in the tree.
 */
public class Solution {

    private final List<Path> path = new LinkedList<>();
    private List<Path> pPath;
    private List<Path> qPath;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == null || q == null) {
            throw new NullPointerException("TreeNode should not be null");
        }
        findPaths(root, p, q);

        TreeNode targetNode = root;
        Iterator<Path> pi = pPath.iterator();
        Iterator<Path> qi = qPath.iterator();
        while (pi.hasNext() && qi.hasNext()) {
            Path pSegment = pi.next();
            Path qSegment = qi.next();
            if (pSegment != qSegment) {
                break;
            }
            targetNode = pSegment == Path.LEFT ? targetNode.left : targetNode.right;
        }

        return targetNode;
    }

    private void findPaths(TreeNode current, TreeNode p, TreeNode q) {
        if (current.left != null) {
            path.add(Path.LEFT);
            findPaths(current.left, p, q);
            path.remove(path.size() - 1);
        }
        if (current.equals(p)) {
            pPath = new LinkedList<>(path);
        }
        if (current.equals(q)) {
            qPath = new LinkedList<>(path);
        }
        if (current.right != null) {
            path.add(Path.RIGHT);
            findPaths(current.right, p, q);
            path.remove(path.size() - 1);
        }
    }

    private enum Path {
        LEFT,
        RIGHT
    }
}
