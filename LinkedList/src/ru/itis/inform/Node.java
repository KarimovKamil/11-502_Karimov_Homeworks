package ru.itis.inform;

public class Node<T> {
    private T value;
    private Node<T> next = null;
    private Node<T> previous = null;

    public Node(T value) {
        this.value = value;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }

    public T getValue() {
        return this.value;
    }

    public Node<T> getNext() {
        return this.next;
    }

    public Node<T> getPrevious() {
        return this.previous;
    }

    public void setPrevious(Node<T> previous) {
        this.previous = previous;
    }

    public boolean equals(Node<T> node) {
        if (node == null) return false;
        if (node == this) return true;
        if (this.value.equals(node.getValue())) return true;
        return false;
    }
}
