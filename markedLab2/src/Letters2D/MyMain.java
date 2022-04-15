package Letters2D;

import java.io.FileNotFoundException;
import java.util.Arrays;
import javax.swing.JFrame;

public class MyMain {
    public static void main(String[] args) throws FileNotFoundException {
        Letter2D[] letter2DArr;

        // write Letter2D objects to file
        Letter2DIO.writeRandomLetters("test.txt", 500);

        // read file and store Letter2D objs in array
        letter2DArr = Letter2DIO.readLetters("test.txt", 500);
        System.out.println(Arrays.toString(letter2DArr));

        // create window
        JFrame f = new JFrame();
        f.setSize(500, 500);
        // add component
        f.add(new Letter2DDisplay(letter2DArr));
        // set visibility and exit method
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
