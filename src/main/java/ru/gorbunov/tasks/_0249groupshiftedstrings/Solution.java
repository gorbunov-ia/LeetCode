package ru.gorbunov.tasks._0249groupshiftedstrings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 249. Group Shifted Strings
 * <p>
 * Given a string, we can "shift" each of its letter to its successive letter, for example: "abc" -> "bcd".
 * We can keep "shifting" which forms the sequence: "abc" -> "bcd" -> ... -> "xyz"
 * Given a list of strings which contains only lowercase alphabets, group all strings that belong to the same
 * shifting sequence.
 * For example, given: ["abc", "bcd", "acef", "xyz", "az", "ba", "a", "z"], Return:
 * [
 * ["abc","bcd","xyz"],
 * ["az","ba"],
 * ["acef"],
 * ["a","z"]
 * ]
 */
public class Solution {

    private static final int ALPHABET_SIZE = 26;
    private static final char FIRST_LETTER = 'a';

    public List<List<String>> groupStrings(String[] strings) {
        Map<String, Integer> map = new HashMap<>();
        for (String word : strings) {
            map.merge(word, -1, Integer::sum);
        }

        List<List<String>> result = new ArrayList<>();
        int group = 0;
        for (String word : strings) {
            if (map.get(word) >= 0) {
                continue;
            }
            List<String> groupList = initGroup(word, map.get(word) * -1);
            map.put(word, group);

            String last = word;
            for (int shift = 1; shift < ALPHABET_SIZE; shift++) {
                String newWord = shift(last);
                if (map.containsKey(newWord)) {
                    map.put(newWord, group);
                    groupList.add(newWord);
                }
                last = newWord;
            }
            group++;
            result.add(groupList);
        }

        return result;
    }

    private String shift(String word) {
        StringBuilder sb = new StringBuilder(word.length());
        for (char letter : word.toCharArray()) {
            int newCode = letter - FIRST_LETTER + 1;
            sb.append((char) (newCode % ALPHABET_SIZE + FIRST_LETTER));
        }
        return sb.toString();
    }

    private List<String> initGroup(String word, int repeat) {
        List<String> groupList = new ArrayList<>();
        while (repeat > 0) {
            groupList.add(word);
            repeat--;
        }
        return groupList;
    }

}
