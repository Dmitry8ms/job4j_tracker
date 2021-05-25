package ru.job4j.exercise.map;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class WeatherTest {

    @Test
    public void editData() {
        List<Weather.Info> list = List.of(
                new Weather.Info("Minsk", 25), new Weather.Info("Brest", 5),
                new Weather.Info("Grodna", 33),
                new Weather.Info("Gomel", 26), new Weather.Info("Minsk", 15),
                new Weather.Info(
                        "Vitebsk", 18),
                new Weather.Info("Grodna", 18), new Weather.Info("Brest", 18),
                new Weather.Info("Gomel", 40),
                new Weather.Info("Minsk", 55), new Weather.Info("Vitebsk", 36),
                new Weather.Info("Minsk", 30),
                new Weather.Info("Gomel", 15), new Weather.Info("Grodna", 15),
                new Weather.Info("Brest", 40)
        );
        List<Weather.Info> rsl = Weather.editData(list);
        List<Weather.Info> expected = List.of(
                new Weather.Info("Gomel", 81),
                new Weather.Info("Vitebsk", 54),
                new Weather.Info("Brest", 63),
                new Weather.Info("Grodna", 66),
                new Weather.Info("Minsk", 125)
        );
        assertEquals(rsl, is(expected));
    }
}