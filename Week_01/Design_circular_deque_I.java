package Week1;

public class Design_circular_deque_I {//用数组实现
    /** Initialize your data structure here. Set the size of the queue to be k. */
    int[] queue;
    int headIndex;
    int count;

    public Design_circular_deque_I(int k) {
        this.queue = new int[k];
        this.headIndex = 0;
        this.count = 0;
    }

    /** Insert an element into the circular queue. Return true if the operation is successful. */
    public boolean enQueue(int value) {
        if (this.count == this.queue.length) return false;
        this.queue[(this.headIndex + this.count) % this.queue.length] = value;
        this.count += 1;
        return true;
    }

    /** Delete an element from the circular queue. Return true if the operation is successful. */
    public boolean deQueue() {
        if (this.count == 0) return false;
        this.headIndex = (this.headIndex + 1) % this.queue.length;
        this.count -= 1;
        return true;
    }

    /** Get the front item from the queue. */
    public int Front() {
        if (this.count == 0) return -1;
        return this.queue[this.headIndex];
    }

    /** Get the last item from the queue. */
    public int Rear() {
        if (this.count == 0) return -1;
        return this.queue[(this.headIndex + this.count - 1) % this.queue.length];
    }

    /** Checks whether the circular queue is empty or not. */
    public boolean isEmpty() {
        return this.count == 0;
    }

    /** Checks whether the circular queue is full or not. */
    public boolean isFull() {
        return this.count == this.queue.length;
    }
}

class Node{
    public int value;
    public Node1 nextNode;
    public Node(int value){
        this.value = value;
        this.nextNode = null;
    }
}
class MyCircularQueue {//用单链表实现
    /** Initialize your data structure here. Set the size of the queue to be k. */
    public Node1 head, tail;
    public int count;
    public int capacity;

    public MyCircularQueue(int k) {
        this.capacity = k;
    }

    /** Insert an element into the circular queue. Return true if the operation is successful. */
    public boolean enQueue(int value) {
        if (this.count == this.capacity) return false;
        Node1 newNode = new Node1(value);
        if (this.count == 0) {
            this.head = this.tail = newNode;
        } else {
            this.tail.nextNode = newNode;
            this.tail = newNode;
        }
        this.count += 1;
        return true;
    }

    /** Delete an element from the circular queue. Return true if the operation is successful. */
    public boolean deQueue() {
        if (this.count == 0) return false;
        this.head = this.head.nextNode;
        count -= 1;
        return true;
    }

    /** Get the front item from the queue. */
    public int Front() {
        if (this.count == 0) return -1;
        return this.head.value;
    }

    /** Get the last item from the queue. */
    public int Rear() {
        if (this.count == 0) return -1;
        return this.tail.value;
    }

    /** Checks whether the circular queue is empty or not. */
    public boolean isEmpty() {
        return this.count == 0;
    }

    /** Checks whether the circular queue is full or not. */
    public boolean isFull() {
        return this.capacity == this.count;
    }
}