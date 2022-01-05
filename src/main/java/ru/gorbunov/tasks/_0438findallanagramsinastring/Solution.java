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
 *
 * @see ru.gorbunov.tasks._0567permutationinstring.Solution
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
            putIfNotZero(window, letter, count);
        }

        if (window.isEmpty()) {
            indexes.add(0);
        }

        for (int i = p.length(); i < s.length(); i++) {
            char newLetter = s.charAt(i);
            Integer newCount = window.getOrDefault(newLetter, 0);
            newCount--;
            putIfNotZero(window, newLetter, newCount);

            char firstLetter = s.charAt(i - p.length());
            Integer firstCount = window.getOrDefault(firstLetter, 0);
            firstCount++;
            putIfNotZero(window, firstLetter, firstCount);

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

    private void putIfNotZero(Map<Character, Integer> window, Character letter, Integer count) {
        if (count != 0) {
            window.put(letter, count);
        } else {
            window.remove(letter);
        }
    }

    public List<Integer> equalFindAnagrams(String s, String p) {
        List<Integer> result = new LinkedList<>();
        if (p.length() > s.length()) return result;
        Map<Character, Integer> map = new HashMap<>();
        for (char c : p.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        int counter = map.size();

        int begin = 0, end = 0;

        while (end < s.length()) {
            char c = s.charAt(end);
            if (map.containsKey(c)) {
                map.put(c, map.get(c) - 1);
                if (map.get(c) == 0) counter--;
            }
            end++;

            while (counter == 0) {
                char tempc = s.charAt(begin);
                if (map.containsKey(tempc)) {
                    map.put(tempc, map.get(tempc) + 1);
                    if (map.get(tempc) > 0) {
                        counter++;
                    }
                }
                if (end - begin == p.length()) {
                    result.add(begin);
                }
                begin++;
            }

        }
        return result;
    }
}
