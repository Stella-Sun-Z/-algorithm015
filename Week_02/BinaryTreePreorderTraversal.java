package Week2;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class BinaryTreePreorderTraversal {
    // 方法一：递归前序遍历
    List<Integer> res = new ArrayList<>();
    public List<Integer> preorderTraversal1(TreeNode root) {
        preOrder(root);
        return res;
    }
    private void preOrder(TreeNode root) {
        if (root == null) return;
        res.add(root.val);
        preOrder(root.left);
        preOrder(root.right);
    }

    // 方法二：调用栈
    public List<Integer> preorderTraversal2(TreeNode root) {
        Deque<TreeNode> deque = new LinkedList<>();
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        deque.addLast(root);
        while (!deque.isEmpty()) {
            TreeNode node = deque.pollLast();
            res.add(node.val);
            if (node.right != null) deque.addLast(node.right);
            if (node.left != null) deque.addLast(node.left);
        }
        return res;
    }

    public class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){ val = x; }
    }
}
