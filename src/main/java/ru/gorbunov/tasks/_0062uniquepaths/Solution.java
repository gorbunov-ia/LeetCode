package ru.gorbunov.tasks._0062uniquepaths;

/**
 * Unique Paths
 * <p>
 * A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
 * The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right
 * corner of the grid (marked 'Finish' in the diagram below).
 * How many possible unique paths are there?
 * Example 1:
 * Input: m = 3, n = 7
 * Output: 28
 * Example 2:
 * Input: m = 3, n = 2
 * Output: 3
 * Explanation:
 * From the top-left corner, there are a total of 3 ways to reach the bottom-right corner:
 * 1. Right -> Down -> Down
 * 2. Down -> Down -> Right
 * 3. Down -> Right -> Down
 * Example 3:
 * Input: m = 7, n = 3
 * Output: 28
 * Example 4:
 * Input: m = 3, n = 3
 * Output: 6
 * Constraints:
 * 1 <= m, n <= 100
 * It's guaranteed that the answer will be less than or equal to 2 * 10^9.
 */
public class Solution {

    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for(int i = 0; i < dp.length; i++) {
            dp[i][0] = 1;
        }
        for(int i = 0; i < dp[0].length; i++) {
            dp[0][i] = 1;
        }
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j -1];
            }
        }
        return dp[m - 1][n - 1];
    }

    public int fastUniquePaths(int m, int n) {
        int N = n + m - 2;// how much steps we need to do
        int k = Math.min(m - 1, n - 1); // number of steps that need to go (down or right)
        double res = 1;
        // here we calculate the total possible path number
        // Combination(N, k) = n! / (k!(n - k)!)
        // reduce the numerator and denominator and get
        // C = ( (n - k + 1) * (n - k + 2) * ... * n ) / k!
        for (int i = 1; i <= k; i++)
            res = res * (N - k + i) / i;
        return (int)res;
    }

    //n = 5
    //k = 3
    //n! = 1 * 2 * 3 * 4 * 5
    //(n - k)! = 1 * 2
    //n! / (n - k)! = 3 * 4 * 5
    //[n! / (n - k)!] / k! = [3 * 4 * 5] / [1 * 2 * 3] = 3/1 * 4/2 * 5/3 = 10
}
