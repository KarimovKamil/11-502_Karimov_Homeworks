package ru.itis.inform;

public class LinkedListIteratorImpl<T> implements Iterator<T> {
    Node<T> current;

    public LinkedListIteratorImpl(Node<T> first) {
        this.current = first;
    }

    public boolean hasNext() {
        return this.current != null;
    }

    public boolean hasPrevious() {
        return this.current.getPrevious() != null;
    }

    public T next() {
        T value = current.getValue();
        current = current.getNext();
        return value;
    }

    public T previous() {
        if (hasPrevious()){
            T value = this.current.getPrevious().getValue();
            this.current = current.getPrevious();
            return value;
        } else throw new NullPointerException();
    }

    public T peekNext() {
        return current.getNext().getValue();
    }

    public T peekPrevious() {
        return current.getPrevious().getValue();
    }

    public void insert(T element) {
        Node<T> newNode = new Node<T>(element);
        newNode.setNext(current);
        newNode.setPrevious(current.getPrevious());
        current.getPrevious().setNext(newNode);
        current.setPrevious(newNode);
    }
}
