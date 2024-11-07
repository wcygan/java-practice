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
}