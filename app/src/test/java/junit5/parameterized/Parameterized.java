package junit5.parameterized;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.time.Month;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class Parameterized {

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, -4, Integer.MAX_VALUE})
    void test(int num) {
        assertTrue(Numbers.isOdd(num));
    }

    @ParameterizedTest
    @EnumSource(Month.class)
    void testMonth(Month month) {
        int value = month.getValue();
        assertTrue(value >= 1 && value <= 12);
    }

    @ParameterizedTest
    @EnumSource(value = Month.class, names = {"JANUARY", "MARCH", "MAY"})
    void monthsAre31Days(Month month) {
        assertEquals(31, month.length(false));
    }

    @ParameterizedTest
    @CsvSource(value = {"test:TEST", "TesT:TEST", "Hello:HELLO"},delimiter = ':')
    void toUpperCase_ShouldGenerateTheExpectedUppercaseValue(String input, String expected) {
        String actualStr = input.toUpperCase();
        assertEquals(expected,actualStr);
    }


}
