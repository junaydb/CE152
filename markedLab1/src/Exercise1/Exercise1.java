package Exercise1;

class Exercise1 {
    void printOddUpTo(int num) {
        // only execute if num is not negative
        if (num > 0) {
            // inclusive for loop from 0 to num
            for (int i = 0; i <= num; i++) {
                // if i not divisible by 2 (odd), print i
                if (i % 2 != 0) {
                    System.out.println(i);
                }
            }
        }
    }

    String getABCUpTo(char letter) {
        if (Character.isLetter(letter)) {
            // create StringBuilder obj
            StringBuilder abc = new StringBuilder();
            // convert letter to upper case, then to ASCII value via typecast
            int letterASCII = (int) Character.toUpperCase(letter);
            // inclusive for loop, range of i starts at 'A' ASCII value
            for (int i = 65; i <= letterASCII; i++) {
                // convert i to char and append to abc
                abc.append((char) i);
            }
            return abc.toString();
        } else {
            String empty = null;
            return empty;
        }
    }
}