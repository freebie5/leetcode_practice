package org.sy.leetcode_practice.queue;

import java.util.Stack;

/**
 * 栈实现队列
 */
public class MyQueue {

    private Stack<Integer> stack;

    public MyQueue() {
        stack = new Stack<>();
    }

    public void push(int x) {
        stack.push(x);
    }

    public int pop() {
        Stack<Integer> sub = new Stack<>();
        int size = stack.size();
        for(int i=0;i<size;i++) {
            sub.push(stack.pop());
        }
        int resutl = sub.pop();
        size = sub.size();
        for(int j=0;j<size;j++) {
            stack.push(sub.pop());
        }
        return resutl;
    }

    public int peek() {
        Stack<Integer> sub = new Stack<>();
        int size = stack.size();
        for(int i=0;i<size;i++) {
            sub.push(stack.pop());
        }
        int resutl = sub.peek();
        size = sub.size();
        for(int j=0;j<size;j++) {
            stack.push(sub.pop());
        }
        return resutl;
    }

    public boolean empty() {
        return stack.isEmpty();
    }

}
