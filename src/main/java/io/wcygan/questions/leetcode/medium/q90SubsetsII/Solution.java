package io.wcygan.questions.leetcode.medium.q90SubsetsII;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 90. Subsets II
 *
 * Difficulty: Medium
 * URL: https://leetcode.com/problems/subsets-ii/
 *
 * Given an integer array nums that may contain duplicates, return all possible subsets (the power set).
 * The solution set must not contain duplicate subsets. Return the solution in any order.
 * &nbsp;
 * Example 1:
 * Input: nums = [1,2,2]
 * Output: [[],[1],[1,2],[1,2,2],[2],[2,2]]
 * Example 2:
 * Input: nums = [0]
 * Output: [[],[0]]
 * &nbsp;
 * Constraints:
 * 1 <= nums.length <= 10
 * -10 <= nums[i] <= 10
 */
class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        dfs(nums, 0, new ArrayList<>(), result);
        return result;
    }

    private void dfs(int[] nums, int start, List<Integer> path, List<List<Integer>> result) {
        // The current path is a valid solution
        // Use a deep copy of it
        result.add(new ArrayList<>(path));

        // Iterate over the remainder of the array
        for (int i = start; i < nums.length; i++) {
            // Skip any duplicate number
            boolean canCheckPreviousElement = i > start;
            if (canCheckPreviousElement) {
                int current = nums[i];
                int previous = nums[i-1];
                boolean isSameNumber = current == previous;
                if (isSameNumber) {
                    continue;
                }
            }

            // Consider the path that includes the next number
            path.add(nums[i]);

            // Explore all paths that include the next number
            dfs(nums, i + 1, path, result);

            // Remove the next number from consideration
            path.remove(path.size() - 1);
        }
    }
}
