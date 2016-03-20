package ru.itis.inform;

public class Main {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<Integer>();
        Iterator<Integer> iterator = list.iterator();

        list.add(-5);
        list.addEnd(4);
        list.addEnd(10);
        list.addEnd(-10);
        list.addEnd(17);
        list.addEnd(1);

        list = LinkedList.mergeSort(list);
        iterator = list.iterator();

        while (iterator.hasNext()) {
            System.out.print(iterator.peekNext() + "  ");
            iterator.next();
        }
    }
}
