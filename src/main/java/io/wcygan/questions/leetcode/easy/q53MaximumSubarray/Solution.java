package io.wcygan.questions.leetcode.easy.q53MaximumSubarray;

// https://leetcode.com/problems/maximum-subarray/
class Solution {
    public int maxSubArray(int[] nums) {
        int result = nums[0];
        int total = 0;

        for (int value : nums) {
            if (total < 0) {
                total = 0;
            }

            total += value;
            result = Math.max(total, result);
        }

        return result;
    }
}
