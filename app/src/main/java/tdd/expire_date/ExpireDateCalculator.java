package tdd.expire_date;

import java.time.LocalDate;

public class ExpireDateCalculator {
    public LocalDate calculateExpireDate(PayData payData) {
        return payData.getBillingDate().plusMonths(1);
    }
}
