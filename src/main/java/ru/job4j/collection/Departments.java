package ru.job4j.collection;

import java.util.*;

public class Departments {
    public static List<String> fillGaps(List<String> deps) {
        Set<String> tmp = new LinkedHashSet<>();
        for (String value : deps) {
            String start = "";
            for (String el : value.split("/")) {
                tmp.add(start + el);
                start += el + "/";
            }
        }
        return new ArrayList<>(tmp);
    }

    public static void sortAsc(List<String> orgs) {
        Collections.sort(orgs);
    }

    public static void sortDesc(List<String> orgs) {
        orgs.sort(new DepsDesc().thenComparing(new DepsAsc()));
    }

    public static class DepsDesc implements Comparator<String> {

        @Override
        public int compare(String s1, String s2) {
            s1 = s1.split("/")[0];
            s2 = s2.split("/")[0];
            return s2.compareTo(s1);
        }
    }

    public static class DepsAsc implements Comparator<String> {

        @Override
        public int compare(String s1, String s2) {
            return s1.compareTo(s2);
        }
    }
}
