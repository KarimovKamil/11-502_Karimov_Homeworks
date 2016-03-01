package ru.itis.inform;

public class PeopleSorter {
    public LinkedList<Human> sort(LinkedList<Human> list) {
        ArrayList<LinkedList<Human>> array = new ArrayList<LinkedList<Human>>(100);

        Node<Human> node = list.getFirst();

        while (node != null) {
            Human human = node.getValue();
            int age = human.getAge();

            if (array.get(age) == null) {
                LinkedList<Human> element = new LinkedList<Human>();
                element.add(human);
                array.set(age, element);
            } else {
                LinkedList<Human> element = (LinkedList<Human>) array.get(age);
                element.add(human);
            }

            node = node.getNext();
        }
        LinkedList<Human> result = array.toLinkedList();

        return result;
    }
}
