package io.wcygan.random.date_2024_nov_6;

import org.junit.Test;
import static org.junit.Assert.*;

public class DetectCycleInLinkedListTest {
    private DetectCycleInLinkedList detector = new DetectCycleInLinkedList();

    @Test
    public void testHasCycle1() {
        DetectCycleInLinkedList.ListNode node1 = new DetectCycleInLinkedList.ListNode(3);
        DetectCycleInLinkedList.ListNode node2 = new DetectCycleInLinkedList.ListNode(2);
        DetectCycleInLinkedList.ListNode node3 = new DetectCycleInLinkedList.ListNode(0);
        DetectCycleInLinkedList.ListNode node4 = new DetectCycleInLinkedList.ListNode(-4);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node2; // Creates a cycle
        assertTrue(detector.hasCycle(node1));
    }

    @Test
    public void testHasCycle2() {
        DetectCycleInLinkedList.ListNode node1 = new DetectCycleInLinkedList.ListNode(1);
        DetectCycleInLinkedList.ListNode node2 = new DetectCycleInLinkedList.ListNode(2);
        node1.next = node2;
        node2.next = node1; // Creates a cycle
        assertTrue(detector.hasCycle(node1));
    }

    @Test
    public void testHasCycle3() {
        DetectCycleInLinkedList.ListNode node1 = new DetectCycleInLinkedList.ListNode(1);
        node1.next = node1; // Single node cycle
        assertTrue(detector.hasCycle(node1));
    }

    @Test
    public void testHasCycle4() {
        DetectCycleInLinkedList.ListNode node1 = new DetectCycleInLinkedList.ListNode(1);
        DetectCycleInLinkedList.ListNode node2 = new DetectCycleInLinkedList.ListNode(2);
        node1.next = node2;
        node2.next = null; // No cycle
        assertFalse(detector.hasCycle(node1));
    }

    @Test
    public void testHasCycle5() {
        DetectCycleInLinkedList.ListNode node1 = new DetectCycleInLinkedList.ListNode(1);
        node1.next = null; // Single node, no cycle
        assertFalse(detector.hasCycle(node1));
    }

    @Test
    public void testHasCycle6() {
        assertFalse(detector.hasCycle(null)); // Null list
    }

    @Test
    public void testHasCycle7() {
        DetectCycleInLinkedList.ListNode node1 = new DetectCycleInLinkedList.ListNode(1);
        DetectCycleInLinkedList.ListNode node2 = new DetectCycleInLinkedList.ListNode(2);
        DetectCycleInLinkedList.ListNode node3 = new DetectCycleInLinkedList.ListNode(3);
        node1.next = node2;
        node2.next = node3;
        node3.next = node1; // Creates a cycle
        assertTrue(detector.hasCycle(node1));
    }

    @Test
    public void testHasCycle8() {
        DetectCycleInLinkedList.ListNode node1 = new DetectCycleInLinkedList.ListNode(1);
        DetectCycleInLinkedList.ListNode node2 = new DetectCycleInLinkedList.ListNode(2);
        DetectCycleInLinkedList.ListNode node3 = new DetectCycleInLinkedList.ListNode(3);
        node1.next = node2;
        node2.next = node3;
        node3.next = null; // No cycle
        assertFalse(detector.hasCycle(node1));
    }

    @Test
    public void testHasCycle9() {
        DetectCycleInLinkedList.ListNode node1 = new DetectCycleInLinkedList.ListNode(1);
        DetectCycleInLinkedList.ListNode node2 = new DetectCycleInLinkedList.ListNode(2);
        DetectCycleInLinkedList.ListNode node3 = new DetectCycleInLinkedList.ListNode(3);
        DetectCycleInLinkedList.ListNode node4 = new DetectCycleInLinkedList.ListNode(4);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node2; // Creates a cycle
        assertTrue(detector.hasCycle(node1));
    }

    @Test
    public void testHasCycle10() {
        DetectCycleInLinkedList.ListNode node1 = new DetectCycleInLinkedList.ListNode(1);
        DetectCycleInLinkedList.ListNode node2 = new DetectCycleInLinkedList.ListNode(2);
        DetectCycleInLinkedList.ListNode node3 = new DetectCycleInLinkedList.ListNode(3);
        DetectCycleInLinkedList.ListNode node4 = new DetectCycleInLinkedList.ListNode(4);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = null; // No cycle
        assertFalse(detector.hasCycle(node1));
    }

    @Test
    public void testHasCycle11() {
        DetectCycleInLinkedList.ListNode node1 = new DetectCycleInLinkedList.ListNode(1);
        DetectCycleInLinkedList.ListNode node2 = new DetectCycleInLinkedList.ListNode(2);
        DetectCycleInLinkedList.ListNode node3 = new DetectCycleInLinkedList.ListNode(3);
        DetectCycleInLinkedList.ListNode node4 = new DetectCycleInLinkedList.ListNode(4);
        DetectCycleInLinkedList.ListNode node5 = new DetectCycleInLinkedList.ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node2; // Creates a cycle
        assertTrue(detector.hasCycle(node1));
    }

    @Test
    public void testHasCycle12() {
        DetectCycleInLinkedList.ListNode node1 = new DetectCycleInLinkedList.ListNode(1);
        DetectCycleInLinkedList.ListNode node2 = new DetectCycleInLinkedList.ListNode(2);
        DetectCycleInLinkedList.ListNode node3 = new DetectCycleInLinkedList.ListNode(3);
        DetectCycleInLinkedList.ListNode node4 = new DetectCycleInLinkedList.ListNode(4);
        DetectCycleInLinkedList.ListNode node5 = new DetectCycleInLinkedList.ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = null; // No cycle
        assertFalse(detector.hasCycle(node1));
    }

    @Test
    public void testHasCycle13() {
        DetectCycleInLinkedList.ListNode node1 = new DetectCycleInLinkedList.ListNode(1);
        DetectCycleInLinkedList.ListNode node2 = new DetectCycleInLinkedList.ListNode(2);
        DetectCycleInLinkedList.ListNode node3 = new DetectCycleInLinkedList.ListNode(3);
        DetectCycleInLinkedList.ListNode node4 = new DetectCycleInLinkedList.ListNode(4);
        DetectCycleInLinkedList.ListNode node5 = new DetectCycleInLinkedList.ListNode(5);
        DetectCycleInLinkedList.ListNode node6 = new DetectCycleInLinkedList.ListNode(6);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node3; // Creates a cycle
        assertTrue(detector.hasCycle(node1));
    }

    @Test
    public void testHasCycle14() {
        DetectCycleInLinkedList.ListNode node1 = new DetectCycleInLinkedList.ListNode(1);
        DetectCycleInLinkedList.ListNode node2 = new DetectCycleInLinkedList.ListNode(2);
        DetectCycleInLinkedList.ListNode node3 = new DetectCycleInLinkedList.ListNode(3);
        DetectCycleInLinkedList.ListNode node4 = new DetectCycleInLinkedList.ListNode(4);
        DetectCycleInLinkedList.ListNode node5 = new DetectCycleInLinkedList.ListNode(5);
        DetectCycleInLinkedList.ListNode node6 = new DetectCycleInLinkedList.ListNode(6);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = null; // No cycle
        assertFalse(detector.hasCycle(node1));
    }

    @Test
    public void testHasCycle15() {
        DetectCycleInLinkedList.ListNode node1 = new DetectCycleInLinkedList.ListNode(1);
        DetectCycleInLinkedList.ListNode node2 = new DetectCycleInLinkedList.ListNode(2);
        DetectCycleInLinkedList.ListNode node3 = new DetectCycleInLinkedList.ListNode(3);
        DetectCycleInLinkedList.ListNode node4 = new DetectCycleInLinkedList.ListNode(4);
        DetectCycleInLinkedList.ListNode node5 = new DetectCycleInLinkedList.ListNode(5);
        DetectCycleInLinkedList.ListNode node6 = new DetectCycleInLinkedList.ListNode(6);
        DetectCycleInLinkedList.ListNode node7 = new DetectCycleInLinkedList.ListNode(7);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        node7.next = node4; // Creates a cycle
        assertTrue(detector.hasCycle(node1));
    }

    @Test
    public void testHasCycle16() {
        DetectCycleInLinkedList.ListNode node1 = new DetectCycleInLinkedList.ListNode(1);
        DetectCycleInLinkedList.ListNode node2 = new DetectCycleInLinkedList.ListNode(2);
        DetectCycleInLinkedList.ListNode node3 = new DetectCycleInLinkedList.ListNode(3);
        DetectCycleInLinkedList.ListNode node4 = new DetectCycleInLinkedList.ListNode(4);
        DetectCycleInLinkedList.ListNode node5 = new DetectCycleInLinkedList.ListNode(5);
        DetectCycleInLinkedList.ListNode node6 = new DetectCycleInLinkedList.ListNode(6);
        DetectCycleInLinkedList.ListNode node7 = new DetectCycleInLinkedList.ListNode(7);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        node7.next = null; // No cycle
        assertFalse(detector.hasCycle(node1));
    }

    @Test
    public void testHasCycle17() {
        DetectCycleInLinkedList.ListNode node1 = new DetectCycleInLinkedList.ListNode(1);
        DetectCycleInLinkedList.ListNode node2 = new DetectCycleInLinkedList.ListNode(2);
        DetectCycleInLinkedList.ListNode node3 = new DetectCycleInLinkedList.ListNode(3);
        DetectCycleInLinkedList.ListNode node4 = new DetectCycleInLinkedList.ListNode(4);
        DetectCycleInLinkedList.ListNode node5 = new DetectCycleInLinkedList.ListNode(5);
        DetectCycleInLinkedList.ListNode node6 = new DetectCycleInLinkedList.ListNode(6);
        DetectCycleInLinkedList.ListNode node7 = new DetectCycleInLinkedList.ListNode(7);
        DetectCycleInLinkedList.ListNode node8 = new DetectCycleInLinkedList.ListNode(8);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        node7.next = node8;
        node8.next = node5; // Creates a cycle
        assertTrue(detector.hasCycle(node1));
    }

    @Test
    public void testHasCycle18() {
        DetectCycleInLinkedList.ListNode node1 = new DetectCycleInLinkedList.ListNode(1);
        DetectCycleInLinkedList.ListNode node2 = new DetectCycleInLinkedList.ListNode(2);
        DetectCycleInLinkedList.ListNode node3 = new DetectCycleInLinkedList.ListNode(3);
        DetectCycleInLinkedList.ListNode node4 = new DetectCycleInLinkedList.ListNode(4);
        DetectCycleInLinkedList.ListNode node5 = new DetectCycleInLinkedList.ListNode(5);
        DetectCycleInLinkedList.ListNode node6 = new DetectCycleInLinkedList.ListNode(6);
        DetectCycleInLinkedList.ListNode node7 = new DetectCycleInLinkedList.ListNode(7);
        DetectCycleInLinkedList.ListNode node8 = new DetectCycleInLinkedList.ListNode(8);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        node7.next = node8;
        node8.next = null; // No cycle
        assertFalse(detector.hasCycle(node1));
    }

    @Test
    public void testHasCycle19() {
        DetectCycleInLinkedList.ListNode node1 = new DetectCycleInLinkedList.ListNode(1);
        DetectCycleInLinkedList.ListNode node2 = new DetectCycleInLinkedList.ListNode(2);
        DetectCycleInLinkedList.ListNode node3 = new DetectCycleInLinkedList.ListNode(3);
        DetectCycleInLinkedList.ListNode node4 = new DetectCycleInLinkedList.ListNode(4);
        DetectCycleInLinkedList.ListNode node5 = new DetectCycleInLinkedList.ListNode(5);
        DetectCycleInLinkedList.ListNode node6 = new DetectCycleInLinkedList.ListNode(6);
        DetectCycleInLinkedList.ListNode node7 = new DetectCycleInLinkedList.ListNode(7);
        DetectCycleInLinkedList.ListNode node8 = new DetectCycleInLinkedList.ListNode(8);
        DetectCycleInLinkedList.ListNode node9 = new DetectCycleInLinkedList.ListNode(9);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        node7.next = node8;
        node8.next = node9;
        node9.next = node6; // Creates a cycle
        assertTrue(detector.hasCycle(node1));
    }

    @Test
    public void testHasCycle20() {
        DetectCycleInLinkedList.ListNode node1 = new DetectCycleInLinkedList.ListNode(1);
        DetectCycleInLinkedList.ListNode node2 = new DetectCycleInLinkedList.ListNode(2);
        DetectCycleInLinkedList.ListNode node3 = new DetectCycleInLinkedList.ListNode(3);
        DetectCycleInLinkedList.ListNode node4 = new DetectCycleInLinkedList.ListNode(4);
        DetectCycleInLinkedList.ListNode node5 = new DetectCycleInLinkedList.ListNode(5);
        DetectCycleInLinkedList.ListNode node6 = new DetectCycleInLinkedList.ListNode(6);
        DetectCycleInLinkedList.ListNode node7 = new DetectCycleInLinkedList.ListNode(7);
        DetectCycleInLinkedList.ListNode node8 = new DetectCycleInLinkedList.ListNode(8);
        DetectCycleInLinkedList.ListNode node9 = new DetectCycleInLinkedList.ListNode(9);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        node7.next = node8;
        node8.next = node9;
        node9.next = null; // No cycle
        assertFalse(detector.hasCycle(node1));
    }
}