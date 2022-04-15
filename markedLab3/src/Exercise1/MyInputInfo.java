package Exercise1;

public class MyInputInfo implements Comparable<MyInputInfo> {
    // fields
    private String type;
    private String keyInput;
    private Double checker;

    // constructor
    public MyInputInfo(String input) {
        /*
         * try catch block to attempt to convert input to Double
         * in order to detect if input is a numeric
         */
        try {
            checker = Double.parseDouble(input);
            type = "Numeric";
        } catch (NumberFormatException e) {
            type = "Symbol";
        }
        keyInput = input;
    }

    // implement comparable interface compareTo method
    @Override
    public int compareTo(MyInputInfo other) {
        /*
         * compare input types first, if input types are equal then compare
         * input values against each other
         */
        if (this.type.equals("Numeric") && this.type.equals(other.type)) {
            if (this.keyInput.equals(other.keyInput)) {
                return 0;
            }
            if (Double.parseDouble(this.keyInput) > Double.parseDouble(other.keyInput)) {
                return 1;
            } else {
                return -1;
            }
        }
        if (this.type.equals("Symbol") && this.type.equals(other.type)) {
            return this.keyInput.compareTo(other.keyInput);
        }
        if (this.type.equals("Numeric") && other.type.equals("Symbol")) {
            return -1;
        } else {
            return 1;
        }
    }

    // toString override
    @Override
    public String toString() {
        return type + ' ' + keyInput;
    }
}