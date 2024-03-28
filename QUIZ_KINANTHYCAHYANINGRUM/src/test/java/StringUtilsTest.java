import org.junit.jupiter.api.Test;

import static org.junit.Assert.*;
import org.example.StringUtils;

public class StringUtilsTest {
    @Test
    void testReverseString_NullInput_ReturnsNull() {
        assertNull(StringUtils.reverseString(null));
    }

    @Test
    void testReverseString_ValidInput_ReturnsReversedString() {
        assertEquals("cba", StringUtils.reverseString("abc"));
    }

    @Test
    void testIsPalindrome_NullInput_ReturnsFalse() {
        assertFalse(StringUtils.isPalindrome(null));
    }

    @Test
    void testIsPalindrome_ValidPalindrome_ReturnsTrue() {
        assertTrue(StringUtils.isPalindrome("radar"));
    }

    @Test
    void testIsPalindrome_NonPalindrome_ReturnsFalse() {
        assertFalse(StringUtils.isPalindrome("hello"));
    }

    @Test
    void testCountVowels_NullInput_ReturnsZero() {
        assertEquals(0, StringUtils.countVowels(null));
    }

    @Test
    void testCountVowels_ValidInput_ReturnsCorrectCount() {
        assertEquals(2, StringUtils.countVowels("hello"));
    }

}
