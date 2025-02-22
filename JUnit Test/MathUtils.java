import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class MathUtils {
    public static int divide(int a, int b) {
        if (b == 0) throw new ArithmeticException("Division by zero");
        return a / b;
    }
}

public class MathUtilsTest {
    @Test
    public void testDivideByZero() {
        assertThrows(ArithmeticException.class, () -> MathUtils.divide(5, 0));
    }

    @Test
    public void testDivide() {
        assertEquals(2, MathUtils.divide(10, 5));
        assertEquals(-3, MathUtils.divide(-9, 3));
    }
}

