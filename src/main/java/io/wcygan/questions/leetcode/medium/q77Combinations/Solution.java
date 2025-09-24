package io.wcygan.questions.leetcode.medium.q77Combinations;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * 77. Combinations
 *
 * Difficulty: Medium
 * URL: https://leetcode.com/problems/combinations/
 *
 * Given two integers n and k, return all possible combinations of k numbers chosen from the range [1, n].
 * You may return the answer in any order.
 * &nbsp;
 * Example 1:
 * Input: n = 4, k = 2
 * Output: [[1,2],[1,3],[1,4],[2,3],[2,4],[3,4]]
 * Explanation: There are 4 choose 2 = 6 total combinations.
 * Note that combinations are unordered, i.e., [1,2] and [2,1] are considered to be the same combination.
 * Example 2:
 * Input: n = 1, k = 1
 * Output: [[1]]
 * Explanation: There is 1 choose 1 = 1 total combination.
 * &nbsp;
 * Constraints:
 * 1 <= n <= 20
 * 1 <= k <= n
 */
class Solution {
    List<List<Integer>> answer = new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {
        List<Integer> candidates = IntStream.rangeClosed(1, n + 1)
                .boxed()
                .toList();
        backtrack(candidates, new ArrayList<>(), k, 0);
        return answer;
    }

    void backtrack(List<Integer> candidates, List<Integer> path, int k, int current) {
        if (current >= candidates.size()) {
            // Out of bounds
            return;
        }

        if (path.size() == k) {
            // One potential answer is found
            answer.add(new ArrayList<>(path));
            return;
        }


        path.add(candidates.get(current));
        backtrack(candidates, path, k, current + 1);
        path.remove(path.size() - 1);
        backtrack(candidates, path, k, current + 1);
    }
}
