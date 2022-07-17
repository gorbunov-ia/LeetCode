package ru.gorbunov.tasks._0073setmatrixzeroes;

import java.util.BitSet;

/**
 * 73. Set Matrix Zeroes
 * Given an m x n integer matrix matrix, if an element is 0, set its entire row and column to 0's.
 * You must do it in place.
 * Example 1:
 * Input: matrix = [[1,1,1],[1,0,1],[1,1,1]]
 * Output: [[1,0,1],[0,0,0],[1,0,1]]
 * Example 2:
 * Input: matrix = [[0,1,2,0],[3,4,5,2],[1,3,1,5]]
 * Output: [[0,0,0,0],[0,4,5,0],[0,3,1,0]]
 * Constraints:
 * m == matrix.length
 * n == matrix[0].length
 * 1 <= m, n <= 200
 * -2^31 <= matrix[i][j] <= 2^31 - 1
 * Follow up:
 * A straightforward solution using O(mn) space is probably a bad idea.
 * A simple improvement uses O(m + n) space, but still not the best solution.
 * Could you devise a constant space solution?
 */
public class Solution {

    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        BitSet mSet = new BitSet(m);
        BitSet nSet = new BitSet(n);

        for(int i = 0; i < m; i ++) {
            for (int j = 0; j < n; j ++) {
                if (matrix[i][j] == 0) {
                    mSet.set(i);
                    nSet.set(j);
                }
            }
        }

        for(int i = 0; i < m; i ++) {
            for (int j = 0; j < n; j ++) {
                if (mSet.get(i)|| nSet.get(j)) {
                    matrix[i][j] = 0;
                }
            }
        }
    }

}
