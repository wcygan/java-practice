package io.wcygan.random.date_2024_nov_6;

public class DetectCycleInLinkedList {
    /**
     * Determines if the linked list has a cycle.
     *
     * @param head The head of the linked list.
     * @return True if there is a cycle, otherwise false.
     */
    public boolean hasCycle(ListNode head) {
        if (head == null) return false;

        ListNode turtle = head;
        ListNode rabbit = head.next;

        while (turtle != null && rabbit != null) {
            if (rabbit == turtle) return true;

            if (rabbit.next == null) break;
            rabbit = rabbit.next;

            if (rabbit.next == null) break;
            rabbit = rabbit.next;

            turtle = turtle.next;
        }

        return false;
    }

    // Definition for singly-linked list.
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}