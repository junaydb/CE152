package Exercise2;

public class MainExercise2 {
    public static void main(String[] args) {
        Checking winstonChecking = new Checking("Winston", 1234);
        Savings winstonSavings = new Savings("Winston", 5678, 1000, 0.03);

        System.out.println("Checking Account number: " + winstonChecking.getNumber());
        System.out.println("Checking Account holder: " + winstonChecking.getName());
        System.out.println("Checking Account balance: " + winstonChecking.getBalance());

        winstonChecking.deposit(152.15);

        System.out.println("Checking Account balance: " + winstonChecking.getBalance());

        winstonChecking.withdraw(52.15);

        System.out.println("Checking Account balance: " + winstonChecking.getBalance());
        System.out.println("Savings Account balance: " + winstonSavings.getBalance());
        System.out.println("Savings Account interest for 30 years: " + winstonSavings.accumulateInterest(30));
        System.out.println("Savings Account balance: " + winstonSavings.getBalance());
    }
}