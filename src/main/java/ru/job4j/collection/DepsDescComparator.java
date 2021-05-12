package ru.job4j.collection;

import java.util.Comparator;

public class DepsDescComparator implements Comparator<String> {

    @Override
    public int compare(String s1, String s2) {
        String s1trim = s1.split("/")[0];
        String s2trim = s2.split("/")[0];
        int rsl = s2trim.compareTo(s1trim);
        return rsl == 0 ? s1.compareTo(s2) : rsl;
    }
}
