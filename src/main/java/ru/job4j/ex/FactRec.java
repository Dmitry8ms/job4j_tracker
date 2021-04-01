package ru.job4j.ex;

public class FactRec {
    public static int calc(int n) {
        if (n == 1 || n == 0) {
            return 1;
        }
        int m = n - 1;
        return calc(m) * n;
    }

    public static void main(String[] args) {
        int rsl = calc(2);
        System.out.println(rsl);
    }
}
