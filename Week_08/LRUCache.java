package Week8;

import java.util.HashMap;

public class LRUCache {
    public static void main(String[] args) {
        LRUCache cache = new LRUCache( 2);
        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1)); //1
        cache.put(3, 3);
        System.out.println(cache.get(2));//-1
        cache.put(4, 4);    // 该操作会使得关键字 1 作废
        System.out.println(cache.get(1));
        System.out.println(cache.get(3));
        System.out.println(cache.get(4));

    }

    int size, capacity;
    DLinkedNode head, tail;
    HashMap<Integer, DLinkedNode> map;

    public LRUCache(int capacity) {
        size = 0;
        this.capacity = capacity;
        head = new DLinkedNode();
        tail = new DLinkedNode();
        head.next = tail;
        tail.pre = head;
        map = new HashMap<>();
    }

    public int get(int key) {
        if (!map.containsKey(key)) return -1;
        DLinkedNode node = map.get(key);
        moveToHead(node);
        return node.value;
    }

    private void moveToHead(DLinkedNode node) {
        removeNode(node);
        addToHead(node);
    }

    public void put(int key, int value) {
        if (!map.containsKey(key)) {
            DLinkedNode node = new DLinkedNode(key, value);
            if (size >= capacity) {
                map.remove(tail.pre.key);
                removeNode(tail.pre);
                size--;
                System.out.println("del" + value);
            }
            addToHead(node);
            map.put(key, node);
            size++;
            System.out.println("size " + size);
        } else {
            DLinkedNode node = map.get(key);
            moveToHead(node);
            node.value = value;
            System.out.println("add " + value);
        }
    }

    private void removeNode(DLinkedNode node) {
        node.next.pre = node.pre;
        node.pre.next = node.next;
    }

    private void addToHead(DLinkedNode node) {
        head.next.pre = node;
        node.next = head.next;
        head.next = node;
        node.pre = head;
    }

    private static class DLinkedNode {
        int key, value;
        DLinkedNode pre, next;

        public DLinkedNode() {}

        public DLinkedNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
}
