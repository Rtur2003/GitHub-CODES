package app;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class CalculatorTest {
    private final Calculator calculator = new Calculator();

    @Test
    void addsNumbers() {
        assertEquals(7.0d, calculator.apply(2.0d, Operation.ADD, 5.0d));
    }

    @Test
    void subtractsNumbers() {
        assertEquals(-1.0d, calculator.apply(2.0d, Operation.SUBTRACT, 3.0d));
    }

    @Test
    void multipliesNumbers() {
        assertEquals(15.0d, calculator.apply(3.0d, Operation.MULTIPLY, 5.0d));
    }

    @Test
    void dividesNumbers() {
        assertEquals(2.5d, calculator.apply(5.0d, Operation.DIVIDE, 2.0d));
    }

    @Test
    void divisionByZeroThrows() {
        assertThrows(IllegalArgumentException.class, () -> calculator.apply(10.0d, Operation.DIVIDE, 0.0d));
    }
}
