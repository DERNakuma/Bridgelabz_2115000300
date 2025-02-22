
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class LicensePlateValidator {
    public static boolean isValidLicensePlate(String plate) {
        return plate.matches("^[A-Z]{2}\\d{4}$");
    }
}

public class LicensePlateValidatorTest {
    @Test
    public void testValidPlates() {
        assertTrue(LicensePlateValidator.isValidLicensePlate("AB1234"));
        assertTrue(LicensePlateValidator.isValidLicensePlate("XY5678"));
    }

    @Test
    public void testInvalidPlates() {
        assertFalse(LicensePlateValidator.isValidLicensePlate("A12345"));
        assertFalse(LicensePlateValidator.isValidLicensePlate("ABC123"));
        assertFalse(LicensePlateValidator.isValidLicensePlate("12AB34"));
    }
}


