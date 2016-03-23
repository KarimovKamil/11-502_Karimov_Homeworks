package ru.itis.inform;

import java.util.ArrayList;

public class ConvexHull {
    public ArrayList<Point> convexHull(ArrayList<Point> array) {
        ArrayList<Point> arrayPoints = new ArrayList<Point>(array.size());

        Point firstPoint = array.get(0);
        for (int i = 1; i < array.size(); i++) {
            if ((firstPoint.getY() > array.get(i).getY()) | (firstPoint.getY() == array.get(i).getY() && firstPoint.getX() > array.get(i).getX() ) ) {
                firstPoint = array.get(i);
            }
        }
        arrayPoints.add(firstPoint);

        double cos = -1;
        int position = 0;
        for (int  i = 0; i < array.size(); i++) {
            if (angleCos(new Point(firstPoint.getX() + 2, firstPoint.getY()), firstPoint, array.get(i)) > cos) {
                cos = angleCos(new Point(firstPoint.getX() + 2, firstPoint.getY()), firstPoint, array.get(i));
                position = i;
            }
        }
        arrayPoints.add(array.get(position));
        array.remove(position);

        int i = 1;
        while (!equality(arrayPoints.get(0), arrayPoints.get(arrayPoints.size() - 1))) {
            cos = 1;
            position = 0;
            for (int j = 0; j < array.size(); j++) {
                if (cos > angleCos(arrayPoints.get(i - 1), arrayPoints.get(i), array.get(j))) {
                    cos = angleCos(arrayPoints.get(i - 1), arrayPoints.get(i), array.get(j));
                    position = j;
                }
            }
            arrayPoints.add(array.get(position));
            array.remove(position);
            i++;
        }
        arrayPoints.remove(arrayPoints.size() - 1);
        return arrayPoints;
    }

    public double angleCos (Point a, Point b, Point c) {
        int x1 = a.getX() - b.getX();
        int x2 = c.getX() - b.getX();
        int y1 = a.getY() - b.getY();
        int y2 = c.getY() - b.getY();
        double legnth1 = Math.sqrt(x1*x1 + y1*y1);
        double legnth2 = Math.sqrt(x2*x2 + y2*y2);
        double cos = (x1*x2 + y1*y2)/(legnth1*legnth2);
        return cos;
    }

    public boolean equality (Point a, Point b) {
        if (a.getX() == b.getX() && a.getY() == b.getY())
            return true;
        else
            return false;
    }
}
