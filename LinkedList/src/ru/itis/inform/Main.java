package ru.itis.inform;

public class Main {
    public static void main(String[] args) {

        LinkedList list = new LinkedList();

        for(int i = 0; i < 10; i++){
            list.add(i+1);
        }

        list.remove(5);

        list.show();
    }
}
