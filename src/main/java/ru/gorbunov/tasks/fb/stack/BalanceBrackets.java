package ru.gorbunov.tasks.fb.stack;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * Balance Brackets
 * <p>
 * A bracket is considered to be any one of the following characters: (, ), {, }, [, or ].
 * We consider two brackets to be matching if the first element is an open-bracket, e.g., (, {, or [, and the second
 * bracket is a close-bracket of the same type, e.g., ( and ), [ and ], and { and } are the only pairs of matching
 * brackets.
 * Furthermore, a sequence of brackets is said to be balanced if the following conditions are met:
 * The sequence is empty, or
 * The sequence is composed of two, non-empty, sequences both of which are balanced, or
 * The first and last brackets of the sequence are matching, and the portion of the sequence without the first and
 * last elements is balanced.
 * You are given a string of brackets. Your task is to determine whether each sequence of brackets is balanced.
 * If a string is balanced, return true, otherwise, return false
 * Signature
 * bool isBalanced(String s)
 * Input
 * String s with length between 1 and 1000
 * Output
 * A boolean representing if the string is balanced or not
 * Example 1
 * s = {[()]}
 * output: true
 * Example 2
 * s = {}()
 * output: true
 * Example 3
 * s = {(})
 * output: false
 * Example 4
 * s = )
 * output: false
 *
 * @see ru.gorbunov.tasks._0020validparentheses.Solution#isValid(String)
 */
public class BalanceBrackets {
    // Add any helper functions you may need here
    private final static Map<Character, Character> BRACKETS;

    static {
        BRACKETS = new HashMap<>();
        BRACKETS.put('(', ')');
        BRACKETS.put('{', '}');
        BRACKETS.put('[', ']');
    }

    boolean isBalanced(String s) {
        // Write your code here
        Deque<Character> stack = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            if (BRACKETS.containsKey(c)) {
                stack.push(c);
            } else {
                Character openedBracket = stack.peek();
                if (openedBracket == null || !BRACKETS.get(openedBracket).equals(c)) {
                    return false;
                }
                stack.pop();
            }
        }
        return stack.isEmpty();
    }
}