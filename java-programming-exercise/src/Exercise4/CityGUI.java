package Exercise4;

import java.awt.Color;
import java.awt.event.*;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class CityGUI extends JComponent implements MouseListener {
    // fields
    private double x;
    private double y;
    protected JFrame addCityWindow = new JFrame("Add city");
    protected JLabel nameLabel = new JLabel("Name:");
    protected JTextField nameTextField = new JTextField();
    protected JLabel sizeLabel = new JLabel("Size:");
    protected JTextField sizeTextField = new JTextField();
    protected JButton okButton = new JButton("OK");

    // constructor
    public CityGUI() {
        this.setFocusable(true);
        this.addMouseListener(this);
    }

    // implement MouseListener method
    @Override
    public void mouseClicked(MouseEvent e) {
        this.x = e.getPoint().getX();
        this.y = e.getPoint().getY();
        System.out.println("Mouse clicked at coords:" + " x: " + x + ", y: " + y);

        // create new window on mouse click, center, set bg color
        addCityWindow.setSize(300, 200);
        addCityWindow.setLocationRelativeTo(null);
        addCityWindow.getContentPane().setBackground(new Color(200, 200, 200));

        // set layout
        addCityWindow.setLayout(null);

        // create and add components to window
        nameLabel.setBounds(50, 20, 80, 25);
        addCityWindow.add(nameLabel);

        nameTextField.setBounds(100, 20, 165, 25);
        addCityWindow.add(nameTextField);

        sizeLabel.setBounds(50, 50, 80, 25);
        addCityWindow.add(sizeLabel);

        sizeTextField.setBounds(100, 50, 165, 25);
        addCityWindow.add(sizeTextField);

        okButton.setBounds(100, 100, 80, 25);
        addCityWindow.add(okButton);

        // set window visible
        addCityWindow.setVisible(true);
    }

    // getters
    public double getXloc() {
        return x;
    }

    public double getYloc() {
        return y;
    }

    // unused implemented methods
    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

}
