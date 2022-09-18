package com.OOAD.ant;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class PlayRoomJFrame {

    public static void main(String[] args) {

        JFrame jFrame = new JFrame("Ant Creeping");

        jFrame.setSize(600, 500);
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        jFrame.setLayout(new BorderLayout());

        JButton button1 = new JButton("Start");
        button1.setSize(50, 30);
        JButton button2 = new JButton("Reset");
        button2.setSize(50, 30);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground((new Color(0, 127, 255, 255)));
        buttonPanel.setLayout(new FlowLayout());
        buttonPanel.add(button1);
        buttonPanel.add(button2);

        jFrame.add(buttonPanel, BorderLayout.NORTH);


        JLabel label = new JLabel("Time counting");
        jFrame.add(label, BorderLayout.SOUTH);

        CreepingGame cg = new CreepingGame(3, 5);
        cg.init();

        CreepPanel creepPanel = new CreepPanel(cg);
        jFrame.add(creepPanel, BorderLayout.CENTER);

        jFrame.setVisible(true);

        button1.addActionListener(event -> {
            Thread t = new Thread(creepPanel);
            t.start();
        });
    }

}

class CreepPanel extends JPanel implements Runnable {

    private CreepingGame cg;
    private int y = 30;

    public CreepPanel(CreepingGame cg) {
        super();
        this.cg = cg;
    }

    public void paint(Graphics g) {
        super.paint(g);
        g.setColor(new Color(25, 25, 255));
        g.drawLine(110, 15, 400, 15);
        List<Ant> ants = cg.getAnts();
        for (int i = 0; i < ants.size(); i++) {
            if (ants.get(i).getPosition() >= 0 && ants.get(i).getPosition() <= 300) {
                g.setColor(new Color(50 * i, 30 * (5 - i), 10 * i));
                g.fillOval(ants.get(i).getPosition() + 100, y, 10, 10);
            }
        }
    }

    @Override
    public void run() {
        while (!cg.GameOver()) {
            cg.run();
            try {
                Thread.sleep(200);
            } catch (Exception e) {
            }
            repaint();
        }
    }
}
