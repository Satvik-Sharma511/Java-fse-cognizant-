public class FinancialForecasting {

    /**
     * Recursive method to calculate the future value based on past growth rates.
     * 
     * @param presentValue The current or initial amount.
     * @param growthRate The growth rate per period (e.g., 0.05 for 5% growth).
     * @param periods The number of periods into the future.
     * @return The predicted future value.
     */
    public static double calculateFutureValue(double presentValue, double growthRate, int periods) {
        // 1. Base Case: If we have reached 0 periods, the future value is the present value.
        // This stops the recursion.
        if (periods == 0) {
            return presentValue;
        }
        
        // 2. Recursive Step: The future value for 'n' periods is the future value of 'n-1' periods,
        // multiplied by (1 + growth rate) for the current period.
        return calculateFutureValue(presentValue, growthRate, periods - 1) * (1 + growthRate);
    }
}
