package io.wcygan.random.date_2024_nov_6;

import org.junit.Test;
import static org.junit.Assert.*;

public class ReverseStringTest {
    private final ReverseString reverseString = new ReverseString();

    @Test
    public void testReverseWithNormalString() {
        assertEquals("dcba", reverseString.reverse("abcd"));
    }

    @Test
    public void testReverseWithEmptyString() {
        assertEquals("", reverseString.reverse(""));
    }

    @Test
    public void testReverseWithSingleCharacter() {
        assertEquals("a", reverseString.reverse("a"));
    }

    @Test
    public void testReverseWithNull() {
        assertNull(reverseString.reverse(null));
    }
}