package ru.gorbunov.tasks._0003longestsubstring;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Longest Substring Without Repeating Characters.
 * <p>
 * Given a string, find the length of the longest substring without repeating characters.
 * Example 1:
 * Input: "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 * <p>
 * Example 2:
 * Input: "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 * <p>
 * Example 3:
 * Input: "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3.
 * <p>
 * Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 */
public class Solution {

    public int lengthOfLongestSubstring(String s) {
        if (s == null) {
            throw new NullPointerException("String should not be null");
        }
        int maxLength = 0;
        for (int i = 0; i < s.length(); i++) {
            Set<Character> letters = new HashSet<>();
            for (int j = i; j < s.length(); j++) {
                Character letter = s.charAt(j);
                if (letters.contains(letter)) {
                    break;
                }
                letters.add(letter);
            }
            if (letters.size() > maxLength) {
                maxLength = letters.size();
            }
        }
        return maxLength;
    }

    /**
     * We use HashSet to store the characters in current window [i,j) (j=i initially). Then we slide the index j to
     * the right. If it is not in the HashSet, we slide j further. Doing so until s[j] is already in the HashSet.
     * At this point, we found the maximum size of substrings without duplicate characters start with index i.
     * If we do this for all i, we get our answer.
     * <p>
     * If s[j]s[j]s[j] have a duplicate in the range [i,j) with index j′,
     * we don't need to increase i little by little. We can skip all the elements in the range [i,j′]
     * and let i to be j′+1 directly.
     */
    public int fastLengthOfLongestSubstring(String s) {
        int n = s.length(), ans = 0;
        Map<Character, Integer> map = new HashMap<>(); // current index of character
        // try to extend the range [i, j]
        for (int j = 0, i = 0; j < n; j++) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(map.get(s.charAt(j)), i);
            }
            ans = Math.max(ans, j - i + 1);
            map.put(s.charAt(j), j + 1);
        }
        return ans;
    }
}
