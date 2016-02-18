package ru.itis.inform;

public class FareyArrayImpl {
    private RationalNumber[] array;
    private int length;
    private int currentLength = 0;

    private final int DEFAULT_LENGTH = 10;
    private final int DEFAULT_ARRAY_LENGTH = 100;

    public FareyArrayImpl(int length, int arrayLength) {
        initFareyArrayImpl(length, arrayLength);
    }

    public FareyArrayImpl() {
        initFareyArrayImpl(DEFAULT_LENGTH, DEFAULT_ARRAY_LENGTH);
    }

    private void initFareyArrayImpl(int length, int arrayLength){
        this.length = length;
        this.array = new RationalNumber[arrayLength];
        this.array[0] = new RationalNumber(0, 1);
        this.array[1] = new RationalNumber(1, 1);
        this.currentLength = 2;
    }

    public void shift(int start) {
        for(int i = currentLength; i >= start; i--) {
            array[i + 1] = array[i];
        }
    }

    public RationalNumber generateNumber(int number) {
        int p = array[number].getP() + array[number + 1].getP();
        int q = array[number].getQ() + array[number + 1].getQ();
        return new RationalNumber(p, q);
    }

    public void generate() {
        for(int i = 2; i <= length; i++) {
            int j = 0;
            while(j < currentLength) {
                if(array[j + 1] != null && array[j].getQ() + array[j + 1].getQ() == i) {
                    shift(j + 1);
                    array[j + 1] = generateNumber(j);
                    currentLength++;
                }
                j++;
            }
        }
    }

    public void show(){
        for(int i = 0; i < currentLength - 1; i++) {
            System.out.print(array[i].getP() + "/" + array[i].getQ() + ", ");
            if ((i + 1) % 10 == 0) {
                System.out.println();
            }
        }
        System.out.print(array[currentLength - 1].getP() + "/" + array[currentLength - 1].getQ());
    }
}
