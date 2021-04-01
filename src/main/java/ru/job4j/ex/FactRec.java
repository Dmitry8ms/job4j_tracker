package ru.job4j.ex;

public class FactRec {
    public static int calc(int n) {
        int m = n - 1;
        if (m == 1 || m == 0) {
            return 1;
        }
        return calc(m) * n;
    }

    public static void main(String[] args) {
        int rsl = calc(6);
        System.out.println(rsl);
    }
}
