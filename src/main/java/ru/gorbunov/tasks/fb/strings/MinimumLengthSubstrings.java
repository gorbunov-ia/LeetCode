package ru.gorbunov.tasks.fb.strings;

import java.util.HashMap;
import java.util.Map;

/**
 * Minimum Length Substrings
 * <p>
 * You are given two strings s and t. You can select any substring of string s and rearrange the characters of the
 * selected substring. Determine the minimum length of the substring of s such that string t is a substring of the
 * selected substring.
 * Signature
 * int minLengthSubstring(String s, String t)
 * Input
 * s and t are non-empty strings that contain less than 1,000,000 characters each
 * Output
 * Return the minimum length of the substring of s. If it is not possible, return -1
 * Example
 * s = "dcbefebce"
 * t = "fd"'
 * output = 5
 * Explanation:
 * Substring "dcbef" can be rearranged to "cfdeb", "cefdb", and so on. String t is a substring of "cfdeb". Thus, the
 * minimum length required is 5.
 *
 * @see ru.gorbunov.tasks._0076minimumwindowsubstring.Solution#minWindow
 */
public class MinimumLengthSubstrings {

    // Add any helper functions you may need here
    private Map<Character, Integer> createMap(String str) {
        Map<Character, Integer> sMap = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            sMap.merge(str.charAt(i), 1, Integer::sum);
        }
        return sMap;
    }

    int minLengthSubstring(String s, String t) {
        // Write your code here
        Map<Character, Integer> tMap = createMap(t);
        Map<Character, Integer> currentWindow = new HashMap<>();

        // size, left index, right index
        int[] ans = {-1, 0, 0};
        int required = tMap.size();
        int currentLetters = 0;
        int left = 0;
        int right = 0;

        while (right < s.length()) {

            char ch = s.charAt(right);
            Integer chNumber = currentWindow.getOrDefault(ch, 0);
            currentWindow.put(ch, chNumber + 1);

            if (tMap.containsKey(ch) && tMap.get(ch).equals(currentWindow.get(ch))) {
                currentLetters++;
            }

            while (left <= right && required == currentLetters) {

                if (ans[0] == -1 || right - left + 1 < ans[0]) {
                    ans[0] = right - left + 1;
                    ans[1] = left;
                    ans[2] = right;
                }

                char lch = s.charAt(left);
                Integer lNumber = currentWindow.get(lch);
                currentWindow.put(lch, lNumber - 1);

                if (tMap.containsKey(lch) && tMap.get(lch) > currentWindow.get(lch)) {
                    currentLetters--;
                }

                left++;
            }

            right++;
        }

        return ans[0] == -1 ? -1 : ans[2] - ans[1] + 1;
    }
}
