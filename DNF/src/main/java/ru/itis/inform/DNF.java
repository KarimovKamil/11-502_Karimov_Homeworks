package ru.itis.inform;

import java.util.LinkedList;

public class DNF {
    LinkedList<Konj> dnf = new LinkedList<Konj>();
    String sdnf;

    public String getSdnf() {
        return sdnf;
    }

    private void setSdnf(String sdnf) {
        this.sdnf = sdnf;
    }

    public LinkedList<Konj> getDnf() {
        return dnf;
    }

    public DNF (String s) {
        sdnf = s;
        dnf.add(new Konj());
        char ch;
        int number = 0;
        int negation = 1;
        for (int i = 0; i < s.length(); i++) {
            ch = s.charAt(i);
            if (ch == 'V') {
                dnf.add(new Konj());
                number++;
                negation = 1;
            }
            else
                if (ch == '&')
                    negation = 1;
                else
                    if (ch == '-')
                        negation = -1;
                    else
                        if ((int) ch > 48 && (int) ch < 54)
                            dnf.get(number).addToKonj(((int) ch - 48)*negation);
        }
    }

    public String toString() {
        String strDNF = "";
        strDNF += dnf.get(0).toString();
        for (int i = 1; i < dnf.size(); i++) {
            strDNF += 'V' + dnf.get(i).toString();
        }
        return strDNF;
    }

    public void insert (Konj konj) {
        if (!content(konj))
            dnf.add(konj);
        sdnf += konj.toString();
    }

    public DNF disj (DNF d) {
        DNF newDnf = new DNF(sdnf);
        for (int i = 0; i < d.getDnf().size(); i++) {
            if (!content(d.getDnf().get(i))) {
                newDnf.getDnf().add(d.getDnf().get(i));
                newDnf.setSdnf(newDnf.getSdnf() + 'V' + d.getDnf().get(i).toString());
            }
        }
        return newDnf;
    }

    public boolean content (Konj konj) {
        for (int i = 0; i < dnf.size(); i++) {
            int j = 0;
            if (konj.getSize() == dnf.get(i).getSize()) {
                while (konj.getKonj().get(j) == dnf.get(i).getKonj().get(j)) {
                    j++;
                    if (j == konj.getSize())
                        return true;
                }
            }
        }
        return false;
    }

    public boolean value (boolean[] v) {
        for (int i = 0; i < dnf.size(); i++) {
            int equally = 0;
            int size = dnf.get(i).getSize();
            for (int j = 0; j < size; j++) {
                if (dnf.get(i).getKonj().get(j) > 0 && v[Math.abs(dnf.get(i).getKonj().get(j)) + 1]
                        || dnf.get(i).getKonj().get(j) < 0 && !v[Math.abs(dnf.get(i).getKonj().get(j)) + 1])
                    equally++;
            }
            if (equally == size)
                return true;
        }
        return false;
    }

    public DNF dnfWith (int i) {
        DNF d = new DNF(sdnf);
        for (int j = 0; j < d.getDnf().size(); j++) {
            boolean content = false;
            for (int k = 0; k < d.getDnf().get(j).getSize(); k++) {
                if (i == Math.abs(d.getDnf().get(j).getKonj().get(k)))
                    content = true;
            }
            if (!content)
                d.getDnf().get(j).addToKonj(i);
        }
        d.setSdnf(d.toString());
        return d;
    }

    public void SortByLength() {
        LinkedList<Konj> newDnf = new LinkedList<Konj>();
        for (int i = 1; i < 5; i++) {
            for (int j = 0; j < dnf.size(); j++) {
                if (dnf.get(j).getSize() == i)
                    newDnf.add(dnf.get(j));
            }
        }
        dnf = newDnf;
    }
}
