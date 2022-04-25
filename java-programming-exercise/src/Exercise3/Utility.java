package Exercise3;

public class Utility {
    // generate random number within given range
    public static double getRand(double min, double max) {
        return ((Math.random() * (max - min)) + min);
    }
}
