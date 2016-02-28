package People;

import LinkedList.*;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        PeopleReaderWriter reader = new PeopleReaderWriter();
        String path = "./people.txt";

        LinkedList<Human> list = reader.read(path);

        PeopleSorter sorter = new PeopleSorter();
        LinkedList<Human> res = sorter.sort(list);

        reader.write(res, "./output.txt");
    }
}
