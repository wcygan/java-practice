package io.wcygan.algorithms.tree;

import io.wcygan.collections.tree.BinaryTreeNode;

public class Height {
    public static <T> int height(BinaryTreeNode<T> node) {
        if (node == null) {
            return 0;
        }

        // The height of the right sub-tree
        int left = height(node.getLeft());

        // The height of the left sub-tree
        int right = height(node.getRight());

        // The height of this node and the tallest sub-tree
        return 1 + (Math.max(left, right));
    }
}
