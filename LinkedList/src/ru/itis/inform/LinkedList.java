package ru.itis.inform;

public class LinkedList implements List {
    private Node first;

    private int length;

    public LinkedList() {
        this.first = null;
        this.length = 0;
    }

    public void add(int element) {
        Node newNode = new Node(element);

        if (first == null) {
            this.first = newNode;
        } else {
            newNode.setNext(this.first);
            this.first = newNode;
        }
        length += 1;
    }

    public void remove(int element) {
        Node node = this.first;
        for(int i = 0; i < length - 1; i++) {
            if(i == 0 && node.getValue() == element) {
                first = node.getNext();
                return;
            }

            if(node.getNext().getValue() == element) {
                if(i == 0) {
                    first = node;
                    return;
                } else if (i == length - 1) {
                    node.setNext(null);
                    return;
                } else {
                    node.setNext(node.getNext().getNext());
                    return;
                }
            }

            node = node.getNext();
        }
        length--;
    }

    public void show() {
        Node node = first;

        while(node.getNext() != null) {
            System.out.print(node.getValue() + ", ");
            node = node.getNext();
        }
        System.out.print(node.getValue());
    }
}

