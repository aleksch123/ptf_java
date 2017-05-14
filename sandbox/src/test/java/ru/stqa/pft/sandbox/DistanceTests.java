package ru.stqa.pft.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by Алексей on 14.05.2017.
 */
public class DistanceTests {
    @Test
    public void testDistance(){
        Point p1= new Point(10,5);
        Point p2= new Point(5,5);
        Assert.assertEquals(p1.distance(p2), 5.0);
    }
    @Test
    public void testDistance1(){
        Point p1= new Point(10,5);
        Point p2= new Point(5,10);
        Assert.assertEquals(p1.distance(p2), 7.0710678118654755);
    }
    @Test
    public void testDistance2(){
        Point p1= new Point(-10,5);
        Point p2= new Point(-5,10);
        Assert.assertEquals(p1.distance(p2), 7.0710678118654755);
    }

    @Test
    public void testDistance3(){
        Point p1= new Point(-10,-5);
        Point p2= new Point(5,10);
        Assert.assertEquals(p1.distance(p2), 21.213203435596427);
    }
}
