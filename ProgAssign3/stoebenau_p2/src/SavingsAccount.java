public class SavingsAccount {
    static double annualInterestRate;
    private double savingsBalance;

    public SavingsAccount(double savingsBalance) {
        this.savingsBalance = savingsBalance;
    }

    public double getSavingsBalance() {
        return savingsBalance;
    }

    public double calculateMonthlyInterest() {
        double interest = savingsBalance * annualInterestRate / 12;

        this.savingsBalance += interest;

        return interest;
    }

    public static void modifyInterestRate(double interestRate) {
        annualInterestRate = interestRate;
    }
}
