package Letters2D;

import javax.swing.*;
import java.awt.*;

class Letter2DDisplay extends JComponent {
    private Letter2D[] letters2D;

    // constructor
    public Letter2DDisplay(Letter2D[] letters2D) {
        this.letters2D = letters2D;
    }

    /*
     * draw chars using drawString method from Graphics class,
     * get values from Letter2D objects stored in letters2D array
     */
    @Override
    public void paintComponent(Graphics g) {
        for (int i = 0; i < letters2D.length; i++) {
            g.drawString(String.valueOf(letters2D[i].getChar()), letters2D[i].getX(), letters2D[i].getY());
        }
    }
}
