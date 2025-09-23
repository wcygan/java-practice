package io.wcygan.questions.leetcode.medium.q47PermutationsII;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {

    private final Solution solution = new Solution();

    @Test
    void testExample1() {
        solution.permuteUnique(new int[]{1, 2, 3});
    }
}
