package ru.gorbunov.tasks._0022generateparentheses;

import java.util.ArrayList;
import java.util.List;

/**
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 */
public class Solution {

    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>(n);
        generate(result, "", 0, 0, n);
        return result;
    }

    private void generate(List<String> accumulator, String current,
                          int numberOfOpenedBrackets, int numberOfClosedBrackets, int n) {
        if (current.length() == 2 * n) {
            accumulator.add(current);
            return;
        }
        if (numberOfOpenedBrackets < n) {
            generate(accumulator, current + "(", numberOfOpenedBrackets + 1, numberOfClosedBrackets, n);
        }
        if (numberOfOpenedBrackets > numberOfClosedBrackets) {
            generate(accumulator, current + ")", numberOfOpenedBrackets, numberOfClosedBrackets + 1, n);
        }
    }
}
