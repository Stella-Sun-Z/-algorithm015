package Week2;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class BinaryTreeInorderTraversal {
    // 递归
    List<Integer> res = new ArrayList<>();
    public List<Integer> inorderTraversal2(TreeNode root) {
        inOrder(root);
        return res;
    }
    public void inOrder(TreeNode root) {
        if (root == null) return;
        inOrder(root.left);
        res.add(root.val);
        inOrder(root.right);
    }

    // 递归+调用栈
    public List<Integer> inorderTraversal1(TreeNode root) {
        Deque<TreeNode> deq = new LinkedList<>();
        List<Integer> res = new ArrayList<>();
        while (root != null || !deq.isEmpty()) {
            while(root != null) {
                deq.addLast(root);
                root = root.left;
            }
            TreeNode node = deq.pollLast();
            res.add(node.val);
            root = node.right;
        }
        return res;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }
}
