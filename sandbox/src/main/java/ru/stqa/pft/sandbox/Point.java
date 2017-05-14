package ru.stqa.pft.sandbox;


public class Point {
    public double x;
    public double y;
    public Point(double x, double y){
        this.x=x;
        this.y=y;
    }

    public  double distance( Point p) {
        return Math.sqrt((this.x - p.x) * (this.x - p.x) + (this.y - p.y) * (this.y - p.y));

    }
}
