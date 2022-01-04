package ru.gorbunov.tasks._0200numberofislands;

/**
 * 200. Number of Islands
 * <p>
 * Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water), return the number of islands.
 * An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may
 * assume all four edges of the grid are all surrounded by water.
 * Example 1:
 * Input: grid = [
 * ["1","1","1","1","0"],
 * ["1","1","0","1","0"],
 * ["1","1","0","0","0"],
 * ["0","0","0","0","0"]
 * ]
 * Output: 1
 * Example 2:
 * Input: grid = [
 * ["1","1","0","0","0"],
 * ["1","1","0","0","0"],
 * ["0","0","1","0","0"],
 * ["0","0","0","1","1"]
 * ]
 * Output: 3
 * Constraints:
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n <= 300
 * grid[i][j] is '0' or '1'.
 */
public class Solution {

    public int numIslands(char[][] grid) {
        int islandNumber = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (isLand(grid[i][j])) {
                    islandNumber++;
                    markAsVisited(grid, i, j);
                }
            }
        }
        return islandNumber;
    }

    private void markAsVisited(char[][] grid, int i, int j) {
        grid[i][j] = '*';
        if (i > 0 && isLand(grid[i - 1][j])) {
            markAsVisited(grid, i - 1, j);
        }
        if (i + 1 < grid.length && isLand(grid[i + 1][j])) {
            markAsVisited(grid, i + 1, j);
        }
        if (j > 0 && isLand(grid[i][j - 1])) {
            markAsVisited(grid, i, j - 1);
        }
        if (j + 1 < grid[i].length && isLand(grid[i][j + 1])) {
            markAsVisited(grid, i, j + 1);
        }
    }

    private boolean isLand(char c) {
        return c == '1';
    }

}
