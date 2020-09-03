package Week1;

public class Design_circular_deque_II {
    int[] deque;
    int head;
    int count;
    /** Initialize your data structure here. Set the size of the deque to be k. */
    public Design_circular_deque_II(int k) {
        this.deque = new int[k];
        this.head = 0;
        this.count = 0;
    }

    /** Adds an item at the front of Deque. Return true if the operation is successful. */
    public boolean insertFront(int value) {
        if (count == deque.length) return false;
        head = (deque.length + head - 1) % deque.length;
        deque[head] = value;
        count += 1;
        return true;
    }

    /** Adds an item at the rear of Deque. Return true if the operation is successful. */
    public boolean insertLast(int value) {
        if (count == deque.length) return false;
        deque[(head + count) % deque.length] = value;
        count += 1;
        return true;
    }

    /** Deletes an item from the front of Deque. Return true if the operation is successful. */
    public boolean deleteFront() {
        if (count == 0) return false;
        head = (head + 1) % deque.length;
        count -= 1;
        return true;
    }

    /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
    public boolean deleteLast() {
        if (count == 0) return false;
        count -= 1;
        return true;
    }

    /** Get the front item from the deque. */
    public int getFront() {
        if (count == 0) return -1;
        return deque[head];
    }

    /** Get the last item from the deque. */
    public int getRear() {
        if (count == 0) return -1;
        return deque[(head + count - 1) % deque.length];
    }

    /** Checks whether the circular deque is empty or not. */
    public boolean isEmpty() {
        return count == 0;
    }

    /** Checks whether the circular deque is full or not. */
    public boolean isFull() {
        return count == deque.length;
    }
}
class Node1 {
    public int value;
    public Node1 nextNode;
    public Node1(int value) {
        this.value = value;
        this.nextNode = null;
    }
}

class MyCircularDeque {//用单链表
    public Node1 head, tail;
    public int count;
    public int capacity;
    /** Initialize your data structure here. Set the size of the deque to be k. */
    public MyCircularDeque(int k) {
        this.capacity = k;
    }

    /** Adds an item at the front of Deque. Return true if the operation is successful. */
    public boolean insertFront(int value) {
        if (count == capacity) return false;
        Node1 newNode = new Node1(value);
        if (count == 0) {
            head = tail = newNode;
        } else {
            newNode.nextNode = head;
            head = newNode;
        }
        count += 1;
        return true;
    }

    /** Adds an item at the rear of Deque. Return true if the operation is successful. */
    public boolean insertLast(int value) {
        if (count == capacity) return false;
        Node1 newNode = new Node1(value);
        if (count == 0) {
            head = tail = newNode;
        } else {
            tail.nextNode = newNode;
            tail = newNode;
        }
        count += 1;
        return true;
    }

    /** Deletes an item from the front of Deque. Return true if the operation is successful. */
    public boolean deleteFront() {
        if (count == 0) return false;
        head = head.nextNode;
        count -= 1;
        return true;
    }

    /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
    public boolean deleteLast() {
        if (count == 0) return false;
        Node1 pre = null, cur = head;
        while(cur.nextNode != null) {
            pre = cur;
            cur = cur.nextNode;
        }
        tail = pre;
        if (tail != null) tail.nextNode = null;
        count -= 1;
        return true;
    }

    /** Get the front item from the deque. */
    public int getFront() {
        if (count == 0) return -1;
        return head.value;
    }

    /** Get the last item from the deque. */
    public int getRear() {
        if (count == 0) return -1;
        return tail.value;
    }

    /** Checks whether the circular deque is empty or not. */
    public boolean isEmpty() {
        return count == 0;
    }

    /** Checks whether the circular deque is full or not. */
    public boolean isFull() {
        return count == capacity;
    }
}