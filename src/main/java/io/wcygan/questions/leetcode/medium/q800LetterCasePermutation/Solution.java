package io.wcygan.questions.leetcode.medium.q800LetterCasePermutation;

import java.util.*;

/**
 * 800. Letter Case Permutation
 *
 * Difficulty: Medium
 * URL: https://leetcode.com/problems/letter-case-permutation/
 *
 * Given a string s, you&nbsp;can transform every letter individually to be lowercase or uppercase to create another string.
 * Return a list of all possible strings we could create. Return the output in any order.
 * &nbsp;
 * Example 1:
 * Input: s = "a1b2"
 * Output: ["a1b2","a1B2","A1b2","A1B2"]
 * Example 2:
 * Input: s = "3z4"
 * Output: ["3z4","3Z4"]
 * &nbsp;
 * Constraints:
 * 1 <= s.length <= 12
 * s consists of lowercase English letters, uppercase English letters, and digits.
 */
class Solution {
    Set<String> answer = new HashSet<>();
    public List<String> letterCasePermutation(String s) {
        String[] split = s.split("");
        backtrack(split, 0);
        return new ArrayList<>(answer);
    }

    void backtrack(
            String[] current,
            int index
    ) {
        if (index == current.length) {
            Arrays.stream(current)
                    .reduce((a, b) -> a + b)
                    .ifPresent(this.answer::add);
            return;
        }


        // Check with Uppercase
        current[index] = current[index].toUpperCase();
        backtrack(current, index + 1);
        // Check with Lowercase
        current[index] = current[index].toLowerCase();
        backtrack(current, index + 1);
    }
}
