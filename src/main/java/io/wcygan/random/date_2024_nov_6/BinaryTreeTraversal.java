package io.wcygan.random.date_2024_nov_6;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeTraversal {
    /**
     * Performs in-order traversal of a binary tree.
     *
     * @param root The root of the binary tree.
     * @return A list of values representing the in-order traversal.
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> inOrder = new ArrayList<>();
        inorderTraversal(root, inOrder);
        return inOrder;
    }

    public void inorderTraversal(TreeNode root, List<Integer> inOrder) {
        if (root == null) return;
        inorderTraversal(root.left, inOrder);
        inOrder.add(root.val);
        inorderTraversal(root.right, inOrder);
    }

    // Definition for a binary tree node.
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}