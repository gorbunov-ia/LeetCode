package ru.gorbunov.tasks._0208implementtrie;

import java.util.Objects;

/**
 * 208. Implement Trie (Prefix Tree)
 * <p>
 * A trie (pronounced as "try") or prefix tree is a tree data structure used to efficiently store and retrieve keys in
 * a dataset of strings. There are various applications of this data structure, such as autocomplete and spellchecker.
 * Implement the Trie class:
 * Trie() Initializes the trie object.
 * void insert(String word) Inserts the string word into the trie.
 * boolean search(String word) Returns true if the string word is in the trie (i.e., was inserted before),
 * and false otherwise.
 * boolean startsWith(String prefix) Returns true if there is a previously inserted string word that has
 * the prefix prefix, and false otherwise.
 * Example 1:
 * Input
 * ["Trie", "insert", "search", "search", "startsWith", "insert", "search"]
 * [[], ["apple"], ["apple"], ["app"], ["app"], ["app"], ["app"]]
 * Output
 * [null, null, true, false, true, null, true]
 * Explanation
 * Trie trie = new Trie();
 * trie.insert("apple");
 * trie.search("apple");   // return True
 * trie.search("app");     // return False
 * trie.startsWith("app"); // return True
 * trie.insert("app");
 * trie.search("app");     // return True
 * Constraints:
 * 1 <= word.length, prefix.length <= 2000
 * word and prefix consist only of lowercase English letters.
 * At most 3 * 10^4 calls in total will be made to insert, search, and startsWith.
 */
public class Trie {
    private static final int ALPHABET_SIZE = 26;
    private static final Node WORLD = new Node();

    private final Node head;

    /**
     * Initialize your data structure here.
     */
    public Trie() {
        head = new Node();
    }

    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {
        assertWorldIsValid(word);
        Node node = head;
        for (char ch : word.toCharArray()) {
            assertValidChar(ch);
            if (node.hasChild(ch)) {
                node = node.getChild(ch);
            } else {
                node = node.createChild(ch);
            }
        }
        node.markAsWorld();
    }

    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {
        assertWorldIsValid(word);
        Node node = findNode(word);
        return node != null && node.isWorld();
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        assertWorldIsValid(prefix);
        Node node = findNode(prefix);
        return node != null;
    }

    private Node findNode(String prefix) {
        Node node = head;
        for (char ch : prefix.toCharArray()) {
            assertValidChar(ch);
            node = node.getChild(ch);
            if (node == null) {
                return null;
            }
        }
        return node;
    }

    private void assertValidChar(char ch) {
        if (!isValidChar(ch)) {
            throw new IllegalArgumentException("Char: " + ch + " is not valid");
        }
    }

    private boolean isValidChar(char ch) {
        int index = ch - 'a';
        return index >= 0 && index <= ALPHABET_SIZE;
    }

    private void assertWorldIsValid(String word) {
        if (Objects.requireNonNull(word).length() < 1) {
            throw new IllegalArgumentException("World: " + word + " has invalid length");
        }
    }

    private static class Node {
        final Node[] children = new Node[ALPHABET_SIZE + 1]; // additional WORD_CHAR

        private Node() {
        }

        boolean hasChild(char ch) {
            return children[index(ch)] != null;
        }

        Node getChild(char ch) {
            return children[index(ch)];
        }

        Node createChild(char ch) {
            Node newNode = new Node();
            children[index(ch)] = newNode;
            return newNode;
        }

        void markAsWorld() {
            children[lastIndex()] = WORLD;
        }

        boolean isWorld() {
            return children[lastIndex()] == WORLD;
        }

        private int index(char ch) {
            return ch - 'a';
        }

        private int lastIndex() {
            return children.length - 1;
        }
    }
}
