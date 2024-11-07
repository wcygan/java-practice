package io.wcygan.random.date_2024_nov_6;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TwoSum {
    /**
     * Finds indices of the two numbers such that they add up to the target.
     *
     * @param nums   Array of integers.
     * @param target The target sum.
     * @return List containing the indices of the two numbers.
     */
    public List<Integer> findTwoSumIndices(int[] nums, int target) {
        Map<Integer, Integer> index = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            // 1. Check if there is a pair
            int other = target - nums[i];
            if (index.containsKey(other)) {
                return List.of(index.get(other), i);
            }

            // 2. Add this to the index
            index.put(nums[i], i);
        }

        return null;
    }
}
