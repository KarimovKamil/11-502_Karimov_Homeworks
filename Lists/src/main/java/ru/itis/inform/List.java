package ru.itis.inform;

public interface List<T> {

    void add(T element);
    void remove(T element);
    void append(LinkedList<T> list);

    int getLength();

    Node<T> getFirst();
    Node<T> getLast();

}
