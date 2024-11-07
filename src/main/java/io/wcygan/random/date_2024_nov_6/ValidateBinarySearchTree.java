package io.wcygan.random.date_2024_nov_6;

public class ValidateBinarySearchTree {
    /**
     * Validates if a binary tree is a binary search tree.
     *
     * @param root The root of the binary tree.
     * @return True if it's a valid BST, otherwise false.
     */
    public boolean isValidBST(TreeNode root) {
        return validate(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean validate(TreeNode node, long min, long max) {
        if (node == null) return true;
        if (node.val <= min || node.val >= max) return false;
        return validate(node.left, min, node.val) && validate(node.right, node.val, max);
    }

    // Definition for a binary tree node.
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}