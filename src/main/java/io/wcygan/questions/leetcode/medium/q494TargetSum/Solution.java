package io.wcygan.questions.leetcode.medium.q494TargetSum;
/**
 * 494. Target Sum
 *
 * Difficulty: Medium
 * URL: https://leetcode.com/problems/target-sum/
 *
 * You are given an integer array nums and an integer target.
 * You want to build an expression out of nums by adding one of the symbols '+' and '-' before each integer in nums and then concatenate all the integers.
 * For example, if nums = [2, 1], you can add a '+' before 2 and a '-' before 1 and concatenate them to build the expression "+2-1".
 * Return the number of different expressions that you can build, which evaluates to target.
 * &nbsp;
 * Example 1:
 * Input: nums = [1,1,1,1,1], target = 3
 * Output: 5
 * Explanation: There are 5 ways to assign symbols to make the sum of nums be target 3.
 * -1 + 1 + 1 + 1 + 1 = 3
 * +1 - 1 + 1 + 1 + 1 = 3
 * +1 + 1 - 1 + 1 + 1 = 3
 * +1 + 1 + 1 - 1 + 1 = 3
 * +1 + 1 + 1 + 1 - 1 = 3
 * Example 2:
 * Input: nums = [1], target = 1
 * Output: 1
 * &nbsp;
 * Constraints:
 * 1 <= nums.length <= 20
 * 0 <= nums[i] <= 1000
 * 0 <= sum(nums[i]) <= 1000
 * -1000 <= target <= 1000
 */
class Solution {
    int answer = 0;
    public int findTargetSumWays(int[] nums, int target) {
        backtrack(nums, target, 0);
        return answer;
    }

    void backtrack(
            int[] nums, int remaining, int index
    ) {
        if (index == nums.length) {
            if (remaining == 0) {
                answer += 1;
            }
            return;
        }

        // Check adding this number
        backtrack(nums, remaining - nums[index], index + 1);

        // Check subtracting this number
        backtrack(nums, remaining + nums[index], index + 1);
    }
}
