package tdd.expire_date;

import java.time.LocalDate;
import java.time.YearMonth;

public class ExpireDateCalculator {
    public LocalDate calculateExpireDate(PayData payData) {
        int monthsToAdd = payData.getPayAmount() >= 100_000 ? 12 + payData.getPayAmount() % 100_000 / 10_000 : payData.getPayAmount() / 10_000;
        if (payData.getFirstBillingDate() != null) {
            return getExpireDateUsingFirstBillingDate(payData, monthsToAdd);
        } else {

            return payData.getBillingDate().plusMonths(monthsToAdd);
        }
    }

    private LocalDate getExpireDateUsingFirstBillingDate(PayData payData, int monthsToAdd) {
        LocalDate candidateExp = payData.getBillingDate().plusMonths(monthsToAdd);
        int dayOfFirstBilling = payData.getFirstBillingDate().getDayOfMonth();

        if (dayOfFirstBilling != candidateExp.getDayOfMonth()) {
            int dayLenOfCandiMon = YearMonth.from(candidateExp).lengthOfMonth();
            if (dayLenOfCandiMon < dayOfFirstBilling) {
                return candidateExp.withDayOfMonth(dayLenOfCandiMon);
            }
            return candidateExp.withDayOfMonth(dayOfFirstBilling);
        } else {
            return candidateExp;
        }
    }
}
