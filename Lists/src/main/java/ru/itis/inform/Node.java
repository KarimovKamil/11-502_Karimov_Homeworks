package ru.itis.inform;

public class Node<T> {
    private T value;
    private Node<T> next = null;
    private Node<T> previous = null;

    public Node(T value) {
        this.value = value;
    }

    public T getValue() {
        return this.value;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }

    public Node<T> getNext() {
        return this.next;
    }

    public void setPrevious(Node<T> previous) {
        this.previous = previous;
    }

    public Node<T> getPrevious() {
        return previous;
    }

    public boolean equals(Object node) {
        if (node == null) return false;
        if (node == this) return true;
        if (!(node instanceof Node)) return false;

        Node someNode = (Node) node;
        if (this.value.equals(someNode.getValue())) return true;
        return false;
    }

    @Override
    public String toString() {
        return this.value.toString();
    }

}
