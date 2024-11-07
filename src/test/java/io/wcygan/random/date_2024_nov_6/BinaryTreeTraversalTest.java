package io.wcygan.random.date_2024_nov_6;

import org.junit.Test;
import static org.junit.Assert.*;
import java.util.Arrays;
import java.util.List;

public class BinaryTreeTraversalTest {
    private BinaryTreeTraversal traversal = new BinaryTreeTraversal();

    @Test
    public void testInorderTraversal() {
        BinaryTreeTraversal.TreeNode root = new BinaryTreeTraversal.TreeNode(1);
        root.right = new BinaryTreeTraversal.TreeNode(2);
        root.right.left = new BinaryTreeTraversal.TreeNode(3);
        List<Integer> expected = Arrays.asList(1, 3, 2);
        assertEquals(expected, traversal.inorderTraversal(root));

        BinaryTreeTraversal.TreeNode root2 = null;
        assertTrue(traversal.inorderTraversal(root2).isEmpty());

        BinaryTreeTraversal.TreeNode root3 = new BinaryTreeTraversal.TreeNode(1);
        List<Integer> expected2 = Arrays.asList(1);
        assertEquals(expected2, traversal.inorderTraversal(root3));
    }

    @Test
    public void testInorderTraversalSingleNode() {
        BinaryTreeTraversal.TreeNode root = new BinaryTreeTraversal.TreeNode(1);
        List<Integer> expected = Arrays.asList(1);
        assertEquals(expected, traversal.inorderTraversal(root));
    }

    @Test
    public void testInorderTraversalLeftChildOnly() {
        BinaryTreeTraversal.TreeNode root = new BinaryTreeTraversal.TreeNode(1);
        root.left = new BinaryTreeTraversal.TreeNode(2);
        List<Integer> expected = Arrays.asList(2, 1);
        assertEquals(expected, traversal.inorderTraversal(root));
    }

    @Test
    public void testInorderTraversalRightChildOnly() {
        BinaryTreeTraversal.TreeNode root = new BinaryTreeTraversal.TreeNode(1);
        root.right = new BinaryTreeTraversal.TreeNode(2);
        List<Integer> expected = Arrays.asList(1, 2);
        assertEquals(expected, traversal.inorderTraversal(root));
    }

    @Test
    public void testInorderTraversalFullTree() {
        BinaryTreeTraversal.TreeNode root = new BinaryTreeTraversal.TreeNode(1);
        root.left = new BinaryTreeTraversal.TreeNode(2);
        root.right = new BinaryTreeTraversal.TreeNode(3);
        root.left.left = new BinaryTreeTraversal.TreeNode(4);
        root.left.right = new BinaryTreeTraversal.TreeNode(5);
        root.right.left = new BinaryTreeTraversal.TreeNode(6);
        root.right.right = new BinaryTreeTraversal.TreeNode(7);
        List<Integer> expected = Arrays.asList(4, 2, 5, 1, 6, 3, 7);
        assertEquals(expected, traversal.inorderTraversal(root));
    }

    @Test
    public void testInorderTraversalLeftSkewedTree() {
        BinaryTreeTraversal.TreeNode root = new BinaryTreeTraversal.TreeNode(1);
        root.left = new BinaryTreeTraversal.TreeNode(2);
        root.left.left = new BinaryTreeTraversal.TreeNode(3);
        root.left.left.left = new BinaryTreeTraversal.TreeNode(4);
        List<Integer> expected = Arrays.asList(4, 3, 2, 1);
        assertEquals(expected, traversal.inorderTraversal(root));
    }

    @Test
    public void testInorderTraversalRightSkewedTree() {
        BinaryTreeTraversal.TreeNode root = new BinaryTreeTraversal.TreeNode(1);
        root.right = new BinaryTreeTraversal.TreeNode(2);
        root.right.right = new BinaryTreeTraversal.TreeNode(3);
        root.right.right.right = new BinaryTreeTraversal.TreeNode(4);
        List<Integer> expected = Arrays.asList(1, 2, 3, 4);
        assertEquals(expected, traversal.inorderTraversal(root));
    }

    @Test
    public void testInorderTraversalComplexTree() {
        BinaryTreeTraversal.TreeNode root = new BinaryTreeTraversal.TreeNode(1);
        root.left = new BinaryTreeTraversal.TreeNode(2);
        root.right = new BinaryTreeTraversal.TreeNode(3);
        root.left.left = new BinaryTreeTraversal.TreeNode(4);
        root.left.right = new BinaryTreeTraversal.TreeNode(5);
        root.right.left = new BinaryTreeTraversal.TreeNode(6);
        root.right.right = new BinaryTreeTraversal.TreeNode(7);
        root.left.left.left = new BinaryTreeTraversal.TreeNode(8);
        root.left.left.right = new BinaryTreeTraversal.TreeNode(9);
        List<Integer> expected = Arrays.asList(8, 4, 9, 2, 5, 1, 6, 3, 7);
        assertEquals(expected, traversal.inorderTraversal(root));
    }

    @Test
    public void testInorderTraversalWithDuplicates() {
        BinaryTreeTraversal.TreeNode root = new BinaryTreeTraversal.TreeNode(1);
        root.left = new BinaryTreeTraversal.TreeNode(1);
        root.right = new BinaryTreeTraversal.TreeNode(1);
        List<Integer> expected = Arrays.asList(1, 1, 1);
        assertEquals(expected, traversal.inorderTraversal(root));
    }

    @Test
    public void testInorderTraversalWithNegativeValues() {
        BinaryTreeTraversal.TreeNode root = new BinaryTreeTraversal.TreeNode(-1);
        root.left = new BinaryTreeTraversal.TreeNode(-2);
        root.right = new BinaryTreeTraversal.TreeNode(-3);
        List<Integer> expected = Arrays.asList(-2, -1, -3);
        assertEquals(expected, traversal.inorderTraversal(root));
    }

    @Test
    public void testInorderTraversalWithLargeValues() {
        BinaryTreeTraversal.TreeNode root = new BinaryTreeTraversal.TreeNode(Integer.MAX_VALUE);
        root.left = new BinaryTreeTraversal.TreeNode(Integer.MIN_VALUE);
        List<Integer> expected = Arrays.asList(Integer.MIN_VALUE, Integer.MAX_VALUE);
        assertEquals(expected, traversal.inorderTraversal(root));
    }

    @Test
    public void testInorderTraversalWithNullNodes() {
        BinaryTreeTraversal.TreeNode root = new BinaryTreeTraversal.TreeNode(1);
        root.left = null;
        root.right = new BinaryTreeTraversal.TreeNode(2);
        root.right.left = null;
        root.right.right = new BinaryTreeTraversal.TreeNode(3);
        List<Integer> expected = Arrays.asList(1, 2, 3);
        assertEquals(expected, traversal.inorderTraversal(root));
    }

    @Test
    public void testInorderTraversalWithSingleChild() {
        BinaryTreeTraversal.TreeNode root = new BinaryTreeTraversal.TreeNode(1);
        root.left = new BinaryTreeTraversal.TreeNode(2);
        root.left.right = new BinaryTreeTraversal.TreeNode(3);
        List<Integer> expected = Arrays.asList(2, 3, 1);
        assertEquals(expected, traversal.inorderTraversal(root));
    }

    @Test
    public void testInorderTraversalWithMultipleLevels() {
        BinaryTreeTraversal.TreeNode root = new BinaryTreeTraversal.TreeNode(1);
        root.left = new BinaryTreeTraversal.TreeNode(2);
        root.right = new BinaryTreeTraversal.TreeNode(3);
        root.left.left = new BinaryTreeTraversal.TreeNode(4);
        root.left.right = new BinaryTreeTraversal.TreeNode(5);
        root.right.left = new BinaryTreeTraversal.TreeNode(6);
        root.right.right = new BinaryTreeTraversal.TreeNode(7);
        root.left.left.left = new BinaryTreeTraversal.TreeNode(8);
        root.left.left.right = new BinaryTreeTraversal.TreeNode(9);
        root.right.left.left = new BinaryTreeTraversal.TreeNode(10);
        root.right.left.right = new BinaryTreeTraversal.TreeNode(11);
        List<Integer> expected = Arrays.asList(8, 4, 9, 2, 5, 1, 10, 6, 11, 3, 7);
        assertEquals(expected, traversal.inorderTraversal(root));
    }

    @Test
    public void testInorderTraversalWithUnbalancedTree() {
        BinaryTreeTraversal.TreeNode root = new BinaryTreeTraversal.TreeNode(1);
        root.left = new BinaryTreeTraversal.TreeNode(2);
        root.left.left = new BinaryTreeTraversal.TreeNode(3);
        root.left.left.left = new BinaryTreeTraversal.TreeNode(4);
        root.left.left.left.left = new BinaryTreeTraversal.TreeNode(5);
        List<Integer> expected = Arrays.asList(5, 4, 3, 2, 1);
        assertEquals(expected, traversal.inorderTraversal(root));
    }

    @Test
    public void testInorderTraversalWithBalancedTree() {
        BinaryTreeTraversal.TreeNode root = new BinaryTreeTraversal.TreeNode(1);
        root.left = new BinaryTreeTraversal.TreeNode(2);
        root.right = new BinaryTreeTraversal.TreeNode(3);
        root.left.left = new BinaryTreeTraversal.TreeNode(4);
        root.left.right = new BinaryTreeTraversal.TreeNode(5);
        root.right.left = new BinaryTreeTraversal.TreeNode(6);
        root.right.right = new BinaryTreeTraversal.TreeNode(7);
        List<Integer> expected = Arrays.asList(4, 2, 5, 1, 6, 3, 7);
        assertEquals(expected, traversal.inorderTraversal(root));
    }

    @Test
    public void testInorderTraversalWithDeepTree() {
        BinaryTreeTraversal.TreeNode root = new BinaryTreeTraversal.TreeNode(1);
        root.left = new BinaryTreeTraversal.TreeNode(2);
        root.left.left = new BinaryTreeTraversal.TreeNode(3);
        root.left.left.left = new BinaryTreeTraversal.TreeNode(4);
        root.left.left.left.left = new BinaryTreeTraversal.TreeNode(5);
        root.left.left.left.left.left = new BinaryTreeTraversal.TreeNode(6);
        List<Integer> expected = Arrays.asList(6, 5, 4, 3, 2, 1);
        assertEquals(expected, traversal.inorderTraversal(root));
    }

    @Test
    public void testInorderTraversalWithWideTree() {
        BinaryTreeTraversal.TreeNode root = new BinaryTreeTraversal.TreeNode(1);
        root.left = new BinaryTreeTraversal.TreeNode(2);
        root.right = new BinaryTreeTraversal.TreeNode(3);
        root.left.left = new BinaryTreeTraversal.TreeNode(4);
        root.left.right = new BinaryTreeTraversal.TreeNode(5);
        root.right.left = new BinaryTreeTraversal.TreeNode(6);
        root.right.right = new BinaryTreeTraversal.TreeNode(7);
        root.left.left.left = new BinaryTreeTraversal.TreeNode(8);
        root.left.left.right = new BinaryTreeTraversal.TreeNode(9);
        root.left.right.left = new BinaryTreeTraversal.TreeNode(10);
        root.left.right.right = new BinaryTreeTraversal.TreeNode(11);
        root.right.left.left = new BinaryTreeTraversal.TreeNode(12);
        root.right.left.right = new BinaryTreeTraversal.TreeNode(13);
        root.right.right.left = new BinaryTreeTraversal.TreeNode(14);
        root.right.right.right = new BinaryTreeTraversal.TreeNode(15);
        List<Integer> expected = Arrays.asList(8, 4, 9, 2, 10, 5, 11, 1, 12, 6, 13, 3, 14, 7, 15);
        assertEquals(expected, traversal.inorderTraversal(root));
    }

    @Test
    public void testInorderTraversalWithMixedValues() {
        BinaryTreeTraversal.TreeNode root = new BinaryTreeTraversal.TreeNode(0);
        root.left = new BinaryTreeTraversal.TreeNode(-1);
        root.right = new BinaryTreeTraversal.TreeNode(1);
        root.left.left = new BinaryTreeTraversal.TreeNode(-2);
        root.left.right = new BinaryTreeTraversal.TreeNode(-3);
        root.right.left = new BinaryTreeTraversal.TreeNode(2);
        root.right.right = new BinaryTreeTraversal.TreeNode(3);
        List<Integer> expected = Arrays.asList(-2, -1, -3, 0, 2, 1, 3);
        assertEquals(expected, traversal.inorderTraversal(root));
    }

    @Test
    public void testInorderTraversalWithLargeTree() {
        BinaryTreeTraversal.TreeNode root = new BinaryTreeTraversal.TreeNode(1);
        root.left = new BinaryTreeTraversal.TreeNode(2);
        root.right = new BinaryTreeTraversal.TreeNode(3);
        root.left.left = new BinaryTreeTraversal.TreeNode(4);
        root.left.right = new BinaryTreeTraversal.TreeNode(5);
        root.right.left = new BinaryTreeTraversal.TreeNode(6);
        root.right.right = new BinaryTreeTraversal.TreeNode(7);
        root.left.left.left = new BinaryTreeTraversal.TreeNode(8);
        root.left.left.right = new BinaryTreeTraversal.TreeNode(9);
        root.left.right.left = new BinaryTreeTraversal.TreeNode(10);
        root.left.right.right = new BinaryTreeTraversal.TreeNode(11);
        root.right.left.left = new BinaryTreeTraversal.TreeNode(12);
        root.right.left.right = new BinaryTreeTraversal.TreeNode(13);
        root.right.right.left = new BinaryTreeTraversal.TreeNode(14);
        root.right.right.right = new BinaryTreeTraversal.TreeNode(15);
        root.left.left.left.left = new BinaryTreeTraversal.TreeNode(16);
        root.left.left.left.right = new BinaryTreeTraversal.TreeNode(17);
        root.left.left.right.left = new BinaryTreeTraversal.TreeNode(18);
        root.left.left.right.right = new BinaryTreeTraversal.TreeNode(19);
        root.left.right.left.left = new BinaryTreeTraversal.TreeNode(20);
        List<Integer> expected = Arrays.asList(16, 8, 17, 4, 18, 9, 19, 2, 20, 10, 5, 11, 1, 12, 6, 13, 3, 14, 7, 15);
        assertEquals(expected, traversal.inorderTraversal(root));
    }
}