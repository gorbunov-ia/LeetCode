package ru.gorbunov.tasks._0072editdistance;

/**
 * 72. Edit Distance
 * <p>
 * Given two strings word1 and word2, return the minimum number of operations required to convert word1 to word2.
 * You have the following three operations permitted on a word:
 * Insert a character
 * Delete a character
 * Replace a character
 * Example 1:
 * Input: word1 = "horse", word2 = "ros"
 * Output: 3
 * Explanation:
 * horse -> rorse (replace 'h' with 'r')
 * rorse -> rose (remove 'r')
 * rose -> ros (remove 'e')
 * Example 2:
 * Input: word1 = "intention", word2 = "execution"
 * Output: 5
 * Explanation:
 * intention -> inention (remove 't')
 * inention -> enention (replace 'i' with 'e')
 * enention -> exention (replace 'n' with 'x')
 * exention -> exection (replace 'n' with 'c')
 * exection -> execution (insert 'u')
 * Constraints:
 * 0 <= word1.length, word2.length <= 500
 * word1 and word2 consist of lowercase English letters.
 */
public class Solution {

    public int minDistance(String word1, String word2) {
        final int[][] distanceMatrix = new int[word1.length() + 1][word2.length() + 1];
        distanceMatrix[0][0] = 0;
        for (int i = 1; i < distanceMatrix.length; i++) {
            distanceMatrix[i][0] = i;
        }
        for (int i = 1; i < distanceMatrix[0].length; i++) {
            distanceMatrix[0][i] = i;
        }

        for (int i = 1; i < distanceMatrix.length; i++) {
            for (int j = 1; j < distanceMatrix[0].length; j++) {
                distanceMatrix[i][j] = getDistanceValue(distanceMatrix[i][j - 1] + 1,
                        distanceMatrix[i - 1][j] + 1, distanceMatrix[i - 1][j - 1]
                                + getSwapValue(word1.charAt(i - 1), word2.charAt(j - 1)));
            }
        }

        return distanceMatrix[distanceMatrix.length - 1][distanceMatrix[0].length - 1];
    }

    private static int getDistanceValue(int insert, int delete, int swap) {
        return Math.min(Math.min(insert, delete), swap);
    }

    private static int getSwapValue(char first, char second) {
        return first == second ? 0 : 1;
    }
}
