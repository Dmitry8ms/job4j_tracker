package ru.job4j.exercise.stream;

import java.util.Arrays;

/* Как вы уже знаете. Есть стримы примитивов IntStream, LongStream, DoubleStream. Обратите
внимание, что это всё примитивы чисел, а к числам применимы арифметические операции, поэтому в
этих стримах есть терминальные операции min(), max(), sum(), average().
min(), max() возвращают OptionalInt, для получения элемента нужно использовать метод getAsInt()
average() возвращает OptionalDouble, для получения элемента нужно использовать метод getAsDouble()
Ваша задача дописать методы. Для получения стрима нужно использовать Arrays.stream() */

public class TerminalForPrimitive {
    private int[] data;

    public TerminalForPrimitive(int[] data) {
        this.data = data;
    }

    public long count() {
        return Arrays.stream(data).count();
    }

    public long max() {
        return Arrays.stream(data).asLongStream().max().getAsLong();
    }

    public long min() {
        return Arrays.stream(data).asLongStream().min().getAsLong();
    }

    public double avg() {
        return Arrays.stream(data).asDoubleStream().average().getAsDouble();
    }

    public long sum() {
        return Arrays.stream(data).asLongStream().sum();
    }

}
