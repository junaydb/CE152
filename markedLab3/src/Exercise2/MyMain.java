package Exercise2;

import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.*;

public class MyMain {
    public static void main(String[] args) {
        // instatiate frame and add MyComponent component
        JFrame frame = new JFrame("window");
        frame.getContentPane().setPreferredSize(new Dimension(400, 200));
        MyComponent component = new MyComponent();
        frame.add(component, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
