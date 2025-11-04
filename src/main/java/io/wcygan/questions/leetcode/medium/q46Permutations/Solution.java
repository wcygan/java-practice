package io.wcygan.questions.leetcode.medium.q46Permutations;

import java.util.ArrayList;
import java.util.List;

/**
 * 46. Permutations
 *
 * Difficulty: Medium
 * URL: https://leetcode.com/problems/permutations/
 *
 * Given an array nums of distinct integers, return all the possible permutations. You can return the answer in any order.
 * &nbsp;
 * Example 1:
 * Input: nums = [1,2,3]
 * Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 * Example 2:
 * Input: nums = [0,1]
 * Output: [[0,1],[1,0]]
 * Example 3:
 * Input: nums = [1]
 * Output: [[1]]
 * &nbsp;
 * Constraints:
 * 1 <= nums.length <= 6
 * -10 <= nums[i] <= 10
 * All the integers of nums are unique.
 */
class Solution {
    List<List<Integer>> solution = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        backtrack(nums, new boolean[nums.length] ,new ArrayList<>());
        return solution;
    }

    /**
     * General backtracking pattern:
     * 1. Check if we are out of bounds
     * 2. Attempt exploring paths that include current number
     * 3. Remove current number
     * 4. Explore other paths
     */
    void backtrack(int[] nums, boolean[] used, List<Integer> path) {
        if (path.size() == nums.length) {
            // Found a solution, add a deep copy
            solution.add(new ArrayList<>(path));
        }

        for (int i = 0; i < nums.length; i++) {
            if (used[i] || i > 0 && nums[i] == nums[i-1] && !used[i-1]) {
                continue;
            }

            path.add(nums[i]);
            used[i] = true;
            backtrack(nums, used, path);
            path.remove(path.size() - 1);
            used[i] = false;
        }
    }
}
