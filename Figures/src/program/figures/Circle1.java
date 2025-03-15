package program.figures;

public class Circle1 extends Point1 implements Geometry{
    protected double radius;

    public Circle1() {
        this.radius = 0.0;
    }

    public Circle1(int x, int y, double radius) {
        super(x, y);
        this.radius = radius;
    }

    @Override
    public double area() {
        return Math.PI*Math.pow(radius, 2);
    }

    @Override
    public double perimeter() {
        return 2*Math.PI*radius;
    }

    @Override
    public String toString() {
        return "Circle1{" +
                "radius=" + radius +
                ", x=" + x +
                ", y=" + y +
                '}';
    }
}
