package io.wcygan.questions.leetcode.medium.q90SubsetsII;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {

    private final Solution solution = new Solution();

    @Test
    void testExample1() {
        int[] nums = {1, 2, 2};

        List<List<Integer>> expected = List.of(
                List.of(),
                List.of(1),
                List.of(1, 2),
                List.of(1, 2, 2),
                List.of(2),
                List.of(2, 2)
        );

        assertThat(solution.subsetsWithDup(nums)).isEqualTo(expected);
    }
}
