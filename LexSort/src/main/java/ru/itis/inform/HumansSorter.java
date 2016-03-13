package ru.itis.inform;

public class HumansSorter {

    public LinkedList<Human> sortByName(LinkedList<Human> list) {
        int length = list.getFirst().getValue().getName().length();

        for (int index = length - 1; index >= 0; index--) {
            list = sortByIndex(list, index);
        }
        return list;
    }

    private LinkedList<Human> sortByIndex(LinkedList<Human> list, int index) {
        ArrayList<LinkedList<Human>> array = new ArrayList<LinkedList<Human>>(123);

        Node<Human> node = list.getFirst();

        while (node != null) {
            Human human = node.getValue();
            char letter;
            letter = human.getName().charAt(index);
            int number = (int) letter;

            setArrayElement(array, number, human);

            node = node.getNext();
        }

        return array.toLinkedList();
    }

    private void setArrayElement(ArrayList<LinkedList<Human>> array, int number, Human human) {
        if (array.get(number) == null) {
            LinkedList<Human> element = new LinkedList<Human>();
            element.add(human);
            array.set(number, element);
        } else {
            LinkedList<Human> element = array.get(number);
            element.add(human);
        }
    }

}
