import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static utility.BracketUtility.*;


class BracketUtilityTest {
    private static final String INVALID_FIRST = "())(()())))";
    private static final String INVALID_SECOND = ")(";
    private static final String VALID_FIRST = "()()()";
    private static final String VALID_SECOND = "(((()()(()(())))))";

    @Test
    void isValidByMathShouldThorIllegalArgumentException() {
        Exception exception = assertThrows(
                IllegalArgumentException.class,
                () -> isValidByMath(null));

        assertTrue(exception.getMessage().contains("Parameter is null"));
    }

    @Test
    void isValidByStackShouldThorIllegalArgumentException() {
        Exception exception = assertThrows(
                IllegalArgumentException.class,
                () -> isValidByStack(null));

        assertTrue(exception.getMessage().contains("Parameter is null"));
    }

    @Test
    void isValidByRegExShouldThorIllegalArgumentException() {
        Exception exception = assertThrows(
                IllegalArgumentException.class,
                () -> isValidByRegEx(null));

        assertTrue(exception.getMessage().contains("Parameter is null"));
    }

    @Test
    void isValidByMathShouldReturnTrue() {
        assertTrue(isValidByMath(VALID_FIRST));
        assertTrue(isValidByMath(VALID_SECOND));
    }

    @Test
    void isValidByRegExShouldReturnTrue() {
        assertTrue(isValidByRegEx(VALID_FIRST));
        assertTrue(isValidByRegEx(VALID_SECOND));
    }

    @Test
    void isValidByStackShouldReturnTrue() {
        assertTrue(isValidByStack(VALID_FIRST));
        assertTrue(isValidByStack(VALID_SECOND));
    }


    @Test
    void isValidByMathShouldReturnFalse() {
        assertFalse(isValidByMath(INVALID_FIRST));
        assertFalse(isValidByMath(INVALID_SECOND));
    }

    @Test
    void isValidByRegExShouldReturnFalse() {
        assertFalse(isValidByRegEx(INVALID_FIRST));
        assertFalse(isValidByRegEx(INVALID_SECOND));
    }

    @Test
    void isValidByStackShouldReturnFalse() {
        assertFalse(isValidByStack(INVALID_FIRST));
        assertFalse(isValidByStack(INVALID_SECOND));
    }
}