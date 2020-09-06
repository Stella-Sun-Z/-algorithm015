package Week2;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class NAryPreorderTraversal {
    // 迭代+调用栈
    public List<Integer> preorder2(Node root) {
        List<Integer> res = new ArrayList<>();
        Deque<Node> deq = new LinkedList<>();
        deq.addLast(root);
        while (root != null && !deq.isEmpty()){
            Node node = deq.pollLast();
            res.add(node.val);
            List<Node> children = node.children;
            for (int i = children.size() - 1; i >= 0; i--) {
                deq.addLast(children.get(i));
            }
        }
        return res;
    }

    // 递归
    List<Integer> res = new ArrayList<>();
    public List<Integer> preorder1(Node root) {
        pre(root);
        return res;
    }
    private void pre(Node root) {
        if (root == null) return;
        res.add(root.val);
        List<Node> children = root.children;
        for (Node child : children) {
            pre(child);
        }
    }


    class Node {
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
