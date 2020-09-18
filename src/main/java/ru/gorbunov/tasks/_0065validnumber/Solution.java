package ru.gorbunov.tasks._0065validnumber;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.regex.Pattern;

/**
 * Valid Number
 * <p>
 * Validate if a given string can be interpreted as a decimal number.
 * Some examples:
 * "0" => true
 * " 0.1 " => true
 * "abc" => false
 * "1 a" => false
 * "2e10" => true
 * " -90e3   " => true
 * " 1e" => false
 * "e3" => false
 * " 6e-1" => true
 * " 99e2.5 " => false
 * "53.5e93" => true
 * " --6 " => false
 * "-+3" => false
 * "95a54e53" => false
 * Note: It is intended for the problem statement to be ambiguous. You should gather all requirements up front before
 * implementing one. However, here is a list of characters that can be in a valid decimal number:
 * Numbers 0-9
 * Exponent - "e"
 * Positive/negative sign - "+"/"-"
 * Decimal point - "."
 * Of course, the context of these characters also matters in the input.
 */
public class Solution {

    public boolean isNumber(String s) {
        s = Objects.requireNonNull(s, "String should not be null").trim();
        if (s.length() == 0) {
            return false;
        }
        boolean point = false;
        boolean e = false;
        int eInd = -1;
        for (int i = 0; i < s.length(); i++) {
            final char ch = s.charAt(i);
            if (ch == '+') {
                if (i == 0 && isNotLast(s, i) || eInd == i - 1 && isNotLast(s, i)) {
                    continue;
                }
                return false;
            }
            if (ch == '-') {
                if (i == 0 && isNotLast(s, i) || eInd == i - 1 && isNotLast(s, i)) {
                    continue;
                }
                return false;
            }
            if (ch == '.') {
                if (!point && !e && (i > 0 && isDigit(s.charAt(i - 1)) || isNotLast(s, i) && isDigit(s.charAt(i + 1)))) {
                    point = true;
                    continue;
                }
                return false;
            }
            if (ch == 'e') {
                if (!e && (i > 0 && (isDigit(s.charAt(i - 1)) || s.charAt(i - 1) == '.')) && isNotLast(s, i)) {
                    e = true;
                    eInd = i;
                    continue;
                }
                return false;
            }
            if (!isDigit(ch)) {
                return false;
            }
        }

        return true;
    }

    private boolean isDigit(char c) {
        return (c >= '0') && (c <= '9');
    }

    private boolean isNotLast(String s, int i) {
        return i < s.length() - 1;
    }

    /**
     * With DFA (Deterministic finite automaton)
     */
    boolean dfaIsNumber(String s) {
        Map<Integer, Map<Character, Integer>> state = buildStateMap();

        s = s.trim();
        int curState = 0;
        for (char c : s.toCharArray()) {
            if (isDigit(c)) {
                curState = state.get(curState).getOrDefault('d', -1);
            } else {
                curState = state.get(curState).getOrDefault(c, -1);
            }
            if (curState == -1) {
                return false;
            }
        }
        return (curState == 2 || curState == 3 || curState == 5 || curState == 7);
    }

    private Map<Integer, Map<Character, Integer>> buildStateMap() {
        Map<Integer, Map<Character, Integer>> state = new HashMap<>();

        state.put(0, new HashMap<>());
        state.get(0).put('-', 1);
        state.get(0).put('+', 1);
        state.get(0).put('d', 2);
        state.get(0).put('.', 8);

        state.put(1, new HashMap<>());
        state.get(1).put('d', 2);
        state.get(1).put('.', 8);

        state.put(2, new HashMap<>());
        state.get(2).put('d', 2);
        state.get(2).put('.', 3);
        state.get(2).put('e', 4);

        state.put(3, new HashMap<>());
        state.get(3).put('d', 5);
        state.get(3).put('e', 4);

        state.put(4, new HashMap<>());
        state.get(4).put('d', 7);
        state.get(4).put('+', 6);
        state.get(4).put('-', 6);

        state.put(5, new HashMap<>());
        state.get(5).put('d', 5);
        state.get(5).put('e', 4);

        state.put(6, new HashMap<>());
        state.get(6).put('d', 7);

        state.put(7, new HashMap<>());
        state.get(7).put('d', 7);

        state.put(8, new HashMap<>());
        state.get(8).put('d', 5);
        return state;
    }

    /**
     * With regEx
     */
    boolean regExIsNumber(String s) {
        return Pattern.matches("\\s*(\\+|-)?(\\d+(\\.\\d*)?|\\.\\d+)(e(\\+|-)?\\d+)?\\s*", s);
    }

    /**
     * Case without 'e' character
     */
    boolean rawIsNumber(String s) {
        if (s == null) {
            throw new NullPointerException();
        }
        s = s.trim();
        if (s.length() == 0) {
            return false;
        }
        char first = s.charAt(0);
        if (!((first == '-' || first == '+') && s.length() > 1 || isDigit(first))) {
            return false;
        }
        boolean point = false;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == '.') {
                if (!point) {
                    point = true;
                } else {
                    return false;
                }
            }
            if (!isDigit(s.charAt(i))) {
                return false;
            }
        }

        return true;
    }

}
