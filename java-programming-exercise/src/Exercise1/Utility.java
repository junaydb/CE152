package Exercise1;

public class Utility {
    // generate random number within given range
    public static double getRand(double min, double max) {
        return ((Math.random() * (max - min)) + min);
    }

    // round input to 2 dp
    public static double round(double input) {
        return Math.round(input * 100.0) / 100.0;
    }
}
