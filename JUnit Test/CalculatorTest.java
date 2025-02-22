import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class Calculator {
    int add(int a, int b) {
        return a + b;
    }
    int subtract(int a, int b) {
        return a - b;
    }
    int multiply(int a, int b) {
        return a * b;
    }
    int divide(int a, int b) {
        if (b == 0) throw new ArithmeticException("Cannot divide by zero");
        return a / b;
    }
}

public class CalculatorTest {
    Calculator calc = new Calculator();

    @Test
    void testAdd() {
        assertEquals(5, calc.add(2, 3));
    }
    
    @Test
    void testSubtract() {
        assertEquals(1, calc.subtract(3, 2));
    }
    
    @Test
    void testMultiply() {
        assertEquals(6, calc.multiply(2, 3));
    }
    
    @Test
    void testDivide() {
        assertEquals(2, calc.divide(6, 3));
    }
    
    @Test
    void testDivideByZero() {
        assertThrows(ArithmeticException.class, () -> calc.divide(5, 0));
    }
}

