package ru.itis.inform;

public class Main {
    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTreeImpl();

        int array[] = {8, 10, 14, 1, 13, 6, 4, 7, 3};
        for (int i = 0; i < array.length; i++) {
            tree.insert(array[i]);
        }

      //  tree.change();

        System.out.println(tree.checkBinarySearchTree());
        System.out.println(tree.checkLevels());

        tree.show();
        tree.detourInWidth();

    }
}
