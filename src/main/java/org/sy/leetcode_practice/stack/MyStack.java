package org.sy.leetcode_practice.stack;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 用队列实现栈
 */
public class MyStack {

    private Queue<Integer> queue;

    public MyStack() {
        queue = new LinkedList<>();
    }

    public void push(int x) {
        queue.add(x);
    }

    public int pop() {
        Queue<Integer> sub = new LinkedList<>();
        int size = queue.size();
        for(int i=0;i<size-1;i++) {
            sub.add(queue.remove());
        }
        int result = queue.remove();
        size = sub.size();
        for(int j=0;j<size;j++) {
            queue.add(sub.remove());
        }
        return result;
    }

    public int top() {
        Queue<Integer> sub = new LinkedList<>();
        int size = queue.size();
        for(int i=0;i<size-1;i++) {
            sub.add(queue.remove());
        }
        int result = queue.remove();
        size = sub.size();
        for(int j=0;j<size;j++) {
            queue.add(sub.remove());
        }
        queue.add(result);
        return result;
    }

    public boolean empty() {
        return queue.isEmpty();
    }

}
