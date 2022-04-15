package Exercise2;

public class Account {
    // fields
    private String name = new String();
    private int number;
    protected double balance;

    // constructor
    public Account(String name, int number) {
        this.name = name;
        this.number = number;
        balance = 0;
    }

    // getter methods
    public String getName() {
        return name;
    }

    public int getNumber() {
        return number;
    }

    public double getBalance() {
        return balance;
    }
}