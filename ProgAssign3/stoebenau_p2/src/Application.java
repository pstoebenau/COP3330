public class Application {
    public static void main(String[] args) {
        SavingsAccount saver1 = new SavingsAccount(2000.0);
        SavingsAccount saver2 = new SavingsAccount(3000.0);

        SavingsAccount.modifyInterestRate(0.04);
        System.out.println("Monthly interest rate changed to 0.04%");
        System.out.println();

        for (int i = 0; i <= 12; i++) {
            System.out.printf("Month %d\n", i);
            System.out.printf("Account 1 balance: $%.2f\n", saver1.getSavingsBalance());
            System.out.printf("Account 2 balance: $%.2f\n", saver2.getSavingsBalance());
            System.out.println();

            saver1.calculateMonthlyInterest();
            saver2.calculateMonthlyInterest();
        }

        SavingsAccount.modifyInterestRate(0.05);
        System.out.println("Monthly interest rate changed to 0.05%");
        System.out.println();

        saver1.calculateMonthlyInterest();
        saver2.calculateMonthlyInterest();

        System.out.printf("Account 1 balance: $%.2f\n", saver1.getSavingsBalance());
        System.out.printf("Account 2 balance: $%.2f\n", saver2.getSavingsBalance());
    }
}
