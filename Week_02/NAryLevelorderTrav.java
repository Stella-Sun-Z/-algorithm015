package Week2;

import java.util.*;

public class NAryLevelorderTrav {
    public static void main(String[] args) {
        Node a = new Node(1);
        Node b = new Node(2);
        Node c = new Node(3);
        List<Node> d = new ArrayList<>();
        d.add(b);
        d.add(c);
        a.children = d;
        List<List<Integer>> res1 = levelOrder1(a);
        System.out.println(res1);
        List<List<Integer>> res2 = levelOrder2(a);
        System.out.println(res2);
    }

    // 递归
    public static List<List<Integer>> res = new ArrayList<>();
    private static List<List<Integer>> levelOrder2(Node root) {
        if (root == null) return res;
        traversal(root, 0);
        return res;
    }

    private static void traversal(Node root, int level) {
        int size = res.size();
        if (size <= level) res.add(new ArrayList<>());
        res.get(level).add(root.val);
        if (root.children != null) {
            for (Node child : root.children) {
                traversal(child, level + 1);
            }
        }
    }

    // 迭代 + 队列
    public static List<List<Integer>> levelOrder1(Node root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        Deque<Node> deq = new LinkedList<>();
        deq.addLast(root);
        while (!deq.isEmpty()) {
            List<Integer> layer = new ArrayList<>();
            int size = deq.size();
            while (size > 0) {
                Node node = deq.pollFirst();
                layer.add(node.val);
                List<Node> children = node.children;
                if (children != null) {
                    deq.addAll(children);
                }
                size--;
            }
            res.add(layer);
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
