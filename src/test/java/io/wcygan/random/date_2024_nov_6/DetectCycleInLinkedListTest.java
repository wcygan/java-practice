package io.wcygan.random.date_2024_nov_6;

import org.junit.Test;
import static org.junit.Assert.*;

public class DetectCycleInLinkedListTest {
    private DetectCycleInLinkedList detector = new DetectCycleInLinkedList();

    @Test
    public void testHasCycle() {
        DetectCycleInLinkedList.ListNode node1 = new DetectCycleInLinkedList.ListNode(3);
        DetectCycleInLinkedList.ListNode node2 = new DetectCycleInLinkedList.ListNode(2);
        DetectCycleInLinkedList.ListNode node3 = new DetectCycleInLinkedList.ListNode(0);
        DetectCycleInLinkedList.ListNode node4 = new DetectCycleInLinkedList.ListNode(-4);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node2; // Creates a cycle
        assertTrue(detector.hasCycle(node1));

        DetectCycleInLinkedList.ListNode node5 = new DetectCycleInLinkedList.ListNode(1);
        DetectCycleInLinkedList.ListNode node6 = new DetectCycleInLinkedList.ListNode(2);
        node5.next = node6;
        node6.next = null;
        assertFalse(detector.hasCycle(node5));

        assertFalse(detector.hasCycle(null));
    }
}