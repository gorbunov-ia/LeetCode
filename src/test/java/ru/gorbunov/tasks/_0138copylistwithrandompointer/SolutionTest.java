package ru.gorbunov.tasks._0138copylistwithrandompointer;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.gorbunov.tasks._0138copylistwithrandompointer.Solution.Node;

class SolutionTest {

    private Solution solution;

    @BeforeEach
    void setUp() {
        solution = new Solution();
    }

    @Test
    void example1() {
        Node node0 = buildNode();

        Node result = solution.copyRandomList(node0);

        assertNode(result);
    }

    private void assertNode(Node node) {
        Assertions.assertEquals(7, node.val);
        Assertions.assertNull(node.random);
        node = node.next;
        Assertions.assertEquals(13, node.val);
        Assertions.assertEquals(7, node.random.val);
        node = node.next;
        Assertions.assertEquals(11, node.val);
        Assertions.assertEquals(1, node.random.val);
        node = node.next;
        Assertions.assertEquals(10, node.val);
        Assertions.assertEquals(11, node.random.val);
        node = node.next;
        Assertions.assertEquals(1, node.val);
        Assertions.assertEquals(7, node.random.val);
    }

    private Node buildNode() {
        Node node0 = new Node(7);
        Node node1 = new Node(13);
        Node node2 = new Node(11);
        Node node3 = new Node(10);
        Node node4 = new Node(1);

        node0.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        node1.random = node0;
        node2.random = node4;
        node3.random = node2;
        node4.random = node0;
        return node0;
    }
}