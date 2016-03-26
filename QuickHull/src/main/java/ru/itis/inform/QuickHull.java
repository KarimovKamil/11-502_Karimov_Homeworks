package ru.itis.inform;

import java.util.ArrayList;

public class QuickHull {
    public ArrayList<Point> QuickHull(ArrayList<Point> array){
        int indexLeft = findLeft(array);
        int indexRight = findRight(array);
        ArrayList<Point> arrayQH = new ArrayList<Point>();

        Point left = array.get(indexLeft);
        Point right = array.get(indexRight);

        array.remove(left);
        array.remove(right);

        ArrayList<Point> S1 = S1(array, left, right);
        ArrayList<Point> S2 = S2(array, left, right);
        arrayQH.add(left);

        QuickHullAlg(S1, left, right, arrayQH);
        arrayQH.add(right);
        QuickHullAlg(S2, right, left, arrayQH);

        return arrayQH;
    }

    public int findLeft(ArrayList<Point> array){
        int min = array.get(0).getX();
        int indexLeft = 0;

        for(int i = 0; i < array.size(); i++) {
            if (array.get(i).getX() < min) {
                min = array.get(i).getX();
                indexLeft = i;
            }
        }
        return indexLeft;
    }

    public int findRight(ArrayList<Point> array){
        int max = array.get(0).getX();
        int indexRight = 0;

        for(int i = 0; i < array.size(); i++) {
            if (array.get(i).getX() > max) {
                max = array.get(i).getX();
                indexRight = i;
            }
        }
        return indexRight;
    }

    public int separator(Point left, Point p, Point right){
        int l = right.getX() - left.getX();
        int m = right.getY() - left.getY();

        int result = p.getX() * m - left.getX() * m - ( p.getY() * l - left.getY() * l);

        return result;
    }

    public double area(Point left, Point current, Point right){
        return Math.abs(0.5*((left.getX() - right.getX())*(current.getY() - right.getY()) - (current.getX() - right.getX())*(left.getY() - right.getY())));
    }

    public int triangleBelong(Point p1, Point p2, Point p3, Point p) {
        int check = -1;
        double sign1 = (p1.getX() - p.getX()) * (p2.getY() - p1.getY()) - (p2.getX() - p1.getX()) * (p1.getY() - p.getY());
        double sign2 = (p2.getX() - p.getX()) * (p3.getY() - p2.getY()) - (p3.getX() - p2.getX()) * (p2.getY() - p.getY());
        double sign3 = (p3.getX() - p.getX()) * (p1.getY() - p3.getY()) - (p1.getX() - p3.getX()) * (p3.getY() - p.getY());
        if(sign1 > 0 && sign2 > 0 && sign3 > 0 || sign1 < 0 && sign2 < 0 && sign3 < 0)
            check = 1;
        else if(sign1 == 0 || sign2 == 0 || sign3 == 0)
            check = 0;
        return check;
    }

    public ArrayList<Point> S1(ArrayList<Point> array, Point left, Point right){
        ArrayList<Point> S1 = new ArrayList<Point>();

        for(int i = 0; i < array.size(); i++){
            if(separator(left, array.get(i), right) < 0)
                S1.add(array.get(i));
        }
        return S1;
    }

    public ArrayList<Point> S2(ArrayList<Point> array, Point left, Point right){
        ArrayList<Point> S2 = new ArrayList<Point>();

        for(int i = 0; i < array.size(); i++){
            if(separator(left, array.get(i), right) > 0)
                S2.add(array.get(i));
        }
        return S2;
    }

    public void QuickHullAlg(ArrayList<Point> S, Point left, Point right, ArrayList<Point> arrayQH){

        if(S.size() == 0)
            return;

        double maxS = area(left, S.get(0), right);
        int indexOfMax = 0;

        for(int i = 1; i < S.size(); i++) {
            if (area(left, S.get(i), right) > maxS) {
                maxS = area(left, S.get(i), right);
                indexOfMax = i;
            } else if (area(left, S.get(i), right) == maxS && S.get(indexOfMax).getX() > S.get(i).getX()) {
                maxS = area(left, S.get(i), right);
                indexOfMax = i;
            }
        }

        Point top = S.get(indexOfMax);

        for(int i = 0; i < S.size(); i++){
            if(triangleBelong(left, right, S.get(indexOfMax), S.get(i)) >= 0)
                S.remove(i);
        }

        ArrayList<Point> S1 = S1(S, left, top);
        ArrayList<Point> S2 = S2(S, right, top);
        QuickHullAlg(S1, left, right, arrayQH);
        arrayQH.add(top);
        QuickHullAlg(S2, top, right, arrayQH);
    }
}