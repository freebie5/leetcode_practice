package org.sy.leetcode_practice.queue;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class MyCircularQueue2 {

    private static final Log logger = LogFactory.getLog(MyCircularQueue2.class);

    private int length;
    private int head;
    private int tail;
    private int[] data;

    /** Initialize your data structure here. Set the size of the queue to be k. */
    public MyCircularQueue2(int length) {
        this.length = length+1;
        this.head = 0;
        this.tail = 0;
        this.data = new int[length+1];
    }

    /** Insert an element into the circular queue. Return true if the operation is successful. */
    public boolean enQueue(int value) {
        if(this.isFull()) {
            return false;
        }
        this.data[this.tail] = value;
        this.tail = (this.tail + 1) % this.length;
        return true;
    }

    /** Delete an element from the circular queue. Return true if the operation is successful. */
    public boolean deQueue() {
        if(this.isEmpty()) {
            return false;
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
        int result = (this.tail-1 + this.length)%this.length;
        return this.data[result];
    }

    /** Checks whether the circular queue is empty or not. */
    public boolean isEmpty() {
        if(this.head == this.tail) {
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
        MyCircularQueue2 myCircularQueue = new MyCircularQueue2(5);
        logger.debug(myCircularQueue.enQueue(1));
        logger.debug(myCircularQueue.deQueue());
        logger.debug(myCircularQueue.enQueue(2));
        logger.debug(myCircularQueue.enQueue(3));
        logger.debug(myCircularQueue.enQueue(4));
        logger.debug(myCircularQueue.enQueue(5));
        logger.debug(myCircularQueue.enQueue(6));
    }

}
