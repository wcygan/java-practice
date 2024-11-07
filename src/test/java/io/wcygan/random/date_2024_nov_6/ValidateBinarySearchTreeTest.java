package io.wcygan.random.date_2024_nov_6;

import org.junit.Test;
import static org.junit.Assert.*;

public class ValidateBinarySearchTreeTest {
    private ValidateBinarySearchTree validator = new ValidateBinarySearchTree();

    @Test
    public void testIsValidBST() {
        ValidateBinarySearchTree.TreeNode root1 = new ValidateBinarySearchTree.TreeNode(2);
        root1.left = new ValidateBinarySearchTree.TreeNode(1);
        root1.right = new ValidateBinarySearchTree.TreeNode(3);
        assertTrue(validator.isValidBST(root1));

        ValidateBinarySearchTree.TreeNode root2 = new ValidateBinarySearchTree.TreeNode(5);
        root2.left = new ValidateBinarySearchTree.TreeNode(1);
        root2.right = new ValidateBinarySearchTree.TreeNode(4);
        root2.right.left = new ValidateBinarySearchTree.TreeNode(3);
        root2.right.right = new ValidateBinarySearchTree.TreeNode(6);
        assertFalse(validator.isValidBST(root2));

        assertTrue(validator.isValidBST(null));
    }
}