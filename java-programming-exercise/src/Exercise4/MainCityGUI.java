package Exercise4;

import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.event.*;

public class MainCityGUI implements ActionListener {
    // fields
    private static JFrame main = new JFrame("City GUI");
    private static CityGUI cityGUI = new CityGUI();

    public static void main(String[] args) {
        // set frame size
        main.setSize(600, 400);
        // add component to frame
        main.add(cityGUI);
        // add action listener to button
        cityGUI.okButton.addActionListener(new MainCityGUI());
        // center screen, set bg colour, set visible, set default close operation
        main.setLocationRelativeTo(null);
        main.getContentPane().setBackground(new Color(200, 200, 200));
        main.setVisible(true);
        main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    // implement ActionListener method for button click event
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Button clicked!");
        try {
            // draw city in main window
            DrawCity cityCircle = new DrawCity(cityGUI.nameTextField.getText(), (int) cityGUI.getXloc(),
                    (int) cityGUI.getYloc(),
                    Integer.parseInt(cityGUI.sizeTextField.getText()),
                    Integer.parseInt(cityGUI.sizeTextField.getText()));
            main.add(cityCircle);
            main.setVisible(true);

            // close addCityWindow
            cityGUI.addCityWindow.dispose();
        } catch (NumberFormatException err) {
            JLabel error = new JLabel("Size must be an integer value!");
            error.setBounds(60, 120, 200, 40);
            cityGUI.addCityWindow.add(error);
            cityGUI.addCityWindow.repaint();
        }
    }
}
