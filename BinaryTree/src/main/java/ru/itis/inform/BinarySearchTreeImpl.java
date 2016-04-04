package ru.itis.inform;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class BinarySearchTreeImpl implements BinarySearchTree {
    private  Node root;

    private Node insertNode(Node root, int element)
    {
        if (root == null) {
            root = new Node(element);
            root.setLeft(null);
            root.setRight(null);
        } else if (element <= root.getData()) {
            root.setLeft(insertNode(root.getLeft(), element));
        } else {
            root.setRight(insertNode(root.getRight(), element));
        }

        return root;
    }

    private void showRec (Node root, int level) {
        if (root != null) {
            showRec(root.getRight(), level + 1);

            for (int i = 0; i < level; i++) {
                System.out.print("    ");
            }

            System.out.println(root.getData());

            showRec(root.getLeft(), level + 1);
        }
    }

    public void insert (int element) {
        this.root = insertNode(this.root, element);
    }

    public void show() {
        showRec(root, 0);
    }

    private void inOrder(Node root) {
        if (root != null) {
            inOrder(root.getLeft());
            System.out.print(root.getData() + " ");
            inOrder(root.getRight());
        }
    }

    public void inOrderPrint() {
        inOrder(this.root);
    }

    public void change() {
        root.getLeft().setData(89);
    }

    public ArrayList<Integer> arrayOfTree (Node root, ArrayList<Integer> tree) {
        if (root != null) {
            arrayOfTree(root.getLeft(), tree);
            tree.add(root.getData());
            arrayOfTree(root.getRight(), tree);
        }
        return tree;
    }

    public boolean checkBinarySearchTree() {
        ArrayList<Integer> tree = new ArrayList<Integer>();
        arrayOfTree(this.root, tree);
        for (int i = 0; i < tree.size() - 1; i++) {
            if (tree.get(i) > tree.get(i + 1))
                return false;
        }
        return true;
    }

    public ArrayList<Integer> arrayOfLevels(Node root, int level, ArrayList<Integer> levels) {
        if (root != null) {
            arrayOfLevels(root.getRight(), level + 1, levels);

            for (int i = levels.size(); i <= level; i++) {
                levels.add(0);
            }
            levels.set(level, levels.get(level) + root.getData());

            arrayOfLevels(root.getLeft(), level + 1, levels);
        }

        return levels;
    }

    public boolean checkLevels() {
        ArrayList<Integer> levels = new ArrayList<Integer>(10);
        arrayOfLevels(this.root, 0, levels);
        for (int i = 0; i < levels.size() - 1; i++) {
            if (levels.get(i) >= levels.get(i + 1))
                return false;
        }
        return true;
    }

    public void detourInWidth() {
        width(this.root);
    }

    public void width (Node root) {
        Queue<Node> q = new LinkedList<Node>();
        q.add(root);
        Node x;
        int i = 1;
        while (!q.isEmpty()) {
            x = q.poll();
            System.out.println(x.getData());
            if (x.getLeft() != null){
                q.add(x.getLeft());
                i++;
            }
            if (x.getRight() != null){
                q.add(x.getRight());
                i++;
            }

        }
    }
}
