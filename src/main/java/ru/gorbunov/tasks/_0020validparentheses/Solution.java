package ru.gorbunov.tasks._0020validparentheses;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Map;

/**
 * Valid Parentheses
 * <p>
 * Given a string containing just the characters '(',')','{','}','[' and ']', determine if the input string is valid.
 * An input string is valid if:
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 * Note that an empty string is also considered valid.
 */
public class Solution {

    private static final Map<Character, Character> BRACKETS = Map.of('(', ')', '{', '}', '[', ']');

    public boolean isValid(String s) {
        Deque<Character> stack = new LinkedList<>();

        for (char ch : s.toCharArray()) {
            Character bracket = ch;
            if (BRACKETS.containsKey(bracket)) {
                stack.push(bracket);
            } else {
                final Character lastOpened = stack.peek();
                if (lastOpened == null || !bracket.equals(BRACKETS.get(lastOpened))) {
                    return false;
                }
                stack.pop();
            }
        }

        return stack.isEmpty();
    }
}