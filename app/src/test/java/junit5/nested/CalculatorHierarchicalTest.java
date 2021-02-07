package junit5.nested;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CalculatorHierarchicalTest {
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

    @Nested
    @DisplayName("mul 메소드는")
    class Describe_mul{
        @Nested
        @DisplayName("두 수의 곱이 int범위를 넘지 않으면")
        class Context_does_not_exceed_int_range{
            @Test
            @DisplayName("두수의 곱을 반환한다.")
            void it_return_int(){
                assertEquals(cal.mul(NUM1, NUM2), 20);
            }
        }

        @Nested
        @DisplayName("두 수의 곱이 int범위를 넘으면")
        class Context_exceed_int_range{
            @Test
            @DisplayName("RuntimeException을 던진다.")
            void it_return_exception(){
                assertThrows(RuntimeException.class, () -> cal.mul(Integer.MAX_VALUE, 4));
            }
        }
    }

    @Nested
    @DisplayName("div 메소드는")
    class Describe_div{
        @Nested
        @DisplayName("0이 아닌수로 나누면")
        class Context_not_divided_zero{
            @Test
            @DisplayName("나눈 결과값을 반환한다.")
            void it_return_int(){
                assertEquals(cal.div(NUM1, NUM2), 5);
            }
        }

        @Nested
        @DisplayName("0으로 나누면")
        class Context_divided_zero {
            @Test
            @DisplayName("RuntimeException을 던진다.")
            void it_return_exception() {
                assertThrows(RuntimeException.class, () -> cal.div(NUM1, 0));
            }
        }
    }
}
