
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class PasswordValidator {
    public static boolean isValid(String password) {
        return password.length() >= 8 && password.matches(".*[A-Z].*") && password.matches(".*\\d.*");
    }
}

public class PasswordValidatorTest {
    @Test
    public void testValidPasswords() {
        assertTrue(PasswordValidator.isValid("Strong1Pass"));
        assertTrue(PasswordValidator.isValid("Hello123"));
    }

    @Test
    public void testInvalidPasswords() {
        assertFalse(PasswordValidator.isValid("short"));
        assertFalse(PasswordValidator.isValid("nouppercase1"));
        assertFalse(PasswordValidator.isValid("NOLOWERCASE1"));
        assertFalse(PasswordValidator.isValid("NoDigitsHere"));
    }
}

