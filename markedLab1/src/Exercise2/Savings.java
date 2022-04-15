package Exercise2;

import java.text.DecimalFormat;

public class Savings extends Account {
    // fields
    private double interestRate;

    // constructor
    public Savings(String name, int number, double balance, double interestRate) {
        super(name, number);
        this.balance = balance;
        this.interestRate = interestRate;
    }

    // methods
    public double accumulateInterest(int years) {
        // DecimalFormat obj for rounding
        DecimalFormat dFormatter = new DecimalFormat("0.00");

        // calculate compound interest amount
        double gainedInterest = (balance * Math.pow((1 + interestRate), years)) - balance;
        // add to balance and round to 2dp
        balance = Double.parseDouble(dFormatter.format(balance + gainedInterest));

        // return gainedInterest rounded to 2dp
        return Double.parseDouble(dFormatter.format(gainedInterest));
    }
}
