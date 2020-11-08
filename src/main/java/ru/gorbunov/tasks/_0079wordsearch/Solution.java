package ru.gorbunov.tasks._0079wordsearch;

/**
 * Word Search
 * <p>
 * Given a 2D board and a word, find if the word exists in the grid.
 * The word can be constructed from letters of sequentially adjacent cells, where "adjacent" cells are horizontally or vertically neighboring. The same letter cell may not be used more than once.
 * Example 1:
 * Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
 * Output: true
 * Example 2:
 * Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "SEE"
 * Output: true
 * Example 3:
 * Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCB"
 * Output: false
 * Constraints:
 * board and word consists only of lowercase and uppercase English letters.
 * 1 <= board.length <= 200
 * 1 <= board[i].length <= 200
 * 1 <= word.length <= 10^3
 */
public class Solution {

    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (isWord(board, i, j, word, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean isWord(char[][] board, int row, int column, String word, int currentLetter) {
        if (currentLetter == word.length()) {
            return true;
        }
        if (row < 0 || row == board.length || column < 0 || column == board[0].length) {
            return false;
        }
        if (board[row][column] != word.charAt(currentLetter)) {
            return false;
        }
        char tmp = board[row][column];
        board[row][column] = '0'; // now visited

        boolean result = isWord(board, row + 1, column, word, currentLetter + 1)
                || isWord(board, row - 1, column, word, currentLetter + 1)
                || isWord(board, row, column + 1, word, currentLetter + 1)
                || isWord(board, row, column - 1, word, currentLetter + 1);

        board[row][column] = tmp; // not visited
        return result;
    }
}
