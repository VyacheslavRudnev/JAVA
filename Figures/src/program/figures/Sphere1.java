package program.figures;

import java.awt.*;

public class Sphere1 extends Circle1 {
    public Sphere1() {
    }

    public Sphere1(int x, int y, double radius) {
        super(x, y, radius);
    }

    @Override
    public double area() {
        return 4 * Math.PI * Math.pow(radius, 2);
    }

    @Override
    public double perimeter() {
        return (4.0 / 3.0) * Math.PI * Math.pow(radius, 3);
    }

    @Override
    public String toString() {
        return "Sphere1{" +
                "radius=" + radius +
                ", x=" + x +
                ", y=" + y +
                '}';
    }
}
