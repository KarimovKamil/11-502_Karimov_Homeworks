package ArrayList;

import LinkedList.*;

public class ArrayList<T> {
    private int count = 0;
    private static final int DEFAULT_SIZE = 10;
    private Object[] elements;

    public ArrayList() {
        initArrayList(DEFAULT_SIZE);
    }

    public ArrayList(int count) {
        initArrayList(count);
    }

    private void initArrayList(int size) {
        this.elements = new Object[size];
    }

    public void add(T element) {
        set(count++, element);
    }

    public void set(int index, T element) {
        if (index > elements.length)
            throw new IndexOutOfBoundsException();

        if (index == elements.length)
            ensureCapacity();

        elements[index] = element;
    }

    public T get(int index) {
        if (index > elements.length|| index < 0)
            throw new IndexOutOfBoundsException();
        else return (T) elements[index];
    }

    public LinkedList toLinkedList() {
        LinkedList result = new LinkedList();
        for (int i = 0; i < elements.length; i++) {
            if (elements[i] != null) {
                LinkedList element;

                if(elements[i] instanceof LinkedList) {
                    element = (LinkedList) elements[i];
                } else {
                    element = new LinkedList();
                    element.add(elements[i]);
                }

                if (result.getFirst() == null) {
                    result = element;
                } else {
                    result.append(element);
                }
            }
        }
        return result;
    }

    public int getCount() {
        return this.count;
    }

    private void ensureCapacity() {
        int newSize = count * 3 / 2;
        Object[] newArray = new Object[newSize];

        for (int i = 0; i < count; i++) {
            newArray[i] = elements[i];
        }

        this.elements = newArray;
        count = newSize;
    }
}
