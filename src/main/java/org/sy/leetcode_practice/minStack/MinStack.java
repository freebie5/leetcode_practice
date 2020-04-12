package org.sy.leetcode_practice.minStack;

import java.util.Stack;

/**
 * 最小栈
 */
public class MinStack {

    private Stack<Integer> data;
    private Stack<Integer> minStack;

    public MinStack() {
        this.data = new Stack<>();
        this.minStack = new Stack<>();
    }

    public void push(int x) {
        data.push(x);
        if(this.minStack.isEmpty() || this.minStack.peek()>=x) {
            this.minStack.push(x);
        }
    }

    public void pop() {
        if(this.minStack.peek().equals(this.data.peek())) {
            this.minStack.pop();
        }
        this.data.pop();
    }

    public int top() throws RuntimeException {
        if(!this.data.isEmpty()) {
            return this.data.peek();
        }
        throw new RuntimeException();
    }

    public int getMin() throws RuntimeException {
        if(!this.minStack.isEmpty()) {
            return this.minStack.peek();
        }
        throw new RuntimeException();
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(512);
        minStack.push(-1024);
        minStack.push(-1024);
        minStack.push(512);
        minStack.pop();
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.getMin());

    }

}
