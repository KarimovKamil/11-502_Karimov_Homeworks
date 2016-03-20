package ru.itis.inform;

public class LinkedList<T> implements List<T> {
    private Node first;

    private int length;

    public LinkedList() {
        this.first = null;
        this.length = 0;
    }

    public boolean isEmpty() {
        if (this.first == null) {
            return true;
        } else return false;
    }

    public int getLength() {
        return this.length;
    }

    public void add(T element) {
        Node newNode = new Node<T>(element);
        newNode.setPrevious(null);

        if (first == null) {
            this.first = newNode;
        } else {
            newNode.setNext(this.first);
            this.first.setPrevious(newNode);
            this.first = newNode;
        }
        this.length++;
    }

    public void addEnd(T element) {
        Node newNode = new Node<T>(element);
        Node last = this.first;

        if (last == null) {
            this.first = newNode;
        } else {
            while (last.getNext() != null) {
                last = last.getNext();
            }
            last.setNext(newNode);
            newNode.setPrevious(last);
            newNode.setNext(null);
        }
        this.length++;
    }

    public void remove(T element) {
        Node node = this.first;
        Node previous = null;

        while (node.getValue() != element) {
            previous = node;
            node = node.getNext();
        }

        if (previous == null) {
            this.first = node.getNext();
        } else {

            if (node.getNext() != null) {
                previous.setNext(node.getNext());
            } else {
                previous.setNext(null);
            }
        }

        this.length--;
    }

    public void append(LinkedList<T> newList) {
        Node last = this.first;
        Iterator iterator = newList.iterator();

        if (!newList.isEmpty()) {

            if (last == null) {
                this.first = iterator.getNext();
            } else {
                while (last.getNext() != null) {
                    last = last.getNext();
                }
                last.setNext(iterator.getNext());
                iterator.getNext().setPrevious(last);
            }
        }
    }

    public void show() {
        Node<T> node = this.first;
        while(node != null) {
            node.show();
            node = node.getNext();
        }
    }

    public static <T extends Comparable<T>> LinkedList<T> merge(LinkedList<T> firstOne, LinkedList<T> secondOne) {
        LinkedList<T> list = new LinkedList<T>();
        Iterator<T> firstIterator = firstOne.iterator();
        Iterator<T> secondIterator = secondOne.iterator();

        int compare = firstIterator.peekNext().compareTo(secondIterator.peekNext());
        if (compare == 0) {
            list.add(firstIterator.peekNext());
            list.add(firstIterator.peekNext());
            firstIterator.next();
            secondIterator.next();
        } else {
            if (compare < 0) {
                list.add(firstIterator.peekNext());
                firstIterator.next();
            } else {
                list.add(secondIterator.peekNext());
                secondIterator.next();
            }
        }

        while (firstIterator.hasNext() && secondIterator.hasNext()) {
            compare = firstIterator.peekNext().compareTo(secondIterator.peekNext());
            if (compare == 0) {
                list.addEnd(firstIterator.peekNext());
                list.addEnd(firstIterator.peekNext());
                firstIterator.next();
                secondIterator.next();
            } else {
                if (compare < 0) {
                    list.addEnd(firstIterator.peekNext());
                    firstIterator.next();
                } else {
                    list.addEnd(secondIterator.peekNext());
                    secondIterator.next();
                }
            }
        }

        if (firstIterator.hasNext())
            while (firstIterator.hasNext()) {
                list.addEnd(firstIterator.peekNext());
                firstIterator.next();
            }

        if (secondIterator.hasNext())
            while (secondIterator.hasNext()) {
                list.addEnd(secondIterator.peekNext());
                secondIterator.next();
            }

        return list;
    }

    public static <T extends Comparable<T>> LinkedList<T> mergeSort(LinkedList<T> list) {
        ArrayList<LinkedList<T>> array = new ArrayList<LinkedList<T>>();
        int length = list.getLength();

        int last = 0;
        Iterator<T> iterator = list.iterator();

        for (int i = 0; i < length; i++) {
            array.add(new LinkedList<T>());
            LinkedList<T> newList = new LinkedList<T>();
            newList.add(iterator.peekNext());
            array.set(last, newList);
            iterator.next();
            last++;
            while ((last > 1) && (array.get(last - 1).getLength() == array.get(last - 2).getLength()) ){
                array.set(last - 2, merge(array.get(last - 2), array.get(last - 1)));
                last--;
            }
        }

        while (last > 1) {
            array.set(last - 2, merge(array.get(last - 2), array.get(last - 1)));
            last--;
        }

        return array.get(0);
    }

    public Iterator<T> iterator() {
        return new LinkedListIteratorImpl<T>(this.first);
    }
}
