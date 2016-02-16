package ru.itis.inform;

public class Node {
    private RationalNumber value;
    private Node next;

    public Node(RationalNumber value) {
        this.value = value;
    }

    public RationalNumber getValue() {
        return this.value;
    }

    public Node getNext() {
        return this.next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}
