package ru.itis.inform;

public class FareySequenceGenerator {
    private LinkedList list;
    private int length;

    private final int DEFAULT_LENGTH = 10;

    public FareySequenceGenerator(int length) {
        initFareySequenceGenerator(length);
    }

    public FareySequenceGenerator() {
        initFareySequenceGenerator(DEFAULT_LENGTH);
    }

    private void initFareySequenceGenerator(int length) {
        this.length = length;
        this.list = new LinkedList();
        this.list.add(new RationalNumber(0, 1));
        this.list.add(new RationalNumber(1, 1));
    }

    public void generate() {
        for(int i = 2; i <= length; i++) {
            Node node = list.getFirst();
            do {
                if(node.getValue().getQ() + node.getNext().getValue().getQ() == i) {
                    int num = node.getValue().getP() + node.getNext().getValue().getP();
                    Node newNode = new Node(new RationalNumber(num, i));
                    newNode.setNext(node.getNext());
                    node.setNext(newNode);
                }
                node = node.getNext();
            } while(node.getNext() != null);
        }
    }

    public void show() {
        list.show();
    }
}
