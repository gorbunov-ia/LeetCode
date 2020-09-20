package ru.gorbunov.tasks._0049groupanagrams;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Group Anagrams
 * <p>
 * Given an array of strings strs, group the anagrams together. You can return the answer in any order.
 * An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.
 * Example 1:
 * Input: strs = ["eat","tea","tan","ate","nat","bat"]
 * Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
 * Example 2:
 * Input: strs = [""]
 * Output: [[""]]
 * Example 3:
 * Input: strs = ["a"]
 * Output: [["a"]]
 * Constraints:
 * 1 <= strs.length <= 104
 * 0 <= strs[i].length <= 100
 * strs[i] consists of lower-case English letters.
 */
public class Solution {

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<List<Character>, List<String>> map = new HashMap<>();

        for (String str : strs) {
            List<Character> letters = toLetters(str);
            List<String> l = map.computeIfAbsent(letters, k -> new LinkedList<>());
            l.add(str);
        }

        return new ArrayList<>(map.values());
    }

    private List<Character> toLetters(String str) {
        List<Character> s = new ArrayList<>(str.length());
        for (int i = 0; i < str.length(); i++) {
            s.add(str.charAt(i));
        }
        Collections.sort(s);
        return s;
    }

    public List<List<String>> fastGroupAnagrams(String[] strs) {
        if (strs.length == 0) {
            return Collections.emptyList();
        }
        Map<List<Integer>, List<String>> ans = new HashMap<>();
        for (String s : strs) {
            List<Integer> letters = newList();

            for (char c : s.toCharArray()) {
                letters.set(c - 'a', letters.get(c - 'a') + 1);
            }

            List<String> list = ans.computeIfAbsent(letters, k -> new LinkedList<>());
            list.add(s);
        }
        return new ArrayList<>(ans.values());
    }

    private List<Integer> newList() {
        List<Integer> list = new ArrayList<>(26);
        for (int i = 0; i < 26; i++) {
            list.add(0);
        }
        return list;
    }

}
