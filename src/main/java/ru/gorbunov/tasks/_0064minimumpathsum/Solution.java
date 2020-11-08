package ru.gorbunov.tasks._0064minimumpathsum;

/**
 * Minimum Path Sum
 * <p>
 * Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right, which minimizes the
 * sum of all numbers along its path.
 * Note: You can only move either down or right at any point in time.
 * Example 1:
 * Input: grid = [[1,3,1],[1,5,1],[4,2,1]]
 * Output: 7
 * Explanation: Because the path 1 → 3 → 1 → 1 → 1 minimizes the sum.
 * Example 2:
 * Input: grid = [[1,2,3],[4,5,6]]
 * Output: 12
 * Constraints:
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n <= 200
 * 0 <= grid[i][j] <= 100
 */
public class Solution {

    /**
     * Runtime complexity O(m * n)
     * Space complexity O(m * n)
     */
    public int rawMinPathSum(int[][] grid) {
        int[][] dp = new int[grid.length][grid[0].length];
        dp[0][0] = grid[0][0];
        for (int i = 1; i < grid.length; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }
        for (int i = 1; i < grid[0].length; i++) {
            dp[0][i] = dp[0][i - 1] + grid[0][i];
        }
        for (int i = 1; i < grid.length; i++) {
            for (int j = 1; j < grid[0].length; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }
        return dp[grid.length - 1][grid[0].length - 1];
    }

    /**
     * Runtime complexity O(m * n)
     * Space complexity O(1)
     */
    public int minPathSum(int[][] grid) {
        final int rows = grid.length;
        final int columns = grid[0].length;
        for (int i = 1; i < rows; i++) {
            grid[i][0] += grid[i - 1][0];
        }
        for (int i = 1; i < columns; i++) {
            grid[0][i] += grid[0][i - 1];
        }
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < columns; j++) {
                grid[i][j] += Math.min(grid[i - 1][j], grid[i][j - 1]);
            }
        }
        return grid[rows - 1][columns - 1];
    }

}
