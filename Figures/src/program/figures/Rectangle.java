package program.figures;

public class Rectangle extends Point {

    protected int width;
    protected int height;

    public Rectangle() {
        super();
    }

    public Rectangle(int x, int y, int width, int height) {
        super(x, y);//ліва верхня точка прямокутника
        this.width = width;
        this.height = height;
    }

    @Override
    public double area() {
        return width * height;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    @Override
    public String toString() {
        return "Rectangle{" +
                "width=" + width +
                ", height=" + height +
                ", y=" + y +
                ", x=" + x +
                '}';
    }
}
