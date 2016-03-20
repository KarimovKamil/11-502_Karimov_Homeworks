package ru.itis.inform;

public interface List<T> {

    void add(T element);
    void addEnd(T element);
    void remove(T element);
    boolean isEmpty();
    Iterator<T> iterator();

}
