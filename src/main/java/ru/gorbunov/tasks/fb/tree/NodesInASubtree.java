package ru.gorbunov.tasks.fb.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
/**
 * Nodes in a Subtree
 * <p>
 * You are given a tree that contains N nodes, each containing an integer u which corresponds to a lowercase character
 * c in the string s using 1-based indexing.
 * You are required to answer Q queries of type [u, c], where u is an integer and c is a lowercase letter. The query
 * result is the number of nodes in the subtree of node u containing c.
 * Signature
 * int[] countOfNodes(Node root, ArrayList<Query> queries, String s)
 * Input
 * A pointer to the root node, an array list containing Q queries of type [u, c], and a string s
 * Constraints
 * N and Q are the integers between 1 and 1,000,000
 * u is a unique integer between 1 and N
 * s is of the length of N, containing only lowercase letters
 * c is a lowercase letter contained in string s
 * Node 1 is the root of the tree
 * Output
 * An integer array containing the response to each query
 * Example
 *
 *         1(a)
 *         /   \
 *       2(b)  3(a)
 *
 * s = "aba"
 * RootNode = 1
 * query = [[1, 'a']]
 * Note: Node 1 corresponds to first letter 'a', Node 2 corresponds to second letter of the string 'b', Node 3
 * corresponds to third letter of the string 'a'.
 * output = [2]
 * Both Node 1 and Node 3 contain 'a', so the number of nodes within the subtree of Node 1 containing 'a' is 2.
 */
public class NodesInASubtree {

    // Tree Node
    static class Node {
        public int val;
        public List<Node> children;

        public Node() {
            val = 0;
            children = new ArrayList<>();
        }

        public Node(int _val) {
            val = _val;
            children = new ArrayList<>();
        }

        public Node(int _val, ArrayList<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    static class Query {
        int u;
        char c;
        Query(int u, char c) {
            this.u = u;
            this.c = c;
        }
    }

    // Add any helper functions you may need here
    private Node findNode(Node root, int value) {

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()) {
            Node node = queue.poll();
            if (node.val == value) {
                return node;
            }
            queue.addAll(node.children);
        }

        return null;
    }

    private int countChars(Node root, char ch, String str) {

        int result = 0;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()) {
            Node node = queue.poll();
            if (str.charAt(node.val - 1) == ch) {
                result++;
            }
            queue.addAll(node.children);
        }

        return result;
    }

    int[] countOfNodes(Node root, ArrayList<Query> queries, String s) {
        // Write your code here
        int[] result = new int[queries.size()];

        for (int i = 0; i < queries.size(); i++) {
            Query q = queries.get(i);
            Node node = findNode(root, q.u);
            result[i] = countChars(node, q.c, s);
        }

        return result;
    }
}
