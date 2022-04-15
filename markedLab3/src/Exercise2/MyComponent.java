package Exercise2;

import javax.swing.*;
import java.awt.event.*;

public class MyComponent extends JComponent implements MouseListener, KeyListener {
    // component constructor
    public MyComponent() {
        this.setFocusable(true);
        this.addMouseListener(this);
        this.addKeyListener(this);
    }

    // implement MouseListener methods
    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println("Mouse button " + e.getButton() + " clicked.");
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        System.out.println("Mouse entered screen space");
    }

    @Override
    public void mouseExited(MouseEvent e) {
        System.out.println("Mouse exited screen space");
    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    // implement KeyListener methods
    @Override
    public void keyTyped(KeyEvent e) {
        System.out.println(e.getKeyChar() + " key typed");
    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}