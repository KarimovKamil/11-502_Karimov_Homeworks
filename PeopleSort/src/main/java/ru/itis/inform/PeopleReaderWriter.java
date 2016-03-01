package ru.itis.inform;

import java.io.*;
import java.nio.file.*;

public class PeopleReaderWriter {
    public LinkedList<Human> read(String fileName) throws IOException {
        FileReader file = new FileReader(fileName);
        BufferedReader reader = new BufferedReader(file);
        LinkedList<Human> list = new LinkedList<Human>();

        String line = reader.readLine();
        list.add(createHumanFromString(line));

        while (line != null) {
            line = reader.readLine();
            if (line != null) {
                Human newHuman = createHumanFromString(line);
                list.add(newHuman);
            }
        }
        return list;
    }

    public void write(LinkedList<Human> list) {
        writePeople(list, "./output.txt");
    }

    public void write(LinkedList<Human> list, String path) {
        writePeople(list, path);
    }

    public void writePeople(LinkedList<Human> list, String path) {
        Node<Human> node = list.getFirst();
        String value = node.toString() + "\n";

        Path file = Paths.get(path);

        try {
            Files.write(file, value.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }

        node = node.getNext();
        while (node != null) {
            value = node.toString() + "\n";
            try {
                Files.write(file, value.getBytes(), StandardOpenOption.APPEND);
            } catch (IOException e) {
                e.printStackTrace();
            }
            node = node.getNext();
        }
    }

    public Human createHumanFromString(String params) {
        String[] attributes = params.split(" ");
        return new Human(attributes[0], Integer.parseInt(attributes[1]));
    }
}
