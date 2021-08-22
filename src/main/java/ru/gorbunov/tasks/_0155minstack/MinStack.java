package ru.gorbunov.tasks._0155minstack;

import java.util.NoSuchElementException;

/**
 * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
 * Implement the MinStack class:
 * MinStack() initializes the stack object.
 * void push(val) pushes the element val onto the stack.
 * void pop() removes the element on the top of the stack.
 * int top() gets the top element of the stack.
 * int getMin() retrieves the minimum element in the stack.
 * Example 1:
 * Input
 * ["MinStack","push","push","push","getMin","pop","top","getMin"]
 * [[],[-2],[0],[-3],[],[],[],[]]
 * Output
 * [null,null,null,null,-3,null,0,-2]
 * Explanation
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.getMin(); // return -3
 * minStack.pop();
 * minStack.top();    // return 0
 * minStack.getMin(); // return -2
 * Constraints:
 * -231 <= val <= 231 - 1
 * Methods pop, top and getMin operations will always be called on non-empty stacks.
 * At most 3 * 104 calls will be made to push, pop, top, and getMin.
 */
public class MinStack {

    private StackNode top = null;
    private StackNode min = null;

    /**
     * initialize your data structure here.
     */
    public MinStack() {
    }

    public void push(int val) {
        top = new StackNode(val, top);
        int newMin = min == null ? val : Math.min(min.val, val);
        min = new StackNode(newMin, min);
    }

    public void pop() {
        if (top == null) {
            throw new NoSuchElementException();
        }
        top = top.prev;
        min = min.prev;
    }

    public int top() {
        if (top == null) {
            throw new NoSuchElementException();
        }
        return top.val;
    }

    public int getMin() {
        return min.val;
    }

    private static class StackNode {
        int val;
        StackNode prev;

        StackNode(int val, StackNode prev) {
            this.val = val;
            this.prev = prev;
        }
    }
}
