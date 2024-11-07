package io.wcygan.random.date_2024_nov_6;

public class MergeTwoSortedLists {
    /**
     * Merges two sorted linked lists and returns it as a new sorted list.
     *
     * @param l1 The first sorted linked list.
     * @param l2 The second sorted linked list.
     * @return The merged sorted linked list.
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // Base case: there is an empty list
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        if (l1.val > l2.val) {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        } else {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        }
    }

    // Definition for singly-linked list.
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}