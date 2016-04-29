package ru.itis.inform;

public class HashMap {
    private final static double LOAD_FACTOR = 0.75;
    private final static int DEFAULT_SIZE = 16;
    private int size;
    private int currentSize;
    private Entry[] hm;

    public HashMap() {
        size = DEFAULT_SIZE;
        hm = new Entry[size];
    }

    public int getSize() {
        return size;
    }

    public void add (String key, int value) {
        Entry en = new Entry(key, value);
        int index = index(en.getHash());
        if (hm[index] == null) {
            hm[index] = en;
        } else {
            en.setNext(hm[index]);
            hm[index] = en;
        }
        currentSize++;

        if (currentSize >= threshold()) {
            rehash();
        }
    }

    private void rehash() {
        size *= 2;
        Entry[] copy = hm;
        this.hm = new Entry[size];
        currentSize = 0;
        for (int i = 0; i < copy.length; i++) {
            if (copy[i] != null) {
                add(copy[i].getKey(), copy[i].getValue());
                while (copy[i].hasNext()) {
                    copy[i] = copy[i].getNext();
                    add(copy[i].getKey(), copy[i].getValue());
                }
            }
        }
    }

    public int get (String key) {
        int index = index(key.hashCode());
        if (key.equals(hm[index].getKey())) {
            return hm[index].getValue();
        }
        while (hm[index].hasNext()) {
            hm[index] = hm[index].getNext();
            if (key.equals(hm[index].getKey())) {
                return hm[index].getValue();
            }
        }
        return 0;
    }

    private int index (int hash) {
        return hash & (size - 1);
    }

    private int threshold() {
        double th = size*LOAD_FACTOR;
        return (int) th;
    }

    public void show() {
        for (int i = 0; i < hm.length; i++) {
            if (hm[i] != null) {
                System.out.print(hm[i].getKey() + "(" + hm[i].getValue() + ")   ");
                while (hm[i].hasNext()) {
                    hm[i] = hm[i].getNext();
                    System.out.print(hm[i].getKey() + "(" + hm[i].getValue() + ")   ");

                }
                System.out.println();
            } else {
                System.out.println("--------------------------------");
            }
        }
    }
}