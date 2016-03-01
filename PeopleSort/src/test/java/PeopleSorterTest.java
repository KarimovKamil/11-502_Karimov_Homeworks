import org.junit.Test;
import ru.itis.inform.Human;
import ru.itis.inform.LinkedList;
import ru.itis.inform.PeopleReaderWriter;
import ru.itis.inform.PeopleSorter;

import static org.junit.Assert.*;

public class PeopleSorterTest {

    @Test
    public void testSort() {
        String[] names = { "John 37", "Kate 24", "Carl 21", "Rony 38" };

        LinkedList<Human> result = new LinkedList<Human>();
        LinkedList<Human> random = new LinkedList<Human>();

        PeopleReaderWriter creator = new PeopleReaderWriter();
        PeopleSorter sorter = new PeopleSorter();

        result.add(creator.createHumanFromString(names[1]));
        result.add(creator.createHumanFromString(names[2]));
        result.add(creator.createHumanFromString(names[3]));
        result.add(creator.createHumanFromString(names[0]));

        for (int i = 0; i < 4; i++) {
            random.add(creator.createHumanFromString(names[i]));
        }

        LinkedList<Human> randomResult = sorter.sort(random);

        assertTrue(randomResult.equals(result));
    }
}