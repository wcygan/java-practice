package io.wcygan.questions.leetcode.medium.q46Permutations;

import java.util.ArrayList;
import java.util.List;

/**
 * 46. Permutations
 * <p>
 * Difficulty: Medium
 * URL: https://leetcode.com/problems/permutations/
 * <p>
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
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> answer = new ArrayList<>();
        backtrack(answer, new ArrayList<>(), nums, new boolean[nums.length]);
        return answer;
    }

    void backtrack(
            List<List<Integer>> answer,
            List<Integer> path,
            int[] nums,
            boolean[] used
    ) {
        if (path.size() == nums.length) {
            answer.add(new ArrayList<>(path));
        }

        for (int i = 0; i < nums.length; i++) {
            if (used[i] || i > 0 && nums[i] == nums[i-1] && !used[i-1]) continue;
            path.add(nums[i]);
            used[i] = true;
            backtrack(answer, path, nums, used);
            path.remove(path.size() - 1);
            used[i] = false;
        }
    }
}
