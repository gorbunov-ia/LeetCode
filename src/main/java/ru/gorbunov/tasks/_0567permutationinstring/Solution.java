package ru.gorbunov.tasks._0567permutationinstring;

import java.util.HashMap;
import java.util.Map;
/**
 * 567. Permutation in String
 * <p>
 * Given two strings s1 and s2, return true if s2 contains a permutation of s1, or false otherwise.
 * In other words, return true if one of s1's permutations is the substring of s2.
 * Example 1:
 * Input: s1 = "ab", s2 = "eidbaooo"
 * Output: true
 * Explanation: s2 contains one permutation of s1 ("ba").
 * Example 2:
 * Input: s1 = "ab", s2 = "eidboaoo"
 * Output: false
 * Constraints:
 * 1 <= s1.length, s2.length <= 104
 * s1 and s2 consist of lowercase English letters.
 */
public class Solution {

    public boolean checkInclusion(String s1, String s2) {
        Map<Character, Integer> window = buildWindow(s1);

        for (int i = 0; i < s1.length(); i++) {
            char c = s2.charAt(i);
            int count = window.getOrDefault(c, 0);
            window.put(c, count - 1);
            shrink(window, c);
        }

        int limit = s2.length() - s1.length();
        for (int i = 0; i < limit; i++) {
            if (window.isEmpty()) {
                return true;
            }
            // modify window
            char firstCh = s2.charAt(i);
            int first = window.getOrDefault(firstCh, 0);
            window.put(firstCh, first + 1);
            shrink(window, firstCh);

            char lastCh = s2.charAt(i + s1.length());
            int last = window.getOrDefault(lastCh, 0);
            window.put(lastCh, last - 1);
            shrink(window, lastCh);
        }

        return window.isEmpty();
    }

    private Map<Character, Integer> buildWindow(String str) {
        Map<Character, Integer> map = new HashMap<>();

        for (char c : str.toCharArray()) {
            int count = map.getOrDefault(c, 0);
            map.put(c, count + 1);
        }

        return map;
    }

    private void shrink(Map<Character, Integer> window, char ch) {
        Integer count = window.get(ch);
        if (count != null && count == 0) {
            window.remove(ch);
        }
    }
}
