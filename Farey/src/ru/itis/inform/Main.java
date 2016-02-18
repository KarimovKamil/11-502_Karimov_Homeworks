package ru.itis.inform;

public class Main {
    public static void main(String[] args) {
        FareyArrayImpl sequence = new FareyArrayImpl();
        sequence.generate();
        sequence.show();
    }
}
