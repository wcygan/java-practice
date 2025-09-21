package io.wcygan.questions.leetcode.medium.q113PathSumII;
import io.wcygan.questions.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 113. Path Sum II
 *
 * Difficulty: Medium
 * URL: https://leetcode.com/problems/path-sum-ii/
 *
 * Given the root of a binary tree and an integer targetSum, return all root-to-leaf paths where the sum of the node values in the path equals targetSum. Each path should be returned as a list of the node values, not node references.
 * A root-to-leaf path is a path starting from the root and ending at any leaf node. A leaf is a node with no children.
 * &nbsp;
 * Example 1:
 * Input: root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
 * Output: [[5,4,11,2],[5,8,4,5]]
 * Explanation: There are two paths whose sum equals targetSum:
 * 5 + 4 + 11 + 2 = 22
 * 5 + 8 + 4 + 5 = 22
 * Example 2:
 * Input: root = [1,2,3], targetSum = 5
 * Output: []
 * Example 3:
 * Input: root = [1,2], targetSum = 0
 * Output: []
 * &nbsp;
 * Constraints:
 * The number of nodes in the tree is in the range [0, 5000].
 * -1000 <= Node.val <= 1000
 * -1000 <= targetSum <= 1000
 */
class Solution {

    private List<List<Integer>> result;

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        result = new ArrayList<>();

        // Need to find ALL combinations
        //   - Have one result to return at the end
        //   - Pass snapshots forward as we iterate over the problem space
        //   - Add to the result if the targetSum is met (values can be negative, zero, and positive, so need to explore all paths)

        recurse(root, targetSum, 0, new ArrayList<>());

        return result;
    }

    private void recurse(TreeNode root, int targetSum, int currentSum, List<Integer> currentPath) {
        if (root == null) return;

        currentPath.add(root.val);
        currentSum += root.val;

        boolean isLeafNode = root.left == null && root.right == null;
        boolean matches = targetSum == currentSum;
        if (matches && isLeafNode) {
            result.add(currentPath);
        }

        recurse(root.left, targetSum, currentSum, new ArrayList<>(currentPath));
        recurse(root.right, targetSum, currentSum, new ArrayList<>(currentPath));
    }
}
