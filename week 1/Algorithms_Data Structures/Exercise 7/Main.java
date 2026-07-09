public class Main {
    public static void main(String[] args) {
        // Setup initial parameters for the financial forecast
        double presentValue = 1000.0; // Initial investment of $1000
        double growthRate = 0.05;     // 5% growth rate per period (year)
        int periods = 10;             // Predict 10 periods into the future

        System.out.println("--- Financial Forecasting ---");
        System.out.println("Present Value: $" + presentValue);
        System.out.println("Growth Rate:   " + (growthRate * 100) + "%");
        System.out.println("Periods:       " + periods);
        System.out.println("-----------------------------");

        // Implementation: Calculate the future value using the recursive algorithm
        double futureValue = FinancialForecasting.calculateFutureValue(presentValue, growthRate, periods);
        
        // Display the result formatted to 2 decimal places
        System.out.printf("Predicted Future Value: $%.2f%n", futureValue);
    }
}
