package org.sy.leetcode_practice.queue;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * 循环队列
 */
public class MyCircularQueue {

    private static final Log logger = LogFactory.getLog(MyCircularQueue.class);

    private int length;
    private int head;
    private int tail;
    private int[] data;

    /** Initialize your data structure here. Set the size of the queue to be k. */
    public MyCircularQueue(int length) {
        this.length = length;
        this.head = -1;
        this.tail = -1;
        this.data = new int[length];
    }

    /** Insert an element into the circular queue. Return true if the operation is successful. */
    public boolean enQueue(int value) {
        if(this.isFull()) {
            return false;
        }
        if(this.isEmpty()) {
            this.head = 0;
        }
        this.tail = (this.tail + 1) % this.length;
        this.data[this.tail] = value;
        return true;
    }

    /** Delete an element from the circular queue. Return true if the operation is successful. */
    public boolean deQueue() {
        if(this.isEmpty()) {
            return false;
        }
        if(this.tail == this.head) {
            this.tail = -1;
            this.head = -1;
            return true;
        }
        this.head = (this.head + 1) % this.length;
        return true;
    }

    /** Get the front item from the queue. */
    public int Front() {
        if(this.isEmpty()) {
            return -1;
        }
        return this.data[this.head];
    }

    /** Get the last item from the queue. */
    public int Rear() {
        if(this.isEmpty()) {
            return -1;
        }
        return this.data[this.tail];
    }

    /** Checks whether the circular queue is empty or not. */
    public boolean isEmpty() {
        if(this.head == -1) {
            return true;
        }
        return false;
    }

    /** Checks whether the circular queue is full or not. */
    public boolean isFull() {
        if((this.tail+1)%this.length == this.head) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        MyCircularQueue myCircularQueue = new MyCircularQueue(5);
        logger.debug(myCircularQueue.enQueue(1));
        logger.debug(myCircularQueue.deQueue());
        logger.debug(myCircularQueue.enQueue(2));
        logger.debug(myCircularQueue.enQueue(3));
        logger.debug(myCircularQueue.enQueue(4));
        logger.debug(myCircularQueue.enQueue(5));
        logger.debug(myCircularQueue.enQueue(6));
    }

}
