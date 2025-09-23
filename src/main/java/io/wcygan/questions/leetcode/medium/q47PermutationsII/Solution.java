package io.wcygan.questions.leetcode.medium.q47PermutationsII;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 47. Permutations II
 * <p>
 * Difficulty: Medium
 * URL: https://leetcode.com/problems/permutations-ii/
 * <p>
 * Given a collection of numbers, nums,&nbsp;that might contain duplicates, return all possible unique permutations in any order.
 * &nbsp;
 * Example 1:
 * Input: nums = [1,1,2]
 * Output:
 * [[1,1,2],
 * [1,2,1],
 * [2,1,1]]
 * Example 2:
 * Input: nums = [1,2,3]
 * Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 * &nbsp;
 * Constraints:
 * 1 <= nums.length <= 8
 * -10 <= nums[i] <= 10
 */
class Solution {
    List<List<Integer>> answer;

    public List<List<Integer>> permuteUnique(int[] nums) {
        answer = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(nums, new ArrayList<>(), new boolean[nums.length]);
        return answer;
    }

    void backtrack(
            int[] nums,
            List<Integer> path,
            boolean[] used
    ) {
        if (path.size() == nums.length) {
            answer.add(new ArrayList<>(path));
        }

        for (int i = 0; i < nums.length; i++) {
            if (used[i]
                    || (i > 0 && nums[i] == nums[i-1] && !used[i-1])
            ) continue;

            path.add(nums[i]);
            used[i] = true;
            backtrack(nums, path, used);
            path.remove(path.size() - 1);
            used[i] = false;
        }
    }
}
