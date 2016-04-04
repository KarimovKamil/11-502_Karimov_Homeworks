package ru.itis.inform;

import java.util.ArrayList;

public class Konj {
    public ArrayList<Integer> konj = new ArrayList<Integer>();
    private int size = 0;

    public ArrayList<Integer> getKonj() {
        return this.konj;
    }

    public void setKonj (Konj konj) {
        this.konj = konj.getKonj();
        this.size = konj.getSize();
    }

    public void addToKonj (int number) {
        this.konj.add(number);
        size++;
    }

    public String toString () {
        String s = "";
        for (int i = 0; i < konj.size(); i++) {
            if (konj.get(i) < 0)
                s += "-";
            s += "x" + Math.abs(konj.get(i));
            if (i < konj.size() - 1)
                s += "&";
        }
        return s;
    }

    public int getSize() {
        return this.size;
    }
}
