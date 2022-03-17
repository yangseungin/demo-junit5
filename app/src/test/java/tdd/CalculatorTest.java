package tdd;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorTest {

    @Test
    void sum(){
        int result = Calculator.sum(1,2);
        assertEquals(3,result);
        assertEquals(5,Calculator.sum(3,2));
    }
}
