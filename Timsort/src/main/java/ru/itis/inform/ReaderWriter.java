package ru.itis.inform;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class ReaderWriter {
    public void write (String fileName, ArrayList<Integer> array) throws IOException {
        File file = new File("C:\\Users\\kkami\\IdeaProjects\\Timsort\\src\\main\\resources\\"+fileName+".txt");
        file.createNewFile();
        PrintWriter writer = new PrintWriter(file);
        for (int i = 0; i < array.size(); i++) {
            writer.print(array.get(i) + " ");
        }
        writer.close();
    }

    public void write (String fileName, int[] array) throws IOException {
        File file = new File("C:\\Users\\kkami\\IdeaProjects\\Timsort\\src\\main\\resources\\"+fileName+".txt");
        file.createNewFile();
        PrintWriter writer = new PrintWriter(file);
        for (int i = 0; i < array.length; i++) {
            writer.print(array[i] + " ");
        }
        writer.close();
    }

    public void remove (String filename) throws IOException {
        int i = 0;
        File file = new File("C:\\Users\\kkami\\IdeaProjects\\Timsort\\src\\main\\resources\\" + filename + i + ".txt");
        while (file.exists()) {
            file.delete();
            i++;
            file = new File("C:\\Users\\kkami\\IdeaProjects\\Timsort\\src\\main\\resources\\" + filename + i + ".txt");
        }
    }

    public ArrayList<Integer> read (String fileName) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("C:\\Users\\kkami\\IdeaProjects\\Timsort\\src\\main\\resources\\" + fileName + ".txt"));
        ArrayList<Integer> array = new ArrayList<Integer>();

        while (sc.hasNext()) {
            array.add(sc.nextInt());
        }

        sc.close();
        return array;
    }
}
