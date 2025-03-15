package program;

import program.figures.*;

public class Main {
    public static void main(String[] args) {
        Rectangle r1 = new Rectangle(100, 100, 100, 200);//створюємо прямокутник
        System.out.println(r1); //виводимо інформацію про прямокутник
        System.out.println("Area = "+ r1.area()); //виводимо площу

        Point[] figures = {
                new Rectangle(100, 100, 100, 200),
                new Rectangle(50, 50, 300, 300)
        };

        double totalArea = 0;
        for(Point item : figures) {
            totalArea += item.area();
        }
        System.out.println("Total area = "+totalArea);
        System.out.println("_________________________________________");

        Geometry[] figures1 = {
                new Rectangle1(100, 100, 100, 200),
                new Rectangle1(50, 50, 300, 300),
        };

        System.out.println("_____ HW-01________");

        Geometry[] figures2 = {
                new Rectangle1(100, 100, 100, 200),
                new Rectangle1(50, 50, 300, 300),
                new Rectangle1(50, 50, 300, 300),
                new Circle1(110,110,100),
                new Circle1(150,150,200),
                new Sphere1(100,100,10),
                new Sphere1(150,150,20),
                new Sphere1(100,150,30),
        };
        double totalArea2 = 0;
        for(Geometry item : figures2) {
            totalArea2 += item.area();
        }

        double totalPerimeter = 0;
        for(Geometry item : figures2) {
            totalPerimeter += item.perimeter();
        }
        System.out.println("Total area = "+totalArea2);
        System.out.println("Total perimeter = "+totalPerimeter);

    }
}