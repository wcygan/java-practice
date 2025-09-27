package io.wcygan.questions.leetcode.medium.q22GenerateParentheses;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Stack;

/**
 * 22. Generate Parentheses
 *
 * Difficulty: Medium
 * URL: https://leetcode.com/problems/generate-parentheses/
 *
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 * &nbsp;
 * Example 1:
 * Input: n = 3
 * Output: ["((()))","(()())","(())()","()(())","()()()"]
 * Example 2:
 * Input: n = 1
 * Output: ["()"]
 * &nbsp;
 * Constraints:
 * 1 <= n <= 8
 */
class Solution {
    List<String> answer = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        backtrack(
                "",
                0,
                0,
                n
        );
        return answer;
    }

    void backtrack(
            String current,
            int open,
            int close,
            int n
    ) {
        if (open == close && (open + close) == n * 2) {
            answer.add(current);
        }

        if (open < n) {
            backtrack(current + "(", open + 1, close, n);
        }

        if (close < open) {
            backtrack(current + ")", open, close + 1, n);
        }
    }
}
