package ru.gorbunov.tasks._0437pathsum3;

import ru.gorbunov.tasks.structure.tree.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 437. Path Sum III
 * <p>
 * Given the root of a binary tree and an integer targetSum, return the number of paths where the sum of the values
 * along the path equals targetSum. The path does not need to start or end at the root or a leaf, but it must go
 * downwards (i.e., traveling only from parent nodes to child nodes).
 * Example 1:
 * Input: root = [10,5,-3,3,2,null,11,3,-2,null,1], targetSum = 8
 * Output: 3
 * Explanation: The paths that sum to 8 are shown.
 * Example 2:
 * Input: root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
 * Output: 3
 * Constraints:
 * The number of nodes in the tree is in the range [0, 1000].
 * -10^9 <= Node.val <= 10^9
 * -1000 <= targetSum <= 1000
 */
public class Solution {
    private Map<Integer, Integer> targets = new HashMap<>();

    public int pathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return 0;
        }
        int result = root.val == targetSum ? 1 : 0;
        result += targets.getOrDefault(root.val, 0);

        if (root.left == null && root.right == null) {
            return result;
        }

        targets.put(targetSum, targets.getOrDefault(targetSum, 0) + 1);
        updateTargets(-root.val);

        result += pathSum(root.left, targetSum);
        result += pathSum(root.right, targetSum);

        updateTargets(root.val);
        targets.put(targetSum, targets.getOrDefault(targetSum, 0) - 1);

        return result;
    }

    private void updateTargets(int value) {
        Map<Integer, Integer> newTargets = new HashMap<>();
        for (Map.Entry<Integer, Integer> target : targets.entrySet()) {
            newTargets.put(target.getKey() + value, target.getValue());
        }
        targets = newTargets;
    }
}
