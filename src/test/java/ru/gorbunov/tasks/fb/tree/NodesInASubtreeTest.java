package ru.gorbunov.tasks.fb.tree;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static ru.gorbunov.tasks.fb.tree.NodesInASubtree.Node;
import static ru.gorbunov.tasks.fb.tree.NodesInASubtree.Query;

class NodesInASubtreeTest {

    private NodesInASubtree component;

    @BeforeEach
    void setUp() {
        component = new NodesInASubtree();
    }

    @Test
    void example1() {
        //Testcase 1
        int n_1 = 3, q_1 = 1;
        String s_1 = "aba";
        Node root_1 = new Node(1);
        root_1.children.add(new Node(2));
        root_1.children.add(new Node(3));
        ArrayList<Query> queries_1 = new ArrayList<>();
        queries_1.add(new Query(1, 'a'));
        int[] output_1 = component.countOfNodes(root_1, queries_1, s_1);
        int[] expected_1 = {2};
        Assertions.assertArrayEquals(expected_1, output_1);
    }

    @Test
    void example2() {
        // Testcase 2
        String s_2 = "abaacab";
        Node root_2 = new Node(1);
        root_2.children.add(new Node(2));
        root_2.children.add(new Node(3));
        root_2.children.add(new Node(7));
        root_2.children.get(0).children.add(new Node(4));
        root_2.children.get(0).children.add(new Node(5));
        root_2.children.get(1).children.add(new Node(6));
        ArrayList<Query> queries_2 = new ArrayList<>();
        queries_2.add(new Query(1, 'a'));
        queries_2.add(new Query(2, 'b'));
        queries_2.add(new Query(3, 'a'));
        int[] output_2 = component.countOfNodes(root_2, queries_2, s_2);
        int[] expected_2 = {4, 1, 2};
        Assertions.assertArrayEquals(expected_2, output_2);
    }
}