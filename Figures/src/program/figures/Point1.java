package program.figures;

public abstract class Point1 {
    protected int x;
    protected int y;

    public Point1(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Point1() {
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}

