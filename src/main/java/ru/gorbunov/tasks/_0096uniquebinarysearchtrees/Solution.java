package ru.gorbunov.tasks._0096uniquebinarysearchtrees;

/**
 * Unique Binary Search Trees
 * <p>
 * Given n, how many structurally unique BST's (binary search trees) that store values 1 ... n?
 * Example:
 * Input: 3
 * Output: 5
 * Explanation:
 * Given n = 3, there are a total of 5 unique BST's:
 * 1         3     3      2      1
 *  \       /     /      / \      \
 *   3     2     1      1   3      2
 *  /     /       \                 \
 * 2     1         2                 3
 * Constraints:
 * 1 <= n <= 19
 */
public class Solution {

    /**
     * G(n): the number of unique BST for a sequence of length n
     * F(i, n), 1 <= i <= n: the number of unique BST,
     * where the number i is the root of BST, and the sequence ranges from 1 to n.
     * <p>
     * Given a sequence 1…n, we pick a number i out of the sequence as the root, then the number of unique BST with
     * the specified root F(i), is the cartesian product of the number of BST for its left and right subtrees.
     * For example, F(3, 7): the number of unique BST tree with number 3 as its root. To construct an unique BST out
     * of the entire sequence [1, 2, 3, 4, 5, 6, 7] with 3 as the root, which is to say, we need to construct an unique
     * BST out of its left subsequence [1, 2] and another BST out of the right subsequence [4, 5, 6, 7], and then
     * combine them together (i.e. cartesian product). The tricky part is that we could consider the number of unique
     * BST out of sequence [1,2] as G(2), and the number of of unique BST out of sequence [4, 5, 6, 7] as G(4).
     * Therefore, F(3,7) = G(2) * G(4). i.e.
     * F(i, n) = G(i-1) * G(n-i)	1 <= i <= n
     * Combining the above two formulas, we obtain the recursive formula for G(n). i.e.
     * G(n) = G(0) * G(n-1) + G(1) * G(n-2) + … + G(n-1) * G(0)
     */
    public int numTrees(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i] += dp[j - 1] * dp[i - j];
            }
        }
        return dp[n];
    }
}
