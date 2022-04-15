package Exercise2;

public class Checking extends Account {
    // constructor
    public Checking(String name, int number) {
        // call parent constructor
        super(name, number);
    }

    // methods
    public void deposit(double despositAmount) {
        balance += despositAmount;
    }

    public void withdraw(double withdrawAmount) {
        balance -= withdrawAmount;
    }
}