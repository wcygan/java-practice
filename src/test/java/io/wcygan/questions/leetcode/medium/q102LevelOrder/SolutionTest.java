package io.wcygan.questions.leetcode.medium.q102LevelOrder;

import io.wcygan.questions.leetcode.TreeNode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * A test suite that verifies the correctness of the `Solution.levelOrder(TreeNode root)` method.
 */
public class SolutionTest {

    /**
     * Helper function that builds a binary tree in level order from an array
     * of Integer values. A null indicates "no node" in that position.
     *
     * Example usage:
     * buildTreeLevelOrder(new Integer[]{1,2,3,4,5}) -> a small test tree
     */
    private static TreeNode buildTreeLevelOrder(Integer[] values) {
        if (values == null || values.length == 0) {
            return null;
        }

        // Create a list of TreeNodes, using null where the array is null
        List<TreeNode> nodes = new ArrayList<>();
        for (Integer val : values) {
            if (val == null) {
                nodes.add(null);
            } else {
                nodes.add(new TreeNode(val));
            }
        }

        // Link each node's left/right children
        for (int i = 0; i < nodes.size(); i++) {
            TreeNode current = nodes.get(i);
            if (current != null) {
                int leftIdx = 2 * i + 1;
                int rightIdx = 2 * i + 2;

                if (leftIdx < nodes.size()) {
                    current.left = nodes.get(leftIdx);
                }
                if (rightIdx < nodes.size()) {
                    current.right = nodes.get(rightIdx);
                }
            }
        }

        // The root of the tree is the first element
        return nodes.get(0);
    }

    @Test
    public void testNullRoot() {
        // If the input is null, we expect an empty list of levels
        Solution solution = new Solution();
        List<List<Integer>> result = solution.levelOrder(null);

        Assertions.assertNotNull(result, "Expected a non-null List, possibly empty.");
        Assertions.assertTrue(result.isEmpty(), "Expected an empty list when the tree root is null.");
    }

    @Test
    public void testSingleNode() {
        // Just a single node with value 42
        TreeNode root = new TreeNode(42);
        Solution solution = new Solution();
        List<List<Integer>> result = solution.levelOrder(root);

        Assertions.assertNotNull(result);
        Assertions.assertEquals(1, result.size());
        Assertions.assertEquals(List.of(42), result.get(0), "Should be one level containing [42].");
    }

    @Test
    public void testCompleteBinaryTree() {
        // A complete tree with 7 nodes:
        //         1
        //        / \
        //       2   3
        //      / \ / \
        //     4  5 6  7
        Integer[] values = {1, 2, 3, 4, 5, 6, 7};
        TreeNode root = buildTreeLevelOrder(values);

        Solution solution = new Solution();
        List<List<Integer>> result = solution.levelOrder(root);

        Assertions.assertNotNull(result);
        Assertions.assertEquals(3, result.size(), "We expect 3 levels for a perfect binary tree of depth 3.");

        // Level 1
        Assertions.assertEquals(List.of(1), result.get(0));
        // Level 2
        Assertions.assertEquals(List.of(2, 3), result.get(1));
        // Level 3
        Assertions.assertEquals(List.of(4, 5, 6, 7), result.get(2));
    }

    @Test
    public void testLeftSkewedTree() {
        // A left-skewed tree:
        //     10
        //     /
        //    9
        //    /
        //   8
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(9);
        root.left.left = new TreeNode(8);

        Solution solution = new Solution();
        List<List<Integer>> result = solution.levelOrder(root);

        Assertions.assertNotNull(result);
        Assertions.assertEquals(3, result.size());
        Assertions.assertEquals(List.of(10), result.get(0));
        Assertions.assertEquals(List.of(9), result.get(1));
        Assertions.assertEquals(List.of(8), result.get(2));
    }

    @Test
    public void testRightSkewedTree() {
        // A right-skewed tree:
        //  1
        //   \
        //    2
        //     \
        //      3
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.right = new TreeNode(3);

        Solution solution = new Solution();
        List<List<Integer>> result = solution.levelOrder(root);

        Assertions.assertNotNull(result);
        Assertions.assertEquals(3, result.size());
        Assertions.assertEquals(List.of(1), result.get(0));
        Assertions.assertEquals(List.of(2), result.get(1));
        Assertions.assertEquals(List.of(3), result.get(2));
    }

    @Test
    public void testTreeWithNullChildren() {
        // A tree with some nulls in the middle:
        //       1
        //      / \
        //     2   null
        //    / \
        //  null 4
        // We won't fill in all the "null array spots" for level building,
        // so let's just do it by hand:
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.right = new TreeNode(4);

        Solution solution = new Solution();
        List<List<Integer>> result = solution.levelOrder(root);

        // Expect three levels:
        // Level 1: [1]
        // Level 2: [2]
        // Level 3: [4]
        Assertions.assertEquals(3, result.size());
        Assertions.assertEquals(List.of(1), result.get(0));
        Assertions.assertEquals(List.of(2), result.get(1));
        Assertions.assertEquals(List.of(4), result.get(2));
    }

    @Test
    public void testUnbalancedTree() {
        //     100
        //    /   \
        //  50    200
        //  /
        // 25
        TreeNode root = new TreeNode(100);
        root.left = new TreeNode(50);
        root.right = new TreeNode(200);
        root.left.left = new TreeNode(25);

        Solution solution = new Solution();
        List<List<Integer>> result = solution.levelOrder(root);

        // Expect:
        // L1: [100]
        // L2: [50, 200]
        // L3: [25]
        Assertions.assertNotNull(result);
        Assertions.assertEquals(3, result.size());
        Assertions.assertEquals(List.of(100), result.get(0));
        Assertions.assertEquals(List.of(50, 200), result.get(1));
        Assertions.assertEquals(List.of(25), result.get(2));
    }

    @Test
    public void testLargerTree() {
        // Create a bigger example:
        // Values: [1,2,3,4,5,6,7,8,9,10]
        // Visual shape:
        //             1
        //          /     \
        //         2       3
        //        / \     / \
        //       4   5   6   7
        //      / \  /
        //     8 9  10
        Integer[] values = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        TreeNode root = buildTreeLevelOrder(values);

        Solution solution = new Solution();
        List<List<Integer>> result = solution.levelOrder(root);

        // We expect 4 levels:
        // L1: [1]
        // L2: [2, 3]
        // L3: [4, 5, 6, 7]
        // L4: [8, 9, 10]
        Assertions.assertNotNull(result);
        Assertions.assertEquals(4, result.size());
        Assertions.assertEquals(List.of(1), result.get(0));
        Assertions.assertEquals(List.of(2, 3), result.get(1));
        Assertions.assertEquals(List.of(4, 5, 6, 7), result.get(2));
        Assertions.assertEquals(List.of(8, 9, 10), result.get(3));
    }
}
