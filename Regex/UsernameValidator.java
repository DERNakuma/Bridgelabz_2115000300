
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class UsernameValidator {
    public static boolean isValidUsername(String username) {
        return username.matches("^[A-Za-z][A-Za-z0-9_]{4,14}$");
    }
}

public class UsernameValidatorTest {
    @Test
    public void testValidUsernames() {
        assertTrue(UsernameValidator.isValidUsername("user_123"));
        assertTrue(UsernameValidator.isValidUsername("JohnDoe"));
    }

    @Test
    public void testInvalidUsernames() {
        assertFalse(UsernameValidator.isValidUsername("123user"));
        assertFalse(UsernameValidator.isValidUsername("us"));
        assertFalse(UsernameValidator.isValidUsername("user@name"));
    }
}

