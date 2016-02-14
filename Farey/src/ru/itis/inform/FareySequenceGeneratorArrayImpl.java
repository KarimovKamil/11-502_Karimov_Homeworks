package ru.itis.inform;

public class FareySequenceGeneratorArrayImpl {
    private RationalNumber[] array;
    private int length;
    private int currentLength = 0;

    private final int DEFAULT_LENGTH = 10;
    private final int DEFAULT_ARRAY_LENGTH = 100;

    public FareySequenceGeneratorArrayImpl(int length, int arrayLength) {
        initFareySequenceGeneratorArrayImpl(length, arrayLength);
    }

    public FareySequenceGeneratorArrayImpl() {
        initFareySequenceGeneratorArrayImpl(DEFAULT_LENGTH, DEFAULT_ARRAY_LENGTH);
    }

    private void initFareySequenceGeneratorArrayImpl(int length, int arrayLength){
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

    public void checkElement(int i, int iterationNumber) {
        if(array[i + 1] != null) {
            if(array[i].getQ() + array[i + 1].getQ() == iterationNumber) {
                shift(i + 1);
                array[i + 1] = generateNumber(i);
                currentLength++;
            }
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
            while(j != currentLength) {
                checkElement(j, i);
                j++;
            }
        }
    }

    public void show(){
       for(int i = 0; i < currentLength; i++) {
           if ((i + 1) % 7 == 0) {
               System.out.println();
           }
           System.out.print(array[i].getP() + "/" + array[i].getQ() + ", ");
       }
    }

}
