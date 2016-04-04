package ru.itis.inform;

import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        LinkedList<Konj> adnf;
        String s1 = "x1&-x2Vx3&x4&x5";
        String s2 = "x3&x4&x5V-x1&x3Vx1&x2&x4&x5";
        DNF dnf1 = new DNF(s1);
        DNF dnf2 = new DNF(s2);
        adnf = dnf1.getDnf();
        System.out.println("  Вывод ДНФ в виде двумерной матрицы:");
        for (int i = 0; i < adnf.size(); i++) {
            for (int j = 0; j < adnf.get(i).getSize(); j++) {
                System.out.print(adnf.get(i).getKonj().get(j) + " ");
            }
            System.out.println();
        }
        System.out.println();
        System.out.println("  Вывод первой и второй ДНФ:");
        System.out.println(dnf1.toString() + "     " + dnf2.toString());

        dnf1 = dnf1.disj(dnf2);
        dnf1.SortByLength();
        System.out.println();
        System.out.println("  Вывод упорядоченной днф, полученной в результате дизъюнкции 2 ДНФ:");
        System.out.println(dnf1.toString());

        boolean[] value = {true, false, true, true, true};
        System.out.println();
        System.out.println("  Значени ДНФ на наборе v:");
        System.out.println(dnf1.value(value));

        dnf1 = dnf1.dnfWith(6);
        System.out.println();
        System.out.println("  Новая Днф, в которой все конъюнкции содержат x6:");
        System.out.println(dnf1.toString());
        System.out.println(dnf1.getSdnf());
    }
}
