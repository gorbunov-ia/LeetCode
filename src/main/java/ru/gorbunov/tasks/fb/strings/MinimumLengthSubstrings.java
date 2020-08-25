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
        Map<Character, Integer> sMap = createMap(s);
        Map<Character, Integer> tMap = createMap(t);

        // does S have all letters from T?
        for (Map.Entry<Character, Integer> entry : tMap.entrySet()) {
            Integer numberOfLettersInS = sMap.get(entry.getKey());
            if (numberOfLettersInS == null || numberOfLettersInS < entry.getValue()) {
                return -1;
            }
        }

        // detect min length of substring
        int start = 0;
        int end = s.length() - 1;
        for (; start < s.length(); start++) {
            Integer tNumber = tMap.get(s.charAt(start));
            if (tNumber != null) {
                Integer sNumber = sMap.get(s.charAt(start));
                if (sNumber > tNumber) {
                    sMap.put(s.charAt(start), sNumber - 1);
                } else {
                    break;
                }
            }
        }

        for (; end > start; end--) {
            Integer tNumber = tMap.get(s.charAt(end));
            if (tNumber != null) {
                Integer sNumber = sMap.get(s.charAt(end));
                if (sNumber > tNumber) {
                    sMap.put(s.charAt(end), sNumber - 1);
                } else {
                    break;
                }
            }
        }

        return end - start + 1;
    }
}
