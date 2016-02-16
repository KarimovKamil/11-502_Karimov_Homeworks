package ru.itis.inform;

public class LinkedList {
    private Node first;

    public LinkedList() {
        this.first = null;
    }

    public Node getFirst() {
        return this.first;
    }

    public void add(RationalNumber element) {
        Node newNode = new Node(element);

        if (first == null) {
            this.first = newNode;
        } else {
            newNode.setNext(this.first);
            this.first = newNode;
        }
    }

    public void show() {
        Node node = first;

        while(node != null) {
            node.getValue().print();
            node = node.getNext();
        }
    }
}
