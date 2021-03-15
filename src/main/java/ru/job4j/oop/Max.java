package ru.job4j.oop;

public class Max {
    public static int max(int left, int right) {
        boolean condition = left >= right;
        int result = condition ? left : right;
        return result;
    }

    public static int max(int one, int two, int three) {
        int temp = one >= two ? one : two;
        return max(temp, three);
    }

    public static int max(int one, int two, int three, int four) {
        int temp = max(one, two, three);
        return max(temp, four);
    }
}
