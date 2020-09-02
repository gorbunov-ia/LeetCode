package ru.gorbunov.tasks.fb.linkedlists;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.gorbunov.tasks.fb.linkedlists.ReverseOperations.Node;

import java.util.LinkedList;
import java.util.List;

class ReverseOperationsTest {

    private ReverseOperations component;

    @BeforeEach
    void setUp() {
        component = new ReverseOperations();
    }

    @Test
    void example1() {
        int[] arr_1 = {1, 2, 8, 9, 12, 16};
        int[] expected1 = {1, 8, 2, 9, 16, 12};
        Node head_1 = createLinkedList(arr_1);
        Node expected_1 = createLinkedList(expected1);

        Node output_1 = component.reverse(head_1);

        Assertions.assertEquals(toList(expected_1), toList(output_1));
    }

    @Test
    void example2() {
        int[] arr_2 = {2, 18, 24, 3, 5, 7, 9, 6, 12};
        int[] expected2 = {24, 18, 2, 3, 5, 7, 9, 12, 6};
        Node head_2 = createLinkedList(arr_2);
        Node expected_2 = createLinkedList(expected2);

        Node output_2 = component.reverse(head_2);

        Assertions.assertEquals(toList(expected_2), toList(output_2));
    }

    Node createLinkedList(int[] arr) {
        Node head = null;
        Node tempHead = head;
        for (int v : arr) {
            if (head == null) {
                head = new Node(v);
                tempHead = head;
            } else {
                head.next = new Node(v);
                head = head.next;
            }
        }
        return tempHead;
    }

    List<Integer> toList(Node head) {
        List<Integer> list = new LinkedList<>();
        while (head != null) {
            list.add(head.data);
            head = head.next;
        }
        return list;
    }

}