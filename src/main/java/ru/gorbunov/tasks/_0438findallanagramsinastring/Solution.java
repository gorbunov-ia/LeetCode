package ru.gorbunov.tasks._0438findallanagramsinastring;

import java.util.*;

/**
 * 438. Find All Anagrams in a String
 * <p>
 * Given two strings s and p, return an array of all the start indices of p's anagrams in s. You may return the answer
 * in any order. An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase,
 * typically using all the original letters exactly once.
 * Example 1:
 * Input: s = "cbaebabacd", p = "abc"
 * Output: [0,6]
 * Explanation:
 * The substring with start index = 0 is "cba", which is an anagram of "abc".
 * The substring with start index = 6 is "bac", which is an anagram of "abc".
 * Example 2:
 * Input: s = "abab", p = "ab"
 * Output: [0,1,2]
 * Explanation:
 * The substring with start index = 0 is "ab", which is an anagram of "ab".
 * The substring with start index = 1 is "ba", which is an anagram of "ab".
 * The substring with start index = 2 is "ab", which is an anagram of "ab".
 * Constraints:
 * 1 <= s.length, p.length <= 3 * 10^4
 * s and p consist of lowercase English letters.
 */
public class Solution {

    public List<Integer> findAnagrams(String s, String p) {
        if (p.length() > s.length()) {
            return Collections.emptyList();
        }
        List<Integer> indexes = new ArrayList<>();
        Map<Character, Integer> window = buildWindow(p);

        for (int i = 0; i < p.length(); i++) {
            char letter = s.charAt(i);
            Integer count = window.getOrDefault(letter, 0);
            count--;
            addIfNotZero(window, letter, count);
        }

        if (window.isEmpty()) {
            indexes.add(0);
        }

        for(int i = p.length(); i < s.length(); i++) {
            char newLetter = s.charAt(i);
            Integer newCount = window.getOrDefault(newLetter, 0);
            newCount--;
            addIfNotZero(window, newLetter, newCount);

            char firstLetter = s.charAt(i - p.length());
            Integer firstCount = window.getOrDefault(firstLetter, 0);
            firstCount++;
            addIfNotZero(window, firstLetter, firstCount);

            if (window.isEmpty()) {
                indexes.add(i - p.length() + 1);
            }
        }

        return indexes;
    }

    private Map<Character, Integer> buildWindow(String str) {
        Map<Character, Integer> map = new HashMap<>();
        for (Character c : str.toCharArray()) {
            map.merge(c, 1, Integer::sum);
        }
        return map;
    }

    private void addIfNotZero(Map<Character, Integer> window, Character letter, Integer count) {
        if (count != 0) {
            window.put(letter, count);
        } else {
            window.remove(letter);
        }
    }
}
