package ru.job4j.stream;

import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class EasyStream {
    private Stream stream;

    public Stream getStream() {
        return stream;
    }

    public void setStream(Stream stream) {
        this.stream = stream;
    }

    public static EasyStream of(List<Integer> source) {
        //throw new UnsupportedOperationException();
        var myStream = new EasyStream();
        if (source != null) {
            myStream.setStream(source.stream());
        } else {
            myStream.setStream(Stream.of());
        }
        return myStream;
    }

    public EasyStream map(Function<Integer, Integer> fun) {
        //throw new UnsupportedOperationException();
        this.setStream(this.getStream().map(fun));
        return this;
    }

    public EasyStream filter(Predicate<Integer> fun) {
        //throw new UnsupportedOperationException();
        this.setStream(this.getStream().filter(fun));
        return this;
    }

    public List<Integer> collect() {
        //throw new UnsupportedOperationException();
        return (List<Integer>) this.getStream().collect(Collectors.toList());
    }
}