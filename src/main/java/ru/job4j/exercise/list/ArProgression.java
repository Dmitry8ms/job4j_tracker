package ru.job4j.exercise.list;

import java.util.List;

public class ArProgression {
    public static int checkData(List<Integer> data) {
        Integer rsl = data.get(0) + data.get(data.size() - 1);
        for (int i = 1; i < data.size() - 1; i++) {
            if ((data.get(i - 1) + data.get(i + 1)) / 2 != data.get(i)) {
                return 0;
            }
            rsl += data.get(i);
        }
        return rsl;
    }
}
