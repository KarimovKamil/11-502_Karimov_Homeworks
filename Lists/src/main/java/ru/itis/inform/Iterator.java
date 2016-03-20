package ru.itis.inform;

public interface Iterator<T> {
    boolean hasNext();
    T peekNext();
    T peekPrevious();
    void next();
    void previous();
    void insert(T element);
    Node getNext();
}
