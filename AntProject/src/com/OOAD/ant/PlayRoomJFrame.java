package com.OOAD.ant;

import javax.swing.*;
import java.awt.*;

public class PlayRoomJFrame {

    public static void main(String[] args) {
        JFrame w = new JFrame();
        MyPanel pw = new MyPanel();
        w.add(pw);
        w.setSize(500, 500);
        w.setVisible(true);

        Thread t = new Thread(pw);
        t.start();
    }

}

class MyPanel extends JPanel implements Runnable {

    private int x = 30;
    private int y = 30;

    public void paint(Graphics g) {
        super.paint(g);
        g.setColor(new Color(30, 34, 255));
        g.fillOval(x, y, 20, 20);
    }

    @Override
    public void run() {
        while (true) {
            x += 5;
            try {
                Thread.sleep(100);
            } catch (Exception e) {
            }
            repaint();
        }
    }
}
