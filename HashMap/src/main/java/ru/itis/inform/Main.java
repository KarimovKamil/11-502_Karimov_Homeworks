package ru.itis.inform;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random rd = new Random();
        HashMap hm = new HashMap();
        String check = "";
        for (int i = 0; i < 20; i++) {
            String s = "";
            int size = rd.nextInt(5) + 5;
            for (int j = 0; j < size; j++) {
                s += (char) (rd.nextInt(25) + 97);
            }
            if (i == 10) {
                check = s;
            }
            hm.add(s, rd.nextInt(100));
        }

        hm.show();
        System.out.println();
        System.out.println(check + "(" + hm.get(check) + ")");
    }
}




/*   hm.add("sadsdas", 12);
        hm.add("sau", 45);
        hm.add("kiyww", 31);
        hm.add("saasdas", 112);
        hm.add("sadw", 25);
        hm.add("oiuy", 4);
        hm.add("krow", 11);
        hm.add("bnmtt", 87);
        hm.add("uyyerr", 63);
        hm.add("poyumm", 76);
        hm.add("ijuwen", 67);
        hm.add("sssss", 10);
        hm.add("polgf", 99);
        hm.add("riiissa", 81);
        hm.add("aaaawww", 69);
        hm.add("wawaaa", 65);
        hm.add("jkkwww", 91);
        */
