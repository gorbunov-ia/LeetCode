package ru.gorbunov.tasks.fb.strings;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Matching Pairs
 * <p>
 * Given two strings s and t of length N, find the maximum number of possible matching pairs in strings s and t after
 * swapping exactly two characters within s. A swap is switching s[i] and s[j], where s[i] and s[j] denotes the
 * character that is present at the ith and jth index of s, respectively. The matching pairs of the two strings are
 * defined as the number of indices for which s[i] and t[i] are equal.
 * Note: This means you must swap two characters at different indices.
 * Signature
 * int matchingPairs(String s, String t)
 * Input
 * <p>
 * s and t are strings of length N
 * N is between 2 and 1,000,000
 * <p>
 * Output
 * Return an integer denoting the maximum number of matching pairs
 * Example 1
 * s = "abcd"
 * t = "adcb"
 * output = 4
 * Explanation:
 * Using 0-based indexing, and with i = 1 and j = 3, s[1] and s[3] can be swapped, making it  "adcb".
 * Therefore, the number of matching pairs of s and t will be 4.
 * Example 2
 * s = "mno"
 * t = "mno"
 * output = 1
 * Explanation:
 * Two indices have to be swapped, regardless of which two it is, only one letter will remain the same. If i = 0
 * and j=1, s[0] and s[1] are swapped, making s = "nmo", which shares only "o" with t.
 */
public class MatchingPairs {

    //    int matchingPairs(String s, String t) {
    int firstMatchingPairs(String s, String t) {
        // Write your code here
        int left = 0;
        int right = s.length() - 1;

        boolean two = false;
        boolean one = false;

        int pairs = 0;
        while (left <= right) {
            if (s.charAt(left) == t.charAt(left)) {
                pairs++;
                left++;
            } else if (s.charAt(right) == t.charAt(right)) {
                pairs++;
                right--;
            } else if (left != right) {
                if (s.charAt(left) == t.charAt(right) && t.charAt(left) == s.charAt(right)) {
                    two = true;
                    left++;
                    right--;
                } else if (s.charAt(left) == t.charAt(right)) {
                    one = true;
                    right--;
                } else if (t.charAt(left) == s.charAt(right)) {
                    one = true;
                    left++;
                }
            }
        }

        if (pairs == s.length()) {
            return s.length() - 2;
        }

        if (two) {
            return pairs + 2;
        }
        if (one) {
            return pairs + 1;
        }
        return pairs;
    }

    int matchingPairs(String s, String t) {
        Map<Character, Set<Character>> charMap = new HashMap<>();
        Set<Character> visitedChars = new HashSet<>();

        boolean hasDoubleLetter = false;
        int pairs = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == t.charAt(i)) {
                pairs++;
                if (!hasDoubleLetter) { // see MatchingPairsTest#example4
                    if (visitedChars.contains(s.charAt(i))) {
                        hasDoubleLetter = true;
                        visitedChars.clear();
                    } else {
                        visitedChars.add(s.charAt(i));
                    }
                }
            } else {
                Set<Character> tLetters = charMap.computeIfAbsent(s.charAt(i), k -> new HashSet<>());
                tLetters.add(t.charAt(i));
            }
        }

        if (charMap.size() <= 1) {
            return hasDoubleLetter ? pairs : pairs - 2 + charMap.size();
        }

        boolean hasMatch = false;
        for (Map.Entry<Character, Set<Character>> entry : charMap.entrySet()) {
            Character sLetter = entry.getKey();
            for (Character tLetter : entry.getValue()) {
                Set<Character> tLetterInS = charMap.get(tLetter);
                if (tLetterInS != null) {
                    hasMatch = true; // swap and fix one pair
                    if (tLetterInS.contains(sLetter)) {
                        return pairs + 2; // best swap, fix two pairs
                    }
                }
            }
        }

        return hasMatch ? pairs + 1 : pairs;
    }
}
