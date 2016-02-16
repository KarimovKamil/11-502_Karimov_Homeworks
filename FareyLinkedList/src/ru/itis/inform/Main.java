package ru.itis.inform;

public class Main {
    public static void main(String[] args) {
        FareySequenceGenerator sequence = new FareySequenceGenerator(5);
        sequence.generate();
        sequence.show();
    }
}
