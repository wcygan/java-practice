package io.wcygan.random.date_2024_nov_6;

import org.junit.Test;
import static org.junit.Assert.*;
import java.util.Arrays;
import java.util.List;

public class TwoSumTest {
    private final TwoSum twoSum = new TwoSum();

    @Test
    public void testFindTwoSumIndices_case1() {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        List<Integer> expected = Arrays.asList(0, 1);
        assertEquals(expected, twoSum.findTwoSumIndices(nums, target));
    }

    @Test
    public void testFindTwoSumIndices_case2() {
        int[] nums = {3, 2, 4};
        int target = 6;
        List<Integer> expected = Arrays.asList(1, 2);
        assertEquals(expected, twoSum.findTwoSumIndices(nums, target));
    }

    @Test
    public void testFindTwoSumIndices_case3() {
        int[] nums = {3, 3};
        int target = 6;
        List<Integer> expected = Arrays.asList(0, 1);
        assertEquals(expected, twoSum.findTwoSumIndices(nums, target));
    }

    @Test
    public void testFindTwoSumIndices_emptyArray() {
        int[] nums = {};
        int target = 0;
        assertNull(twoSum.findTwoSumIndices(nums, target));
    }
}