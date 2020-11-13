package ru.gorbunov.tasks._0101symmetrictree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Queue;

/**
 * Symmetric Tree
 * <p>
 * Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
 * For example, this binary tree [1,2,2,3,4,4,3] is symmetric:
 * 1
 * / \
 * 2   2
 * / \ / \
 * 3  4 4  3
 * But the following [1,2,2,null,3,null,3] is not:
 * 1
 * / \
 * 2   2
 * \   \
 * 3    3
 * Follow up: Solve it both recursively and iteratively.
 */
public class Solution {

    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        Queue<Optional<TreeNode>> queue = new LinkedList<>();
        List<Optional<TreeNode>> current = new ArrayList<>();
        queue.add(Optional.of(root));
        while (!queue.isEmpty()) {
            while (!queue.isEmpty()) {
                current.add(queue.poll());
            }
            if (!isSymmetricList(current)) {
                return false;
            }
            boolean valueIsPresent = false;
            for (Optional<TreeNode> node : current) {
                final Optional<TreeNode> left = node.map(n -> n.left);
                final Optional<TreeNode> right = node.map(n -> n.right);
                queue.add(left);
                queue.add(right);
                valueIsPresent |= left.isPresent() || right.isPresent();

            }
            if (!valueIsPresent) {
                break;
            } else {
                current.clear();
            }
        }
        return true;
    }

    private boolean isSymmetricList(List<Optional<TreeNode>> nodes) {
        for (int i = 0; i < nodes.size() / 2; i++) {
            Integer l = nodes.get(i).map(n -> n.val).orElse(null);
            Integer r = nodes.get(nodes.size() - i - 1).map(n -> n.val).orElse(null);
            if (!Objects.equals(l, r)) {
                return false;
            }
        }
        return true;
    }

    public boolean isSymmetricRecursion(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isMirror(root.left, root.right);
    }

    private boolean isMirror(TreeNode first, TreeNode second) {
        if (first == null && second == null) {
            return true;
        }
        if (first == null || second == null) {
            return false;
        }
        return first.val == second.val
                && isMirror(first.left, second.right)
                && isMirror(first.right, second.left);
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
