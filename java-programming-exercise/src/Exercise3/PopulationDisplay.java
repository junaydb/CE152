package Exercise3;

import java.awt.Graphics;
import javax.imageio.ImageIO;
import javax.swing.JComponent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.awt.image.BufferedImage;
import java.awt.Color;

public class PopulationDisplay extends JComponent {
    // fields
    private PopulationData popDataObj;
    private BufferedImage map;
    private File testFile = new File(System.getProperty("user.dir") + "/map.png");

    // constructor
    public PopulationDisplay(String path) throws FileNotFoundException {
        popDataObj = new PopulationData(path);
        map = new BufferedImage(popDataObj.getRows(), popDataObj.getCols(), BufferedImage.TYPE_INT_RGB);
    }

    // methods
    public int getRows() {
        return popDataObj.getRows();
    }

    public int getCols() {
        return popDataObj.getCols();
    }

    // method for getting pixel colour based on density value
    public Color getColour(int i, int j) {
        double pixelData = popDataObj.getPixelData(i, j);

        if (pixelData == popDataObj.getNoDataVal()) {
            return new Color(63, 205, 255);
        } else if (pixelData > 100) {
            return new Color(238, 67, 54);
        } else if (pixelData > 25) {
            return new Color(234, 109, 53);
        } else if (pixelData > 5) {
            return new Color(233, 115, 52);
        } else if (pixelData > 1) {
            return new Color(227, 169, 100);
        } else if (pixelData < 1) {
            return new Color(224, 195, 124);
        } else {
            return new Color(222, 219, 178);
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        // set BufferedImage pixels using values from popData
        for (int i = 0; i < popDataObj.getRows(); i++) {
            for (int j = 0; j < popDataObj.getCols(); j++) {
                map.setRGB(i, j, getColour(i, j).getRGB());
            }
        }
        // draw and store BufferedImage to file
        g.drawImage(map, 0, 0, popDataObj.getCols(), popDataObj.getRows(), this);
        try {
            ImageIO.write(map, "png", testFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}