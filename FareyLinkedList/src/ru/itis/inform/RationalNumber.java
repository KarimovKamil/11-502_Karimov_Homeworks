package ru.itis.inform;

public class RationalNumber {
    private int p;
    private int q;

    public RationalNumber(int p, int q) {
        this.p = p;
        if (q != 0) {
            this.q = q;
        } else throw new IllegalArgumentException();
    }

    public int getP() {
        return p;
    }

    public int getQ() {
        return q;
    }

    public void print() {
        System.out.print(p + "/" + q + ", ");
    }
}
