package ru.itis.inform;

import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        ArrayCreator ac = new ArrayCreator();
        ReaderWriter rw = new ReaderWriter();
        ac.arraysCreator();
        int n = ac.getNumberOfArrays();
        long[] time = new long[n];
        int[] iterations = new int[n];
        TimSort ts = new TimSort();
        rw.remove("sortedN");
        for (int i = 0; i < n; i++) {
            String s = "arrayN" + i;
            ArrayList<Integer> array = rw.read(s);
            long start = System.nanoTime();
            int[] a = ts.timSort(array);
            long finish = System.nanoTime();
            rw.write("sortedN" + i, a);
            iterations[i] = ts.getIterations();
            time[i] = (finish - start);
            System.out.print(time[i] + "   ");
            System.out.println(iterations[i]);
        }
    }
}
