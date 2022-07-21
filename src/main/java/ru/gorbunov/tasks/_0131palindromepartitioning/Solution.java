package ru.gorbunov.tasks._0131palindromepartitioning;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * 131. Palindrome Partitioning
 * <p>
 * Given a string s, partition s such that every substring of the partition is a palindrome. Return all possible
 * palindrome partitioning of s.
 * A palindrome string is a string that reads the same backward as forward.
 * Example 1:
 * Input: s = "aab"
 * Output: [["a","a","b"],["aa","b"]]
 * Example 2:
 * Input: s = "a"
 * Output: [["a"]]
 * Constraints:
 * 1 <= s.length <= 16
 * s contains only lowercase English letters.
 */
public class Solution {

    public List<List<String>> partition(String s) {
        List<List<List<String>>> dp = new ArrayList<>(s.length() + 1);
        dp.add(0, List.of(Collections.emptyList()));

        for (int size = 1; size <= s.length(); size++) {
            List<List<String>> current = new ArrayList<>();
            for (int start = size - 1; start >= 0; start--) {
                String letters = s.substring(start, size);
                if (isPalindrome(letters)) {
                    List<List<String>> leftPalindromes = dp.get(start);
                    current.addAll(merge(leftPalindromes, letters));
                }
            }
            dp.add(size, current);
        }

        return dp.get(s.length());
    }

    private Collection<? extends List<String>> merge(List<List<String>> lists, String item) {
        List<List<String>> result = new ArrayList<>(lists.size());
        for (List<String> list : lists) {
            List<String> copy = new ArrayList<>(list);
            copy.add(item);
            result.add(copy);
        }
        return result;
    }

    private boolean isPalindrome(String word) {
        for (int i = 0; i < word.length() / 2; i++) {
            if (word.charAt(i) != word.charAt(word.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }

    public List<List<String>> spacePartition(String s) {
        int len = s.length();
        boolean[][] dp = new boolean[len][len];
        List<List<String>> result = new ArrayList<>();
        dfs(result, s, 0, new ArrayList<>(), dp);
        return result;
    }

    void dfs(List<List<String>> result, String s, int start, List<String> currentList, boolean[][] dp) {
        if (start >= s.length()) {
            result.add(new ArrayList<>(currentList));
        }
        for (int end = start; end < s.length(); end++) {
            if (s.charAt(start) == s.charAt(end) && (end - start <= 2 || dp[start + 1][end - 1])) {
                dp[start][end] = true;
                currentList.add(s.substring(start, end + 1));
                dfs(result, s, end + 1, currentList, dp);
                currentList.remove(currentList.size() - 1);
            }
        }
    }
}
