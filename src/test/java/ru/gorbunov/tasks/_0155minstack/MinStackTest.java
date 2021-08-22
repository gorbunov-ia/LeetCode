package ru.gorbunov.tasks._0155minstack;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MinStackTest {

    private MinStack minStack;

    @BeforeEach
    void setUp() {
        minStack = new MinStack();
    }

    @Test
    void example1() {
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);

        Assertions.assertEquals(-3, minStack.getMin());
        minStack.pop();
        Assertions.assertEquals(0, minStack.top());
        Assertions.assertEquals(-2, minStack.getMin());
    }
}