package ru.itis.inform;

public class Entry {
    private String key;
    private int value;
    private int hash;
    private Entry next;

    public Entry (String key, int value) {
        this.value = value;
        this.key = key;
        this.hash = key.hashCode();
    }

    public int getHash() {
        return hash;
    }

    public String getKey() {
        return key;
    }

    public Entry getNext() {
        return next;
    }

    public int getValue() {
        return value;
    }

    public void setNext(Entry next) {
        this.next = next;
    }

    public boolean hasNext() {
        return !(next == null);
    }

}