package io.wcygan.questions.leetcode.medium.q78Subsets;

import java.util.ArrayList;
import java.util.List;

/**
 * 78. Subsets
 *
 * Difficulty: Medium
 * URL: https://leetcode.com/problems/subsets/
 *
 * Given an integer array nums of unique elements, return all possible subsets (the power set).
 * The solution set must not contain duplicate subsets. Return the solution in any order.
 * &nbsp;
 * Example 1:
 * Input: nums = [1,2,3]
 * Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
 * Example 2:
 * Input: nums = [0]
 * Output: [[],[0]]
 * &nbsp;
 * Constraints:
 * 1 <= nums.length <= 10
 * -10 <= nums[i] <= 10
 * All the numbers of&nbsp;nums are unique.
 */
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        dfs(nums, 0, new ArrayList<>(), result);
        return result;
    }

    private void dfs(int[] nums, int start, List<Integer> path, List<List<Integer>> result) {
        // The current path is a valid solution
        // Use a deep copy of it
        result.add(new ArrayList<>(path));

        // Iterate over the remainder of the array
        for (int i = start; i < nums.length; i++) {
            // Consider the path that includes the next number
            path.add(nums[i]);

            // Explore all paths that include the next number
            dfs(nums, i + 1, path, result);

            // Remove the next number from consideration
            path.remove(path.size() - 1);
        }
    }
}
