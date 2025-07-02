/**
 * 
 */

/**
 * 
 */
public interface y_a_LoanPayable {
    double  ANNUAL_RATE_TO_MONTHLY_RATE = 1/1200.0;

    double calculateLoanPayment(double principal, double annualRate, int amortizationPeriod);
}
