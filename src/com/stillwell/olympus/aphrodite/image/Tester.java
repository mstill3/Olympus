package com.stillwell.olympus.aphrodite.image;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Tester extends JFrame {

    private static final long serialVersionUID = 1L;
    static ImageEditor edit;

    public static void main(String[] args) throws IOException {

        edit = new ImageEditor(ImageIO.read(new File("res/back.jpg")));
        new Tester();
    }

    public Tester() {
        setVisible(true);
        setSize(500, 500);
        getContentPane().add(new Pan());
        addMouseListener(new Mouse());
        addMouseMotionListener(new Mouse());
    }

    public class Pan extends JPanel {

        private static final long serialVersionUID = 1L;

        public void paint(Graphics gc) {
            gc.drawImage(edit.getBufferedImage(), 0, 0, null);
        }

    }

    public class Mouse implements MouseMotionListener, MouseListener {

        public Mouse() {

        }

        public void mouseDragged(MouseEvent e) {

        }

        public void mouseMoved(MouseEvent e) {
            if (e.getX() > 0 && e.getX() < edit.width()
                    && e.getY() > 0 && e.getY() < edit.height()) {
                System.out.println(edit.getColor(e.getX(), e.getY()));
            } else {
                System.out.println("Out of Bounds");
            }
        }

        public void mouseClicked(MouseEvent e) {
            edit.invertColor();
            repaint();
        }

        public void mouseEntered(MouseEvent e) {

        }

        public void mouseExited(MouseEvent e) {

        }

        public void mousePressed(MouseEvent e) {

        }

        public void mouseReleased(MouseEvent e) {

        }

    }

}
