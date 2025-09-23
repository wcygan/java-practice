package io.wcygan.questions.leetcode.medium.q78Subsets;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {

    private final Solution solution = new Solution();

    @Test
    void testExample1() {
        int[] nums = {1, 2, 3};

        List<List<Integer>> expected = List.of(
                // Empty set is valid
                List.of(),
                // 1 is the first element
                List.of(1),
                // 2 can be considered with [1]
                List.of(1, 2),
                // 3 can be considered with [1, 2]
                List.of(1, 2, 3),
                // 3 can be considered with [1] and without 2
                List.of(1, 3),
                // 2 can be considered without 1
                List.of(2),
                // 3 can be considered with [2] and without 1
                List.of(2, 3),
                // 3 can be considered without 1 or 2
                List.of(3)
        );

        assertThat(solution.subsets(nums)).containsExactlyInAnyOrderElementsOf(expected);
    }
}
