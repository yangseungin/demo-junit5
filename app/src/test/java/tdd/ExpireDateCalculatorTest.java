package tdd;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ExpireDateCalculatorTest {

//    TODO 서비스를 사용하려면 매달 1만원을 선불로 납부한다. 납부일 기준으로 한달뒤가 서비스 만료일이 된다.
//    TODO 2개월 이상 요금을 납부할 수 있다.
//    TODO 10만원을 납부하면 서비스를 1년 제공한다.

    @Test
    void 만원_납부시_한달뒤가_만료일() {
        assertExpireDate(
                LocalDate.of(2022, 3, 21),
                10_000,
                LocalDate.of(2022, 4, 21)
        );

        assertExpireDate(
                LocalDate.of(2022, 6, 6),
                10_000,
                LocalDate.of(2022, 7, 6)
        );
    }

    private void assertExpireDate(LocalDate billingDate, int payAmount, LocalDate expectedExpireDate) {
        ExpireDateCalculator expireDateCalculator = new ExpireDateCalculator();
        LocalDate expireDate = expireDateCalculator.calculateExpireDate(billingDate, payAmount);

        assertEquals(expectedExpireDate, expireDate);
    }


}
