package io.wcygan.questions.leetcode.medium.q40CombinationSumII;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 40. Combination Sum II
 *
 * Difficulty: Medium
 * URL: https://leetcode.com/problems/combination-sum-ii/
 *
 * Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in candidates&nbsp;where the candidate numbers sum to target.
 * Each number in candidates&nbsp;may only be used once in the combination.
 * Note:&nbsp;The solution set must not contain duplicate combinations.
 * &nbsp;
 * Example 1:
 * Input: candidates = [10,1,2,7,6,1,5], target = 8
 * Output:
 * [
 * [1,1,6],
 * [1,2,5],
 * [1,7],
 * [2,6]
 * ]
 * Example 2:
 * Input: candidates = [2,5,2,1,2], target = 5
 * Output:
 * [
 * [1,2,2],
 * [5]
 * ]
 * &nbsp;
 * Constraints:
 * 1 <=&nbsp;candidates.length <= 100
 * 1 <=&nbsp;candidates[i] <= 50
 * 1 <= target <= 30
 */
class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(result, new ArrayList<>(), candidates, target, 0);
        return result;
    }

    /**
     *
     * @param answer the overall result of the method
     * @param path the current values that are considered
     * @param candidates the pool of values to consider
     * @param remainder how much is remaining to hit the target
     * @param position the index of the current recursion
     */
    private void backtrack(
            List<List<Integer>> answer,
            List<Integer> path,
            int[] candidates,
            int remainder,
            int position) {
        if (remainder < 0) {
            return;
        } else if (remainder == 0) {
            answer.add(new ArrayList<>(path));
        } else {
            for (int i = position; i < candidates.length; i++) {
                if (i > position && candidates[i] == candidates[i-1]) continue;
                path.add(candidates[i]);
                backtrack(answer, path, candidates, remainder - candidates[i], i + 1);
                path.remove(path.size() - 1);
            }
        }
    }
}
