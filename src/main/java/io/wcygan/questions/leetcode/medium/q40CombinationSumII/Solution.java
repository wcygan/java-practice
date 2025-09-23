package io.wcygan.questions.leetcode.medium.q40CombinationSumII;

import java.util.ArrayList;
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
    private List<List<Integer>> result;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        result = new ArrayList<>();

        return result;
    }
}
