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
    private PopulationData[] popDataObjs;
    private BufferedImage map;
    private File imgFile = new File(System.getProperty("user.dir") + "/map.png");

    // constructors
    public PopulationDisplay(String path) throws FileNotFoundException {
        popDataObj = new PopulationData(path);
        map = new BufferedImage(popDataObj.getCols(), popDataObj.getRows(), BufferedImage.TYPE_INT_RGB);
    }

    public PopulationDisplay(String[] paths) throws FileNotFoundException {
        popDataObjs = new PopulationData[paths.length];
        for (int i = 0; i < popDataObjs.length; i++) {
            popDataObjs[i] = new PopulationData(paths[i]);
        }
    }

    // methods
    public int getRows() {
        return popDataObj.getRows();
    }

    public int getCols() {
        return popDataObj.getCols();
    }

    // get pixel colour based on passed value
    public int getColour(int i, int j) {
        double pixelData = popDataObj.getPixelData(i, j);

        if (pixelData == popDataObj.getNoDataVal()) {
            return new Color(63, 205, 255).getRGB();
        } else if (pixelData > 100) {
            return new Color(238, 67, 54).getRGB();
        } else if (pixelData > 25) {
            return new Color(234, 109, 53).getRGB();
        } else if (pixelData > 5) {
            return new Color(233, 115, 52).getRGB();
        } else if (pixelData > 1) {
            return new Color(227, 169, 100).getRGB();
        } else if (pixelData < 1) {
            return new Color(224, 195, 124).getRGB();
        } else {
            return new Color(222, 219, 178).getRGB();
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        // set BufferedImage pixels using density values from popData
        for (int i = 0; i < popDataObj.getRows(); i++) {
            for (int j = 0; j < popDataObj.getCols(); j++) {
                map.setRGB(j, i, getColour(i, j));
            }
        }

        // draw image
        g.drawImage(map, 0, 0, popDataObj.getCols() / 6, popDataObj.getRows() / 6, this);

        // save image to file
        try {
            ImageIO.write(map, "png", imgFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}