package io.wcygan.random.date_2024_nov_6;

public class ReverseString {
    /**
     * Reverses the given string.
     *
     * @param s The string to reverse.
     * @return The reversed string.
     */
    public String reverse(String s) {
        if (s == null) return null;

        // Strings are immutable!
        char[] chars = s.toCharArray();

        for (int i = 0; i < (chars.length / 2); i++) {
            char a = s.charAt(i);
            char b = s.charAt(chars.length - i - 1);
            chars[i] = b;
            chars[chars.length - i - 1] = a;
        }

        return new String(chars);
    }
}