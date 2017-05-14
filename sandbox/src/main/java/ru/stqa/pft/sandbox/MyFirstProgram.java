package ru.stqa.pft.sandbox;

public class MyFirstProgram {     //Задание №1 Попытка

    public static void main(String[] args) {

        Point p1= new Point(10,5);
        Point p2= new Point(5,10);
        System.out.println("Расстояние между точкой P1("+p1.x+", "+p1.y+
                ") и точкой P2("+p2.x+", "+p2.y+") = "+p1.distance(p2));
    }


}
