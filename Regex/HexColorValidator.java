import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class HexColorValidator {
    public static boolean isValidHexColor(String color) {
        return color.matches("^#[A-Fa-f0-9]{6}$");
    }
}

public class HexColorValidatorTest {
    @Test
    public void testValidHexColors() {
        assertTrue(HexColorValidator.isValidHexColor("#FFA500"));
        assertTrue(HexColorValidator.isValidHexColor("#ff4500"));
        assertTrue(HexColorValidator.isValidHexColor("#00FF00"));
    }

    @Test
    public void testInvalidHexColors() {
        assertFalse(HexColorValidator.isValidHexColor("#123"));
        assertFalse(HexColorValidator.isValidHexColor("FFA500"));
        assertFalse(HexColorValidator.isValidHexColor("#GGGGGG"));
    }
}

