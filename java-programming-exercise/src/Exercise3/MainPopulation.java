package Exercise3;

import java.io.FileNotFoundException;
import javax.swing.JFrame;

public class MainPopulation {
    public static void main(String[] args) throws FileNotFoundException {
        PopulationDisplay popDisplay = new PopulationDisplay("lib/popData/pop2000.asc");
        int rows = popDisplay.getRows();
        int cols = popDisplay.getCols();

        // create JFrame, use nrows and ncols values from header to set aspect ratio
        JFrame f = new JFrame("Population Density");
        f.setSize(cols / 6, rows / 6);
        f.add(popDisplay);
        f.setLocationRelativeTo(null);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        System.out.println("rows: " + rows + " cols: " + cols);
        System.out.println("window size: " + f.getSize());
    }
}
