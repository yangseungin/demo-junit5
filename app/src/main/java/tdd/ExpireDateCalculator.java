package tdd;

import java.time.LocalDate;

public class ExpireDateCalculator {
    public LocalDate calculateExpireDate(LocalDate billingDate, int payAmount) {
        return billingDate.plusMonths(1);
    }
}
