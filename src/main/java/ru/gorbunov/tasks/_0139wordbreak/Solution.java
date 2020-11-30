package ru.gorbunov.tasks._0139wordbreak;

import java.util.List;

/**
 * Word Break
 * <p>
 * Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, determine if s can be segmented into a space-separated sequence of one or more dictionary words.
 * Note:
 * The same word in the dictionary may be reused multiple times in the segmentation.
 * You may assume the dictionary does not contain duplicate words.
 * Example 1:
 * Input: s = "leetcode", wordDict = ["leet", "code"]
 * Output: true
 * Explanation: Return true because "leetcode" can be segmented as "leet code".
 * Example 2:
 * Input: s = "applepenapple", wordDict = ["apple", "pen"]
 * Output: true
 * Explanation: Return true because "applepenapple" can be segmented as "apple pen apple".
 * Note that you are allowed to reuse a dictionary word.
 * Example 3:
 * Input: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
 * Output: false
 */
public class Solution {

    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;

        for(int i = 1; i <= s.length(); i++) {
            for (String w : wordDict) {
                if (w.length() <= i && dp[i - w.length()] && s.substring(i - w.length(), i).equals(w)) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[s.length()];
    }

    public boolean slowWordBreak(String s, List<String> wordDict) {
        return backtrack(s, 0, wordDict);
    }

    private boolean backtrack(String s, int start, List<String> wordDict) {
        if (start >= s.length()) {
            return start == s.length();
        }
        for (String word : wordDict) {
            int end = start + word.length();
            if (end <= s.length() && s.substring(start, end).equals(word) && backtrack(s, end, wordDict)) {
                return true;
            }
        }
        return false;
    }
}
