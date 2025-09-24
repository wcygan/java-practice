package io.wcygan.questions.leetcode.easy.q257BinaryTreePaths;
import io.wcygan.questions.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 257. Binary Tree Paths
 *
 * Difficulty: Easy
 * URL: https://leetcode.com/problems/binary-tree-paths/
 *
 * Given the root of a binary tree, return all root-to-leaf paths in any order.
 * A leaf is a node with no children.
 * &nbsp;
 * Example 1:
 * Input: root = [1,2,3,null,5]
 * Output: ["1->2->5","1->3"]
 * Example 2:
 * Input: root = [1]
 * Output: ["1"]
 * &nbsp;
 * Constraints:
 * The number of nodes in the tree is in the range [1, 100].
 * -100 <= Node.val <= 100
 */
class Solution {
    List<String> answer = new ArrayList<>();
    public List<String> binaryTreePaths(TreeNode root) {
        dfs(new ArrayList<>(), root);
        return answer;
    }

    void dfs(List<Integer> path, TreeNode current) {
        if (current == null) return;

        path.add(current.val);

        if (current.left == null && current.right == null) {
            String result = path.stream()
                    .map(String::valueOf)
                    .reduce((a, b) -> String.format("%s->%s", a, b)).orElse("");
            answer.add(result);
        }

        dfs(path, current.left);
        dfs(path, current.right);

        path.remove(path.size() - 1);
    }
}
