package ru.itis.inform;

public class Human {
    private String name;
    private int age;

    public Human(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return this.name + " " + this.age;
    }

    @Override
    public boolean equals(Object another) {
        if (another == null) return false;
        if (another == this) return true;
        if (!(another instanceof Human)) return false;

        Human anotherHuman = (Human) another;
        if (anotherHuman.toString().equals(this.toString()))
            return true;
        else
            return false;
    }
}
