package ru.itis.inform;

public class Main {
    public static void main(String[] args) {
        FareySequenceGeneratorArrayImpl sequence = new FareySequenceGeneratorArrayImpl();
        sequence.generate();
        sequence.show();
    }
}
