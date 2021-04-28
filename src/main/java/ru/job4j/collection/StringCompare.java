package ru.job4j.collection;

import java.util.Comparator;

public class StringCompare implements Comparator<String> {

    @Override
    public int compare(String s1, String s2) {
        int rsl = 0;
        if (!s1.equals(s2) && s1 != null && s2 != null) {
            for (int i = 0; i < s1.length() && i < s2.length(); i++) {
                rsl = Character.compare(s1.charAt(i), s2.charAt(i));
                if (rsl != 0) {
                    break;
                }
            }
            if (rsl == 0) {
                return Integer.compare(s1.length(), s2.length());
            }
        }

        return rsl;
    }
}
