package tdd;

import org.junit.jupiter.api.Test;
import tdd.expire_date.ExpireDateCalculator;
import tdd.expire_date.PayData;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ExpireDateCalculatorTest {

//    TODO 서비스를 사용하려면 매달 1만원을 선불로 납부한다. 납부일 기준으로 한달뒤가 서비스 만료일이 된다.
//    TODO 2개월 이상 요금을 납부할 수 있다.
//    TODO 10만원을 납부하면 서비스를 1년 제공한다.

    @Test
    void 만원_납부시_한달뒤가_만료일() {
        assertExpireDate(
                PayData.builder()
                        .billingDate(LocalDate.of(2022, 3, 21))
                        .payAmount(10_000)
                        .build(),
                LocalDate.of(2022, 4, 21)

        );

        assertExpireDate(
                PayData.builder()
                        .billingDate(LocalDate.of(2022, 6, 6))
                        .payAmount(10_000)
                        .build(),
                LocalDate.of(2022, 7, 6)
        );

    }

    @Test
    void 납부일과_만료일의_일자가_다를때_만원납부() {
        PayData payData = PayData.builder()
                .firstBillingDate(LocalDate.of(2022, 1, 31))
                .billingDate(LocalDate.of(2022, 2, 28))
                .payAmount(10_000)
                .build();

        assertExpireDate(payData, LocalDate.of(2022, 3, 31));

        PayData payData2 = PayData.builder()
                .firstBillingDate(LocalDate.of(2022, 1, 30))
                .billingDate(LocalDate.of(2022, 2, 28))
                .payAmount(10_000)
                .build();

        assertExpireDate(payData2, LocalDate.of(2022, 3, 30));

        PayData payData3 = PayData.builder()
                .firstBillingDate(LocalDate.of(2022, 5, 31))
                .billingDate(LocalDate.of(2022, 6, 30))
                .payAmount(10_000)
                .build();

        assertExpireDate(payData3, LocalDate.of(2022, 7, 31));
    }
    @Test
    void n만원_이상납부하면_n달뒤_만료일() {
        assertExpireDate(
                PayData.builder()
                        .billingDate(LocalDate.of(2022,3,1))
                        .payAmount(20_000)
                        .build(),
                LocalDate.of(2022,5,1)
        );

        assertExpireDate(
                PayData.builder()
                        .billingDate(LocalDate.of(2022,3,1))
                        .payAmount(30_000)
                        .build(),
                LocalDate.of(2022,6,1)
        );
    }

    @Test
    void 첫납부일과_만료일자_다를때_n만원_이상납부() {
        assertExpireDate(
                PayData.builder()
                        .firstBillingDate(LocalDate.of(2022,1,31))
                        .billingDate(LocalDate.of(2022,2,28))
                        .payAmount(20_000)
                        .build(),
                LocalDate.of(2022,4,30)
        );

        assertExpireDate(
                PayData.builder()
                        .firstBillingDate(LocalDate.of(2022,3,31))
                        .billingDate(LocalDate.of(2022,4,30))
                        .payAmount(30_000)
                        .build(),
                LocalDate.of(2022,7,31)
        );
    }

    @Test
    void 십만원_납부하면_1년_제공() {
        assertExpireDate(
                PayData.builder()
                        .billingDate(LocalDate.of(2022,1,28))
                        .payAmount(100_000)
                        .build(),
                LocalDate.of(2023,1,28)

        );

        assertExpireDate(
                PayData.builder()
                        .billingDate(LocalDate.of(2022,1,28))
                        .payAmount(130_000)
                        .build(),
                LocalDate.of(2023,4,28)

        );
    }



    private void assertExpireDate(PayData payData, LocalDate expectedExpireDate) {
        ExpireDateCalculator expireDateCalculator = new ExpireDateCalculator();
        LocalDate expireDate = expireDateCalculator.calculateExpireDate(payData);

        assertEquals(expectedExpireDate, expireDate);
    }


}
