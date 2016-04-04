package ru.itis.inform;

public interface BinarySearchTree {
    void insert(int element);

    void show();

    void inOrderPrint();

    boolean checkBinarySearchTree();

    boolean checkLevels();

    void change();

    void detourInWidth();
}
