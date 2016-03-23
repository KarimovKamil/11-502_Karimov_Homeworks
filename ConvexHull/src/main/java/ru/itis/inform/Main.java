package ru.itis.inform;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Point> array = new ArrayList<Point>();
        ArrayList<Point> arrayCH;
        ConvexHull ch = new ConvexHull();
        GraphDrawer graphDrawer = new GraphDrawer();

        array.add(new Point(0, 1));
        array.add(new Point(2, 1));
        array.add(new Point(-5, 3));
        array.add(new Point(3, 7));
        array.add(new Point(2, 4));
        array.add(new Point(3, 0));
        array.add(new Point(2, 6));
        array.add(new Point(1, 3));
        array.add(new Point(4, 1));
        array.add(new Point(-1, 2));
        array.add(new Point(-5, 3));

        arrayCH = ch.convexHull(array);

        graphDrawer.drawGraph(array, arrayCH);
        for (int i = 0; i < arrayCH.size(); i++) {
            System.out.println(arrayCH.get(i).toString());
        }
    }
}
