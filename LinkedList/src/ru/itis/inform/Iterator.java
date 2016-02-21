package ru.itis.inform;

public interface Iterator<T> {
    boolean hasNext();
    T next();
    T previous();
    T peekNext();
    T peekPrevious();
    void insert(T element);
}
