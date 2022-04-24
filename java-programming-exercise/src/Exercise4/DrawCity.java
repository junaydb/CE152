package Exercise4;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JComponent;

public class DrawCity extends JComponent {
    // fields
    private String name;
    private int x;
    private int y;
    private int width;
    private int height;

    // constructor
    public DrawCity(String name, int x, int y, int width, int height) {
        this.name = name;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    @Override
    protected void paintComponent(Graphics g) {
        g.setColor(new Color(10, 10, 10));
        int offsetX = width / 2;
        int offsetY = height / 2;
        g.drawOval(x - offsetX, y - offsetY, width, height);
        g.drawString(name, x - 20, y);
    }
}
