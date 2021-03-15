package ru.job4j.oop;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

public class PointTest {

    @Test
    public void when00to20Then2() {
        double expected = 2;
        int x1 = 0;
        int y1 = 0;
        int x2 = 2;
        int y2 = 0;
        int z1 = 0;
        int z2 = 0;
        double out = new Point(x1, y1, z1).distance(new Point(x2, y2, z2));
        Assert.assertEquals(expected, out, 0.01);
    }

    @Test
    public  void  when00to30Then3() {
        double expected = 3;
        int x1 = 0;
        int y1 = 0;
        int x2 = 3;
        int y2 = 0;
        int z1 = 0;
        int z2 = 0;
        double out = new Point(x1, y1, z1).distance(new Point(x2, y2, z2));
        Assert.assertEquals(expected, out, 0.01);
    }

    @Test
    public  void  when11to1010Then127279() {
        double expected = 12.7279;
        int x1 = 1;
        int y1 = 1;
        int x2 = 10;
        int y2 = 10;
        int z1 = 0;
        int z2 = 0;
        double out = new Point(x1, y1, z1).distance(new Point(x2, y2, z2));
        Assert.assertEquals(expected, out, 0.01);
    }

    @Test
    public  void  when02To02To02Then346() {
        double expected = 3.464;
        int x1 = 0;
        int y1 = 0;
        int x2 = 2;
        int y2 = 2;
        int z1 = 0;
        int z2 = 2;
        double out = new Point(x1, y1, z1).distance3d(new Point(x2, y2, z2));
        Assert.assertEquals(expected, out, 0.01);
    }
}