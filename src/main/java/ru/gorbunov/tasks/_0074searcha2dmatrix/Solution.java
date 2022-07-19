package ru.gorbunov.tasks._0074searcha2dmatrix;

/**
 * 74. Search a 2D Matrix
 * <p>
 * Write an efficient algorithm that searches for a value target in an m x n integer matrix. This matrix has the
 * following properties:
 * 1. Integers in each row are sorted from left to right.
 * 2. The first integer of each row is greater than the last integer of the previous row.
 * <p>
 * Example 1:
 * Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
 * Output: true
 * Example 2:
 * Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
 * Output: false
 * Constraints:
 * m == matrix.length
 * n == matrix[i].length
 * 1 <= m, n <= 100
 * -10^4 <= matrix[i][j], target <= 10^4
 */
public class Solution {

    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        if (target < matrix[0][0] || target > matrix[m - 1][n - 1]) {
            return false;
        }
        int[] firstColumn = new int[m];
        for (int i = 0; i < m; i++) {
            firstColumn[i] = matrix[i][0];
        }
        int row = binarySearch(firstColumn, target);

        int column = binarySearch(matrix[row], target);
        return matrix[row][column] == target;
    }

    private int binarySearch(int[] values, int target) {
        int left = 0;
        int right = values.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (values[mid] == target) {
                return mid;
            }
            if (target > values[mid]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left - 1;
    }

}
