package People;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

import java.io.*;
import java.util.Map;
import LinkedList.*;

public class PeopleReaderWriterTest {
    private PeopleReaderWriter readerWriter;
    private Human john = new Human("John", 37);
    private Human kate = new Human("Kate", 24);

    private String javadir() {
        Map<String, String> env = System.getenv();
        return env.get("JAVADIR");
    }

    @Before
    public void setUp() throws Exception {
        this.readerWriter = new PeopleReaderWriter();
    }

    @Test
    public void testRead() throws Exception {
        LinkedList<Human> list = new LinkedList<Human>();
        list.add(john);
        list.add(kate);

        String path = javadir() + "/PeopleSort/src/test/java/People/test.txt";

        LinkedList<Human> result = readerWriter.read(path);
        assertTrue(list.equals(result));
    }

    @Test
    public void testWrite() throws Exception {
        LinkedList<Human> list = new LinkedList<Human>();
        list.add(john);
        list.add(kate);

        String path = javadir() + "/PeopleSort/src/test/java/People/output.txt";

        readerWriter.write(list, path);

        File file = new File(path);

        assertTrue(file.exists());

        LinkedList result = readerWriter.read(path);

        LinkedList<Human> invertedResult = new LinkedList<Human>();
        invertedResult.add(kate);
        invertedResult.add(john);

        assertTrue(result.equals(invertedResult));
    }

    @Test
    public void testCreateHumanFromString() throws Exception {
        String humanString = "John 37";
        Human dave = new Human("John", 37);

        assertTrue(readerWriter.createHumanFromString(humanString).equals(dave));
    }
}