package program.figures;

public class Rectangle1 extends Point1 implements Geometry {
    protected int width;
    protected int height;

    public Rectangle1(int x, int y, int width, int height) {
        super(x, y);
        this.width = width;
        this.height = height;
    }
    public Rectangle1() {
        this.width = 0;
        this.height = 0;
    }

    @Override
    public String toString() {
        return "Rectangle1{" +
                "width=" + width +
                ", height=" + height +
                ", x=" + x +
                ", y=" + y +
                '}';
    }

    @Override
    public double area() {
        return width * height;
    }

    @Override
    public double perimeter() {
        return (width + height) * 2;
    }
}
