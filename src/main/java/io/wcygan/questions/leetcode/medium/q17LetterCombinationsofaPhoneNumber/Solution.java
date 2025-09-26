package io.wcygan.questions.leetcode.medium.q17LetterCombinationsofaPhoneNumber;

import java.util.*;

/**
 * 17. Letter Combinations of a Phone Number
 *
 * Difficulty: Medium
 * URL: https://leetcode.com/problems/letter-combinations-of-a-phone-number/
 *
 * Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent. Return the answer in any order.
 * A mapping of digits to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.
 * &nbsp;
 * Example 1:
 * Input: digits = "23"
 * Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
 * Example 2:
 * Input: digits = ""
 * Output: []
 * Example 3:
 * Input: digits = "2"
 * Output: ["a","b","c"]
 * &nbsp;
 * Constraints:
 * 0 <= digits.length <= 4
 * digits[i] is a digit in the range ['2', '9'].
 */
class Solution {
    List<String> answer = new ArrayList<>();
    public List<String> letterCombinations(String digits) {
        if (Objects.equals(digits, "")) return answer;

        Map<Integer, Set<String >> characters = Map.of(
                2, Set.of("a", "b" , "c"),
                3, Set.of("d", "e" , "f"),
                4, Set.of("g", "h" , "i"),
                5, Set.of("j", "k" , "l"),
                6, Set.of("m", "n" , "o"),
                7, Set.of("p", "q" , "r", "s"),
                8, Set.of("t", "u" , "v"),
                9, Set.of("w", "x", "y" , "z")
        );
        backtrack(characters, digits, "", 0);
        return answer;
    }

    void backtrack(
            Map<Integer, Set<String>> characters,
            String digits,
            String current,
            int index
    ) {
        if (index >= digits.length()) {
            answer.add(current);
            return;
        }

        Integer digit = Integer.valueOf(String.valueOf(digits.charAt(index)));
        Set<String> possibilities = characters.get(digit);
        for (String character : possibilities) {
            backtrack(characters, digits, current + character, index + 1);
        }
    }
}
