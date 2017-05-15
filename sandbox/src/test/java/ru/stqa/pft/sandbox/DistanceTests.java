package ru.stqa.pft.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by Алексей on 14.05.2017.
 */
public class DistanceTests {
    @Test
    // прямая
    public void testDistance(){
        Point p1= new Point(10,5);
        Point p2= new Point(5,5);
        Assert.assertEquals(p1.distance(p2), 5.0);
    }
    // наклонная
    @Test
    public void testDistance1(){
        Point p1= new Point(10,5);
        Point p2= new Point(5,10);
        Assert.assertEquals(p1.distance(p2), 7.0710678118654755);
    }
    // отрицательные значения
    @Test
    public void testDistance2(){
        Point p1= new Point(-10,5);
        Point p2= new Point(-5,10);
        Assert.assertEquals(p1.distance(p2), 7.0710678118654755);
    }
    // нулевые значения
    @Test
    public void testDistance3(){
        Point p1= new Point(-10,-5);
        Point p2= new Point(0,0);
        Assert.assertEquals(p1.distance(p2), 11.180339887498949);
    }
    // все нулевые значения
    @Test
    public void testDistance4(){
        Point p1= new Point(0,0);
        Point p2= new Point(0,0);
        Assert.assertEquals(p1.distance(p2), 0.0);
    }
}
