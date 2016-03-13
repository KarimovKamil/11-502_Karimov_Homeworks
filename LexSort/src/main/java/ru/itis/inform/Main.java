package ru.itis.inform;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        HumansReaderWriter reader = new HumansReaderWriter();
        String path = "./people.txt";

        LinkedList<Human> list = reader.read(path);

        HumansSorter sorter = new HumansSorter();
        LinkedList<Human> res = sorter.sortByName(list);

        reader.write(res, "./output.txt");
    }
}
