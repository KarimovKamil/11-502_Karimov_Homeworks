package ru.itis.inform;

public class Main {
    public static void main(String[] args) {
        FareyArrayImpl sequence = new FareyArrayImpl(3, 6);

        sequence.generate();

        sequence.show();
    }
}
