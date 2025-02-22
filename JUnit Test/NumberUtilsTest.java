import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class NumberUtils {
    public static boolean isEven(int number) {
        return number % 2 == 0;
    }
}

public class NumberUtilsTest {
    @ParameterizedTest
    @ValueSource(ints = {2, 4, 6})
    public void testIsEvenTrue(int number) {
        assertTrue(NumberUtils.isEven(number));
    }

    @ParameterizedTest
    @ValueSource(ints = {7, 9})
    public void testIsEvenFalse(int number) {
        assertFalse(NumberUtils.isEven(number));
    }
}

