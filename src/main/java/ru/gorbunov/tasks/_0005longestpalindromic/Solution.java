package ru.gorbunov.tasks._0005longestpalindromic;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Longest Palindromic Substring
 * <p>
 * Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.
 * <p>
 * Example 1:
 * Input: "babad"
 * Output: "bab"
 * Note: "aba" is also a valid answer.
 * <p>
 * Example 2:
 * Input: "cbbd"
 * Output: "bb"
 */
public class Solution {

    public String longestPalindrome(String s) {
        Map<Character, List<Integer>> letterIndexesMap = new HashMap<>();
        String result = "";
        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            if (!letterIndexesMap.containsKey(c)) {
                List<Integer> indexes = new LinkedList<>();
                indexes.add(i);
                letterIndexesMap.put(c, indexes);
                if (result.length() < 1) {
                    result = c.toString();
                }
            } else {
                List<Integer> indexes = letterIndexesMap.get(c);
                for (Integer index : indexes) {
                    String candidate = s.substring(index, i + 1);
                    if (candidate.length() > result.length() && isPalindrome(candidate)) {
                        result = candidate;
                        break;
                    }
                }
                indexes.add(i);
            }
        }
        return result;
    }

    private boolean isPalindrome(String str) {
        for (int i = 0; i < str.length() / 2; i++) {
            if (str.charAt(i) != str.charAt(str.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }
}
