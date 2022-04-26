package Exercise3;

import java.io.FileNotFoundException;
import javax.swing.JFrame;

public class MainPopulation {
    public static void main(String[] args) throws FileNotFoundException {
        PopulationDisplay popDisplay = new PopulationDisplay("lib/popData/pop2000.asc");

        // get rows and cols from file header
        int rows = popDisplay.getRows();
        int cols = popDisplay.getCols();

        // create JFrame, use row and col values to set aspect ratio
        JFrame f = new JFrame("Population Density");
        f.setSize(cols / 6, rows / 6);
        // add component
        f.add(popDisplay);
        // center window, set visible, set default close operation
        f.setLocationRelativeTo(null);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // for debug
        System.out.println("rows: " + rows + " cols: " + cols);
        System.out.println("window size: " + f.getSize());
    }
}
