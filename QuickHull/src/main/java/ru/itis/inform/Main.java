package ru.itis.inform;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Point> array = new ArrayList<Point>();
        ArrayList<Point> arrayCH;
        QuickHull qh = new QuickHull();
        GraphDrawer graphDrawer = new GraphDrawer();

        array.add(new Point(1, 2));
        array.add(new Point(3, 1));
        array.add(new Point(-5, 3));
        array.add(new Point(-3, 5));
        array.add(new Point(-2, -4));
        array.add(new Point(6, 4));
        array.add(new Point(4, 2));
        array.add(new Point(2, 3));
        array.add(new Point(-1, -4));
        array.add(new Point(-1, 2));
        array.add(new Point(-5, -3));

        arrayCH = qh.QuickHull(array);

        graphDrawer.drawGraph(array, arrayCH);
        for (int i = 0; i < arrayCH.size(); i++) {
            System.out.println(arrayCH.get(i).toString());
        }
    }
}
