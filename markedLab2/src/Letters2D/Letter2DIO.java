package Letters2D;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

class Letter2DIO {
    // min and max XY coordinates
    final static private int maxX = 500;
    final static private int maxY = 500;

    /*
     * create specified number of Letter2D objects,
     * randomly generate Letter2D object properties using Random class,
     * write Letter2D objects to specified filename using PrintStream
     */
    public static void writeRandomLetters(String file, int num) throws FileNotFoundException {
        PrintStream out = new PrintStream(file);
        Random r = new Random();

        for (int i = 0; i < num; i++) {
            // gen random lowercase letter
            char randChar = (char) (r.nextInt(26) + 'a');

            // create Letter2D obj from random values
            Letter2D letter2D = new Letter2D(r.nextInt(maxX), r.nextInt(maxY), randChar);

            // write to file
            out.println(letter2D.toString());
        }
        out.close();
    }

    /*
     * read specified number of lines from specified file,
     * convert each line to Letter2D object and append object to Letter2D array,
     * return Letter2D array
     */
    public static Letter2D[] readLetters(String file, int num) throws FileNotFoundException {
        Scanner input = new Scanner(new File(file));
        // set delimeters
        input.useDelimiter(",|\n");

        Letter2D[] letter2DArr = new Letter2D[num];

        // convert each line to object and add object to letter2Darr[]
        int i = 0;
        while (input.hasNextLine() && i < num) {
            letter2DArr[i] = new Letter2D(input.nextInt(), input.nextInt(), input.next().charAt(0));
            input.nextLine();
            i++;
        }
        input.close();

        // return arr, exclude empty entries
        return Arrays.copyOf(letter2DArr, i);
    }
}