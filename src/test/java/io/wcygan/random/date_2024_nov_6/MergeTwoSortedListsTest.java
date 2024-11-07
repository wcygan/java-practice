package io.wcygan.random.date_2024_nov_6;

import org.junit.Test;
import static org.junit.Assert.*;

public class MergeTwoSortedListsTest {
    private MergeTwoSortedLists merger = new MergeTwoSortedLists();

    @Test
    public void testMergeTwoLists_Scenario1() {
        MergeTwoSortedLists.ListNode l1 = createList(new int[]{1, 2, 4});
        MergeTwoSortedLists.ListNode l2 = createList(new int[]{1, 3, 4});
        MergeTwoSortedLists.ListNode expected = createList(new int[]{1, 1, 2, 3, 4, 4});
        assertTrue(areEqual(expected, merger.mergeTwoLists(l1, l2)));
    }

    @Test
    public void testMergeTwoLists_Scenario2() {
        MergeTwoSortedLists.ListNode l1 = null;
        MergeTwoSortedLists.ListNode l2 = createList(new int[]{0});
        MergeTwoSortedLists.ListNode expected = createList(new int[]{0});
        assertTrue(areEqual(expected, merger.mergeTwoLists(l1, l2)));
    }

    @Test
    public void testMergeTwoLists_Scenario3() {
        MergeTwoSortedLists.ListNode l1 = null;
        MergeTwoSortedLists.ListNode l2 = null;
        assertNull(merger.mergeTwoLists(l1, l2));
    }

    @Test
    public void testMergeTwoLists_Scenario4() {
        MergeTwoSortedLists.ListNode l1 = createList(new int[]{});
        MergeTwoSortedLists.ListNode l2 = createList(new int[]{});
        assertNull(merger.mergeTwoLists(l1, l2));
    }

    @Test
    public void testMergeTwoLists_Scenario5() {
        MergeTwoSortedLists.ListNode l1 = createList(new int[]{1});
        MergeTwoSortedLists.ListNode l2 = createList(new int[]{1});
        MergeTwoSortedLists.ListNode expected = createList(new int[]{1, 1});
        assertTrue(areEqual(expected, merger.mergeTwoLists(l1, l2)));
    }

    @Test
    public void testMergeTwoLists_Scenario6() {
        MergeTwoSortedLists.ListNode l1 = createList(new int[]{1, 3, 5});
        MergeTwoSortedLists.ListNode l2 = createList(new int[]{2, 4, 6});
        MergeTwoSortedLists.ListNode expected = createList(new int[]{1, 2, 3, 4, 5, 6});
        assertTrue(areEqual(expected, merger.mergeTwoLists(l1, l2)));
    }

    @Test
    public void testMergeTwoLists_Scenario7() {
        MergeTwoSortedLists.ListNode l1 = createList(new int[]{1, 2, 3});
        MergeTwoSortedLists.ListNode l2 = createList(new int[]{4, 5, 6});
        MergeTwoSortedLists.ListNode expected = createList(new int[]{1, 2, 3, 4, 5, 6});
        assertTrue(areEqual(expected, merger.mergeTwoLists(l1, l2)));
    }

    @Test
    public void testMergeTwoLists_Scenario8() {
        MergeTwoSortedLists.ListNode l1 = createList(new int[]{4, 5, 6});
        MergeTwoSortedLists.ListNode l2 = createList(new int[]{1, 2, 3});
        MergeTwoSortedLists.ListNode expected = createList(new int[]{1, 2, 3, 4, 5, 6});
        assertTrue(areEqual(expected, merger.mergeTwoLists(l1, l2)));
    }

    @Test
    public void testMergeTwoLists_Scenario9() {
        MergeTwoSortedLists.ListNode l1 = createList(new int[]{1, 3, 5, 7});
        MergeTwoSortedLists.ListNode l2 = createList(new int[]{2, 4, 6, 8});
        MergeTwoSortedLists.ListNode expected = createList(new int[]{1, 2, 3, 4, 5, 6, 7, 8});
        assertTrue(areEqual(expected, merger.mergeTwoLists(l1, l2)));
    }

    @Test
    public void testMergeTwoLists_Scenario10() {
        MergeTwoSortedLists.ListNode l1 = createList(new int[]{1, 1, 1});
        MergeTwoSortedLists.ListNode l2 = createList(new int[]{2, 2, 2});
        MergeTwoSortedLists.ListNode expected = createList(new int[]{1, 1, 1, 2, 2, 2});
        assertTrue(areEqual(expected, merger.mergeTwoLists(l1, l2)));
    }

    @Test
    public void testMergeTwoLists_Scenario11() {
        MergeTwoSortedLists.ListNode l1 = createList(new int[]{1, 2, 3});
        MergeTwoSortedLists.ListNode l2 = createList(new int[]{1, 2, 3});
        MergeTwoSortedLists.ListNode expected = createList(new int[]{1, 1, 2, 2, 3, 3});
        assertTrue(areEqual(expected, merger.mergeTwoLists(l1, l2)));
    }

    @Test
    public void testMergeTwoLists_Scenario12() {
        MergeTwoSortedLists.ListNode l1 = createList(new int[]{1, 2, 3, 4});
        MergeTwoSortedLists.ListNode l2 = createList(new int[]{5, 6, 7, 8});
        MergeTwoSortedLists.ListNode expected = createList(new int[]{1, 2, 3, 4, 5, 6, 7, 8});
        assertTrue(areEqual(expected, merger.mergeTwoLists(l1, l2)));
    }

    @Test
    public void testMergeTwoLists_Scenario13() {
        MergeTwoSortedLists.ListNode l1 = createList(new int[]{5, 6, 7, 8});
        MergeTwoSortedLists.ListNode l2 = createList(new int[]{1, 2, 3, 4});
        MergeTwoSortedLists.ListNode expected = createList(new int[]{1, 2, 3, 4, 5, 6, 7, 8});
        assertTrue(areEqual(expected, merger.mergeTwoLists(l1, l2)));
    }

    @Test
    public void testMergeTwoLists_Scenario14() {
        MergeTwoSortedLists.ListNode l1 = createList(new int[]{1, 3, 5, 7, 9});
        MergeTwoSortedLists.ListNode l2 = createList(new int[]{2, 4, 6, 8, 10});
        MergeTwoSortedLists.ListNode expected = createList(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10});
        assertTrue(areEqual(expected, merger.mergeTwoLists(l1, l2)));
    }

    @Test
    public void testMergeTwoLists_Scenario15() {
        MergeTwoSortedLists.ListNode l1 = createList(new int[]{1, 2, 3, 4, 5});
        MergeTwoSortedLists.ListNode l2 = createList(new int[]{6, 7, 8, 9, 10});
        MergeTwoSortedLists.ListNode expected = createList(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10});
        assertTrue(areEqual(expected, merger.mergeTwoLists(l1, l2)));
    }

    @Test
    public void testMergeTwoLists_Scenario16() {
        MergeTwoSortedLists.ListNode l1 = createList(new int[]{6, 7, 8, 9, 10});
        MergeTwoSortedLists.ListNode l2 = createList(new int[]{1, 2, 3, 4, 5});
        MergeTwoSortedLists.ListNode expected = createList(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10});
        assertTrue(areEqual(expected, merger.mergeTwoLists(l1, l2)));
    }

    @Test
    public void testMergeTwoLists_Scenario17() {
        MergeTwoSortedLists.ListNode l1 = createList(new int[]{1, 2, 3, 4, 5, 6});
        MergeTwoSortedLists.ListNode l2 = createList(new int[]{7, 8, 9, 10, 11, 12});
        MergeTwoSortedLists.ListNode expected = createList(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12});
        assertTrue(areEqual(expected, merger.mergeTwoLists(l1, l2)));
    }

    @Test
    public void testMergeTwoLists_Scenario18() {
        MergeTwoSortedLists.ListNode l1 = createList(new int[]{7, 8, 9, 10, 11, 12});
        MergeTwoSortedLists.ListNode l2 = createList(new int[]{1, 2, 3, 4, 5, 6});
        MergeTwoSortedLists.ListNode expected = createList(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12});
        assertTrue(areEqual(expected, merger.mergeTwoLists(l1, l2)));
    }

    @Test
    public void testMergeTwoLists_Scenario19() {
        MergeTwoSortedLists.ListNode l1 = createList(new int[]{1, 2, 3, 4, 5, 6, 7});
        MergeTwoSortedLists.ListNode l2 = createList(new int[]{8, 9, 10, 11, 12, 13, 14});
        MergeTwoSortedLists.ListNode expected = createList(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14});
        assertTrue(areEqual(expected, merger.mergeTwoLists(l1, l2)));
    }

    @Test
    public void testMergeTwoLists_Scenario20() {
        MergeTwoSortedLists.ListNode l1 = createList(new int[]{8, 9, 10, 11, 12, 13, 14});
        MergeTwoSortedLists.ListNode l2 = createList(new int[]{1, 2, 3, 4, 5, 6, 7});
        MergeTwoSortedLists.ListNode expected = createList(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14});
        assertTrue(areEqual(expected, merger.mergeTwoLists(l1, l2)));
    }

    private MergeTwoSortedLists.ListNode createList(int[] vals) {
        MergeTwoSortedLists.ListNode dummy = new MergeTwoSortedLists.ListNode(0);
        MergeTwoSortedLists.ListNode current = dummy;
        for (int val : vals) {
            current.next = new MergeTwoSortedLists.ListNode(val);
            current = current.next;
        }
        return dummy.next;
    }

    private boolean areEqual(MergeTwoSortedLists.ListNode l1, MergeTwoSortedLists.ListNode l2) {
        while (l1 != null && l2 != null) {
            if (l1.val != l2.val) return false;
            l1 = l1.next;
            l2 = l2.next;
        }
        return l1 == null && l2 == null;
    }
}