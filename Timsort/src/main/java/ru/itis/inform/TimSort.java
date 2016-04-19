package ru.itis.inform;

import java.util.ArrayList;

public class TimSort {
    private int iterations = 0;

    public int[] timSort (ArrayList<Integer> arrayList) {
        int minrun = minrun(arrayList.size());
        int quantity;
        if (arrayList.size() % minrun == 0) {
            quantity = arrayList.size() / minrun;
        } else {
            quantity = arrayList.size() / minrun + 1;
        }
        int[][] arrays = new int[quantity][minrun];
        arrays[quantity - 1] = new int[arrayList.size() - (quantity - 1) * minrun];
        int i = 0;
        for (int j = 0; j < quantity; j++) {
            int k = 0;
            while (i < arrayList.size() && k < minrun) {
                arrays[j][k] = arrayList.get(i);
                k++;
                i++;
                iterations++;
            }
        }

        for (int j = 0; j < quantity; j++) {
            insertionSort(arrays[j]);
        }

        int l = quantity;
        while (l > 1) {
            int s = 0;
            for (int j = 0; j < l; j += 2) {
                if (arrays.length > j + 1 && arrays[j + 1][0] != 0) {
                    arrays[s] = merger(arrays[j], arrays[j + 1]);
                    s++;
                }
            }
            if (l % 2 == 1) {
                arrays[s] = arrays[l - 1];
                s++;
            }
            if (l % 2 == 0)
                l /= 2;
            else
                l = l/2 + 1;
        }
        return arrays[0];
    }


    private int minrun (int n) {
       int r = 0;
       while (n >= 64) {
           r |= n & 1;
           n >>= 1;
       }
       return n + r;
    }

    private int[] merger (int[] array1, int[] array2) {
        int[] a = new int[array1.length + array2.length];
        int i = 0;
        int j = 0;
        while (i < array1.length && j < array2.length) {
            if (array1[i] <= array2[j]) {
                a[i + j] = array1[i];
                i++;
                iterations++;
            } else {
                a[i + j] = array2[j];
                j++;
                iterations++;
            }
        }
        if (i < array1.length)
            for (int k = 0; k < array1.length - i; k++) {
                a[i + j + k] = array1[i + k];
                iterations++;
            }
        else
            for (int k = 0; k < array2.length - j; k++) {
                a[i + j + k] = array2[j + k];
                iterations++;
            }
        return a;
    }

    private void insertionSort(int[] array) {
        for(int i = 1; i < array.length; i++){
            int current = array[i];
            int prevKey = i - 1;
            while(prevKey >= 0 && array[prevKey] > current){
                array[prevKey+1] = array[prevKey];
                prevKey--;
                iterations++;
            }
            array[prevKey+1] = current;
        }
    }

    public int getIterations() {
        return iterations;
    }
}

