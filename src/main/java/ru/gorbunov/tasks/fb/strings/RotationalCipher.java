package ru.gorbunov.tasks.fb.strings;

/**
 * Rotational Cipher
 * <p>
 * One simple way to encrypt a string is to "rotate" every alphanumeric character by a certain amount. Rotating a
 * character means replacing it with another character that is a certain number of steps away in normal alphabetic
 * or numerical order.
 * For example, if the string "Zebra-493?" is rotated 3 places, the resulting string is "Cheud-726?". Every alphabetic
 * character is replaced with the character 3 letters higher (wrapping around from Z to A), and every numeric character
 * replaced with the character 3 digits higher (wrapping around from 9 to 0). Note that the non-alphanumeric characters
 * remain unchanged.
 * Given a string and a rotation factor, return an encrypted string.
 * Signature
 * string rotationalCipher(string input, int rotationFactor)
 * Input
 * 1 <= |input| <= 1,000,000
 * 0 <= rotationFactor <= 1,000,000
 * Output
 * Return the result of rotating input a number of times equal to rotationFactor.
 * Example 1
 * input = Zebra-493?
 * rotationFactor = 3
 * output = Cheud-726?
 * Example 2
 * input = abcdefghijklmNOPQRSTUVWXYZ0123456789
 * rotationFactor = 39
 * output = nopqrstuvwxyzABCDEFGHIJKLM9012345678
 */
public class RotationalCipher {

    public static void main(String[] args) {
        String input = "Zebra-493";
        System.out.println(new RotationalCipher().rotationalCipher(input, 3));
    }

    String rotationalCipher(String input, int rotationFactor) {

        int lettersFactor = rotationFactor % 26;
        int digitsFactor = rotationFactor % 10;
        // Write your code here
        StringBuilder resultBuilder = new StringBuilder(input.length());

        for (char ch : input.toCharArray()) {
            if ('0' <= ch && ch <= '9') {
                resultBuilder.append(((ch - '0') + digitsFactor) % 10);
            } else if ('a' <= ch && ch <= 'z') {
                resultBuilder.append(encryptLetter(ch, lettersFactor, 'a'));
            } else if ('A' <= ch && ch <= 'Z') {
                resultBuilder.append(encryptLetter(ch, lettersFactor, 'A'));
            } else {
                resultBuilder.append(ch);
            }

        }

        return resultBuilder.toString();
    }

    private char encryptLetter(char target, int distance, char startChar) {
        return (char) ((((target - startChar) + distance) % 26) + startChar);
    }

}
