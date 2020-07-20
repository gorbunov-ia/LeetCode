package ru.gorbunov.tasks._0017lettercombinations;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.util.Arrays.asList;

/**
 * Letter Combinations of a Phone Number
 * <p>
 * Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could
 * represent. A mapping of digit to letters (just like on the telephone buttons) is given below.
 * Note that 1 does not map to any letters.
 * <p>
 * Example:
 * Input: "23"
 * Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 * Note: Although the above answer is in lexicographical order, your answer could be in any order you want.
 */
public class Solution {

    private final Map<Integer, List<Character>> dictionary;
    {
        dictionary = new HashMap<>();
        dictionary.put(2, asList('a', 'b', 'c'));
        dictionary.put(3, asList('d', 'e', 'f'));
        dictionary.put(4, asList('g', 'h', 'i'));
        dictionary.put(5, asList('j', 'k', 'l'));
        dictionary.put(6, asList('m', 'n', 'o'));
        dictionary.put(7, asList('p', 'q', 'r', 's'));
        dictionary.put(8, asList('t', 'u', 'v'));
        dictionary.put(9, asList('w', 'x', 'y', 'z'));
    }

    public List<String> letterCombinations(String digits) {
        int[] ints = digits.chars()
                .map(Character::getNumericValue)
                .toArray();

        List<String> result = new ArrayList<>();
        accumulator(ints, 0, "", result);

        return result;
    }

    private void accumulator(int[] digits, Integer index, String prefix, List<String> result) {
        if (index >= digits.length) {
            if (prefix.length() > 0) {
                result.add(prefix);
            }
            return;
        }
        for (Character letter : dictionary.get(digits[index])) {
            accumulator(digits, index + 1, prefix + letter, result);
        }
    }
}
