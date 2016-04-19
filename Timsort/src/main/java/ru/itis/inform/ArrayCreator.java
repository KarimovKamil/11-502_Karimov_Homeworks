package ru.itis.inform;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class ArrayCreator {
    private int numberOfArrays;
    public void arraysCreator() throws IOException {
        Random rd = new Random();
        ArrayList<Integer> array;
        ReaderWriter rw = new ReaderWriter();
        String s = "arrayN";
        rw.remove(s);
        int size = 200;
        numberOfArrays = rd.nextInt(10)+20;

        for (int j = 0; j < numberOfArrays; j++) {
            s =  "arrayN" + j;
            array = new ArrayList<Integer>(size);
            for (int i = 0; i < size; i++) {
                array.add(i, rd.nextInt(9000));
            }
            rw.write(s, array);
            size += 100;
        }
    }

    public int getNumberOfArrays() {
        return numberOfArrays;
    }
}
