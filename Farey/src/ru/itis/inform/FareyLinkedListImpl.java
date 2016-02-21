package ru.itis.inform;

import LinkedList.*;

public class FareyLinkedListImpl {
    private LinkedList<RationalNumber> list;
    private int length;
    private int currentLength = 2;

    private final int DEFAULT_LENGTH = 6;

    public FareyLinkedListImpl(int length) {
        initFareyLinkedListImpl(length);
    }

    public FareyLinkedListImpl() {
        initFareyLinkedListImpl(DEFAULT_LENGTH);
    }

    private void initFareyLinkedListImpl(int length) {
        this.length = length;
        this.list = new LinkedList<RationalNumber>();
        this.list.add(new RationalNumber(1, 1));
        this.list.add(new RationalNumber(0, 1));
    }

    public void generate() {
        int i = 2;

        while(i <= length) {
            Iterator<RationalNumber> it = list.iterator();
            it.next();
            while (it.hasNext()) {
                RationalNumber currentValue = it.previous();
                RationalNumber previousValue = it.next();
                if (currentValue.getQ() + previousValue.getQ() == i) {
                    int numerator = currentValue.getP() + previousValue.getP();
                    it.insert(new RationalNumber(numerator, i));
                    previousValue = it.peekPrevious();
                    currentLength++;
                }
                it.next();
            }
            i++;
        }
    }

    public RationalNumber[] toArray() {
        RationalNumber[] array = new RationalNumber[currentLength];
        Iterator<RationalNumber> it = list.iterator();

        int i = 0;
        while(it.hasNext()) {
            array[i] = it.next();
            i++;
        }
        return array;
    }

    public void show() {
        Iterator<RationalNumber> it = list.iterator();
        while(it.hasNext()) {
            System.out.print(it.next() + ", ");
        }
        System.out.println();
    }
}
