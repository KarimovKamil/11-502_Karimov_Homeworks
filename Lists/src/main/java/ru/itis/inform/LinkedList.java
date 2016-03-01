package ru.itis.inform;

public class LinkedList<T> implements List<T> {
    private int length;
    private Node<T> first;
    private Node<T> last;

    public LinkedList() {
        this.first = null;
        this.last = null;
    }

    public Node<T> getFirst() {
        return this.first;
    }

    public Node<T> getLast() {
        return this.last;
    }

    public int getLength() {
        return this.length;
    }

    public void add(T element) {
        Node<T> newNode = new Node<T>(element);

        if(first == null) {
            this.first = newNode;
            this.last = newNode;
        } else {
            newNode.setNext(this.first);
            this.first.setPrevious(newNode);
            this.first = newNode;
        }
        this.length++;
    }

    public void remove(T element) {
        Node<T> node = this.first;

        if (node.getValue().equals(element)) {
            Node<T> next = first.getNext();
            next.setPrevious(null);
            this.first = first.getNext();
            this.length--;
            return;
        }

        for(int i = 0; i < length - 1; i++) {
            if(node.getNext().getValue().equals(element)) {
                if (i == length - 2) {
                    Node<T> next = null;
                    node.setNext(null);
                    length--;
                    return;
                } else {
                    Node<T> next = node.getNext().getNext();
                    node.setNext(next);
                    next.setPrevious(node);
                    length--;
                    return;
                }
            }
            node = node.getNext();
        }
    }

    public void append(LinkedList list) {
        this.last.setNext(list.getFirst());
        list.getFirst().setPrevious(this.last);
        this.last = list.getLast();
        this.length += list.getLength();
    }

    @Override
    public boolean equals (Object another) {
        if (another == null) return false;
        if (another == this) return true;
        if (!(another instanceof LinkedList)) return false;

        LinkedList anotherList = (LinkedList) another;

        if (this.length != anotherList.getLength()) return false;

        Node thisNode = first;
        Node anotherNode = (Node) anotherList.getFirst();

        while(anotherNode != null) {
            if (!(thisNode.equals(anotherNode))) return false;
            thisNode = thisNode.getNext();
            anotherNode = anotherNode.getNext();
        }
        return true;
    }

}
