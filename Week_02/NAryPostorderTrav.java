package Week2;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class NAryPostorderTrav {
    public static void main(String[] args) {
        Node a = new Node(1);
        Node b = new Node(2);
        Node c = new Node(3);
        List<Node> d = new ArrayList<>();
        d.add(b);
        d.add(c);
        a.children = d;
        List res1 = postorder1(a);
        System.out.println(res1);
        List res2 = postorder2(a);
        System.out.println(res2);
    }

    // 双栈
    private static List postorder2(Node root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        Deque<Node> deq1 = new LinkedList<>();
        Deque<Node> deq2 = new LinkedList<>();
        deq1.addLast(root);
        while (!deq1.isEmpty()) {
            Node node = deq1.pollLast();
            deq2.addLast(node);
            if (node.children != null) {
                for (Node child : node.children) {
                    deq1.addLast(child);
                }
            }
        }
        while (!deq2.isEmpty()) {
            res.add(deq2.pollLast().val);
        }
        return res;
    }

    // 前序逆转
    public static List<Integer> postorder1(Node root) {
        LinkedList<Integer> res = new LinkedList<>();
        if (root == null) return res;
        Deque<Node> deq = new LinkedList<>();
        deq.addLast(root);
        while (!deq.isEmpty()) {
            Node node = deq.pollLast();
            res.addFirst(node.val);
            List<Node> children = node.children;
            if (children != null) {
                for (Node child : children) {
                    deq.addLast(child);
                }
            }
        }
        return res;
    }
    static class Node {
        public int val;
        public List<Node> children;
        public Node() {}
        public Node(int _val) {
            val = _val;
        }
        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }
}
