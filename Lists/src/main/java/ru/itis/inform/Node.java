package ru.itis.inform;

public class Node<T> {
    private T value;
    private Node<T> next;
    private Node<T> previous;

    public Node(T value) {
        this.value = value;
        this.next = null;
        this.previous = null;
    }

    public void setNext(Node next) {
        this.next  = next;
    }

    public T getValue() {
        return value;
    }

    public Node<T> getNext() {
        return this.next;
    }

    public Node<T> getPrevious() {
        return this.previous;
    }

    public void setPrevious(Node previous) {
        this.previous = previous;
    }

    public void show() {
        System.out.print(value);
    }
}
