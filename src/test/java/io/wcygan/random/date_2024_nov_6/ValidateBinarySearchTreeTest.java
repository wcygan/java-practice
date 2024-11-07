package io.wcygan.random.date_2024_nov_6;

import org.junit.Test;
import static org.junit.Assert.*;

public class ValidateBinarySearchTreeTest {
    private ValidateBinarySearchTree validator = new ValidateBinarySearchTree();

    @Test
    public void testValidBST() {
        ValidateBinarySearchTree.TreeNode root = new ValidateBinarySearchTree.TreeNode(2);
        root.left = new ValidateBinarySearchTree.TreeNode(1);
        root.right = new ValidateBinarySearchTree.TreeNode(3);
        assertTrue(validator.isValidBST(root));
    }

    @Test
    public void testInvalidBST() {
        ValidateBinarySearchTree.TreeNode root = new ValidateBinarySearchTree.TreeNode(5);
        root.left = new ValidateBinarySearchTree.TreeNode(1);
        root.right = new ValidateBinarySearchTree.TreeNode(4);
        root.right.left = new ValidateBinarySearchTree.TreeNode(3);
        root.right.right = new ValidateBinarySearchTree.TreeNode(6);
        assertFalse(validator.isValidBST(root));
    }

    @Test
    public void testNullTree() {
        assertTrue(validator.isValidBST(null));
    }

    @Test
    public void testSingleNodeTree() {
        ValidateBinarySearchTree.TreeNode root = new ValidateBinarySearchTree.TreeNode(1);
        assertTrue(validator.isValidBST(root));
    }

    @Test
    public void testLeftChildOnly() {
        ValidateBinarySearchTree.TreeNode root = new ValidateBinarySearchTree.TreeNode(2);
        root.left = new ValidateBinarySearchTree.TreeNode(1);
        assertTrue(validator.isValidBST(root));
    }

    @Test
    public void testRightChildOnly() {
        ValidateBinarySearchTree.TreeNode root = new ValidateBinarySearchTree.TreeNode(2);
        root.right = new ValidateBinarySearchTree.TreeNode(3);
        assertTrue(validator.isValidBST(root));
    }

    @Test
    public void testInvalidLeftChild() {
        ValidateBinarySearchTree.TreeNode root = new ValidateBinarySearchTree.TreeNode(2);
        root.left = new ValidateBinarySearchTree.TreeNode(3);
        assertFalse(validator.isValidBST(root));
    }

    @Test
    public void testInvalidRightChild() {
        ValidateBinarySearchTree.TreeNode root = new ValidateBinarySearchTree.TreeNode(2);
        root.right = new ValidateBinarySearchTree.TreeNode(1);
        assertFalse(validator.isValidBST(root));
    }

    @Test
    public void testValidBSTWithMultipleLevels() {
        ValidateBinarySearchTree.TreeNode root = new ValidateBinarySearchTree.TreeNode(10);
        root.left = new ValidateBinarySearchTree.TreeNode(5);
        root.right = new ValidateBinarySearchTree.TreeNode(15);
        root.left.left = new ValidateBinarySearchTree.TreeNode(3);
        root.left.right = new ValidateBinarySearchTree.TreeNode(7);
        root.right.left = new ValidateBinarySearchTree.TreeNode(12);
        root.right.right = new ValidateBinarySearchTree.TreeNode(17);
        assertTrue(validator.isValidBST(root));
    }

    @Test
    public void testInvalidBSTWithMultipleLevels() {
        ValidateBinarySearchTree.TreeNode root = new ValidateBinarySearchTree.TreeNode(10);
        root.left = new ValidateBinarySearchTree.TreeNode(5);
        root.right = new ValidateBinarySearchTree.TreeNode(15);
        root.left.left = new ValidateBinarySearchTree.TreeNode(3);
        root.left.right = new ValidateBinarySearchTree.TreeNode(7);
        root.right.left = new ValidateBinarySearchTree.TreeNode(6);
        root.right.right = new ValidateBinarySearchTree.TreeNode(17);
        assertFalse(validator.isValidBST(root));
    }

    @Test
    public void testValidBSTWithNegativeValues() {
        ValidateBinarySearchTree.TreeNode root = new ValidateBinarySearchTree.TreeNode(0);
        root.left = new ValidateBinarySearchTree.TreeNode(-3);
        root.right = new ValidateBinarySearchTree.TreeNode(3);
        assertTrue(validator.isValidBST(root));
    }

    @Test
    public void testInvalidBSTWithNegativeValues() {
        ValidateBinarySearchTree.TreeNode root = new ValidateBinarySearchTree.TreeNode(0);
        root.left = new ValidateBinarySearchTree.TreeNode(-3);
        root.right = new ValidateBinarySearchTree.TreeNode(-1);
        assertFalse(validator.isValidBST(root));
    }

    @Test
    public void testValidBSTWithDuplicateValues() {
        ValidateBinarySearchTree.TreeNode root = new ValidateBinarySearchTree.TreeNode(2);
        root.left = new ValidateBinarySearchTree.TreeNode(2);
        root.right = new ValidateBinarySearchTree.TreeNode(2);
        assertFalse(validator.isValidBST(root));
    }

    @Test
    public void testValidBSTWithLargeValues() {
        ValidateBinarySearchTree.TreeNode root = new ValidateBinarySearchTree.TreeNode(Integer.MAX_VALUE);
        root.left = new ValidateBinarySearchTree.TreeNode(Integer.MIN_VALUE);
        assertTrue(validator.isValidBST(root));
    }

    @Test
    public void testInvalidBSTWithLargeValues() {
        ValidateBinarySearchTree.TreeNode root = new ValidateBinarySearchTree.TreeNode(Integer.MAX_VALUE);
        root.left = new ValidateBinarySearchTree.TreeNode(Integer.MAX_VALUE);
        assertFalse(validator.isValidBST(root));
    }

    @Test
    public void testValidBSTWithOnlyLeftSubtree() {
        ValidateBinarySearchTree.TreeNode root = new ValidateBinarySearchTree.TreeNode(10);
        root.left = new ValidateBinarySearchTree.TreeNode(5);
        root.left.left = new ValidateBinarySearchTree.TreeNode(3);
        root.left.right = new ValidateBinarySearchTree.TreeNode(7);
        assertTrue(validator.isValidBST(root));
    }

    @Test
    public void testValidBSTWithOnlyRightSubtree() {
        ValidateBinarySearchTree.TreeNode root = new ValidateBinarySearchTree.TreeNode(10);
        root.right = new ValidateBinarySearchTree.TreeNode(15);
        root.right.left = new ValidateBinarySearchTree.TreeNode(12);
        root.right.right = new ValidateBinarySearchTree.TreeNode(17);
        assertTrue(validator.isValidBST(root));
    }

    @Test
    public void testInvalidBSTWithOnlyLeftSubtree() {
        ValidateBinarySearchTree.TreeNode root = new ValidateBinarySearchTree.TreeNode(10);
        root.left = new ValidateBinarySearchTree.TreeNode(5);
        root.left.left = new ValidateBinarySearchTree.TreeNode(3);
        root.left.right = new ValidateBinarySearchTree.TreeNode(11);
        assertFalse(validator.isValidBST(root));
    }

    @Test
    public void testInvalidBSTWithOnlyRightSubtree() {
        ValidateBinarySearchTree.TreeNode root = new ValidateBinarySearchTree.TreeNode(10);
        root.right = new ValidateBinarySearchTree.TreeNode(15);
        root.right.left = new ValidateBinarySearchTree.TreeNode(5);
        root.right.right = new ValidateBinarySearchTree.TreeNode(17);
        assertFalse(validator.isValidBST(root));
    }

    @Test
    public void testValidBSTWithComplexStructure() {
        ValidateBinarySearchTree.TreeNode root = new ValidateBinarySearchTree.TreeNode(8);
        root.left = new ValidateBinarySearchTree.TreeNode(3);
        root.right = new ValidateBinarySearchTree.TreeNode(10);
        root.left.left = new ValidateBinarySearchTree.TreeNode(1);
        root.left.right = new ValidateBinarySearchTree.TreeNode(6);
        root.left.right.left = new ValidateBinarySearchTree.TreeNode(4);
        root.left.right.right = new ValidateBinarySearchTree.TreeNode(7);
        root.right.right = new ValidateBinarySearchTree.TreeNode(14);
        root.right.right.left = new ValidateBinarySearchTree.TreeNode(13);
        assertTrue(validator.isValidBST(root));
    }
}