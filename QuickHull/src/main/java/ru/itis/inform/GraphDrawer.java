package ru.itis.inform;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class GraphDrawer {
    public void drawGraph (final ArrayList<Point> arrayPoints, final ArrayList<Point> arrayCH) {
        final int height = 600;
        final int width = 900;
        final int scale = 30;

        JFrame frame = new JFrame();
        frame.setSize(width, height);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("ConvexHull");

        JPanel panel = new JPanel() {
            Graphics2D g2;

            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g2 = (Graphics2D) g;
                g2.setColor(Color.black);
                g2.drawLine(0, height/2, width, height/2);
                g2.drawLine(width/2, 0, width/2, height);
                for(int i = 1; i < height/(2*scale); i++) {
                    g2.drawLine(width/2 - 10, height/2 + i*scale, width/2 + 10, height/2 + i*scale);
                    g2.drawLine(width/2 - 10, height/2 - i*scale, width/2 + 10, height/2 - i*scale);
                }
                for(int i = 1; i < width/(2*scale); i++) {
                    g2.drawLine(width/2 + i*scale, height/2 - 10, width/2 + i*scale, height/2 + 10);
                    g2.drawLine(width/2 - i*scale, height/2 - 10, width/2 - i*scale, height/2 + 10);
                }

                g2.setColor(Color.blue);
                for (int i = 0; i < arrayPoints.size(); i++) {
                    int x = setX(width, scale, arrayPoints.get(i).getX());
                    int y = setY(height, scale, arrayPoints.get(i).getY());
                    g2.drawOval(x - 2, y - 2, 4, 4);

                }
                for (int i = 0; i < arrayCH.size() - 1; i++) {
                    int x1 = setX(width, scale, arrayCH.get(i).getX());
                    int y1 = setY(height, scale, arrayCH.get(i).getY());
                    int x2 = setX(width, scale, arrayCH.get(i + 1).getX());
                    int y2 = setY(height, scale, arrayCH.get(i + 1).getY());
                    g2.drawOval(x1 - 2, y1 - 2, 4, 4);
                    g2.drawLine(x1, y1, x2, y2);
                }
                int x1 = setX(width, scale, arrayCH.get(0).getX());
                int y1 = setY(height, scale, arrayCH.get(0).getY());
                int x2 = setX(width, scale, arrayCH.get(arrayCH.size() - 1).getX());
                int y2 = setY(height, scale, arrayCH.get(arrayCH.size() - 1).getY());
                g2.drawLine(x1, y1, x2, y2);
                g2.drawOval(x2 - 2, y2 - 2, 4, 4);
            }
        };
        frame.setContentPane(panel);
    }

    public int setX (int width, int scale, int x) {
        int xc = width/2 + x*scale;
        return xc;
    }

    public int setY (int height, int scale, int y) {
        int yc = height/2 - y*scale;
        return yc;
    }

}
