package junit5.nested;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CalculatorTest {
    Calculator cal = new Calculator();
    final int NUM1 = 10;
    final int NUM2 = 2;

    @Test
    @DisplayName("sum메소드")
    void sum() {
        assertEquals(cal.sum(NUM1, NUM2), 12);
    }

    @Test
    @DisplayName("sub메소드")
    void sub() {
        assertEquals(cal.sub(NUM1, NUM2), 8);
    }

    @Test
    @DisplayName("mul메소드 범위 정상")
    void mul() {
        assertEquals(cal.mul(NUM1, NUM2), 20);
    }

    @Test
    @DisplayName("mul메소드 결과가 int범위 초과")
    void mul_over() {
        assertThrows(RuntimeException.class, () -> cal.mul(Integer.MAX_VALUE, 4));
    }

    @Test
    @DisplayName("div메소드 0이 아닌수로 나누기")
    void div() {
        assertEquals(cal.div(NUM1, NUM2), 5);
    }

    @Test
    @DisplayName("div메소드 0으로 나누기")
    void div_zero() {
        assertThrows(RuntimeException.class, () -> cal.div(NUM1, 0));
    }
}
