package ru.gorbunov.tasks._0067addbinary;

/**
 * 67. Add Binary
 * <p>
 * Given two binary strings, return their sum (also a binary string).
 * The input strings are both non-empty and contains only characters 1 or 0.
 * Example 1:
 * Input: a = "11", b = "1"
 * Output: "100"
 * Example 2:
 * Input: a = "1010", b = "1011"
 * Output: "10101"
 * Constraints:
 * Each string consists only of '0' or '1' characters.
 * 1 <= a.length, b.length <= 10^4
 * Each string is either "0" or doesn't contain any leading zero.
 */
public class Solution {

    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int i = a.length() - 1;
        int j = b.length() - 1;
        int carry = 0;
        while (i >= 0 || j >= 0) {
            int sum = carry;
            if (j >= 0) {
                sum += b.charAt(j--) - '0';
            }
            if (i >= 0) {
                sum += a.charAt(i--) - '0';
            }
            sb.append(sum % 2);
            carry = sum / 2;
        }
        if (carry != 0) {
            sb.append(carry);
        }
        return sb.reverse().toString();
    }

    public String sum(String first, String second) {
        if (isNotValid(first) || isNotValid(second)) {
            throw new IllegalArgumentException();
        }

        StringBuilder result = new StringBuilder();

        boolean bit = false;
        int length = Math.max(first.length(), second.length());
        for (int i = 0; i < length; i++) {

            if (getCharBit(first, i) == '0' && getCharBit(second, i) == '0') {
                if (bit) {
                    result.append('1');
                    bit = false;
                } else {
                    result.append('0');
                }
                continue;
            }
            if (getCharBit(first, i) == '1' && getCharBit(second, i) == '1') {
                if (!bit) {
                    result.append('0');
                    bit = true;
                } else {
                    result.append('1');
                }
                continue;
            }
            if (bit) {
                result.append('0');
            } else {
                result.append('1');
            }
        }

        if (bit) {
            result.append('1');
        }

        // reverse result
        return result.reverse().toString();
    }

    private boolean isNotValid(String s) {
        return s == null || s.length() < 1;
    }

    private char getCharBit(String s, int i) {
        if (i > s.length() - 1) {
            return '0';
        } else {
            return s.charAt(s.length() - 1 - i);
        }
    }

}
