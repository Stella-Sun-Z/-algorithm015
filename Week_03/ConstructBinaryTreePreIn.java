package Week3;

import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTreePreIn {
    public static void main(String[] args) {
        int[] preorder = {1, 2};
        int[] inorder = {1, 2};
        TreeNode res = buildTree(preorder, inorder);
    }
    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length != inorder.length) return null;
        Map<Integer, Integer> dict = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) dict.put(inorder[i], i);
        TreeNode res = genTree(preorder, dict, 0, preorder.length - 1, 0, preorder.length - 1);
        return res;
    }

    private static TreeNode genTree(int[] preorder, Map<Integer, Integer> dict, int preS, int preE, int inS, int inE) {
        if (preS > preE || inS > inE) return null;

        TreeNode root = new TreeNode(preorder[preS]);
        int rootIdx = dict.get(preorder[preS]);//inorder中根节点idx
        // 求下一个节点坐标 - left
        int left_preS = preS + 1;
        int left_preE = preS + (rootIdx - inS);
        int left_intE = rootIdx - 1;
        // 求下一个节点坐标 - left
        int right_preS = left_preE + 1;
        int right_inS = rootIdx + 1;

        root.left = genTree(preorder, dict, left_preS, left_preE, inS, left_intE);
        root.right = genTree(preorder, dict, right_preS, preE, right_inS, inE);
        return root;
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
