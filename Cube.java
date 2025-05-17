package DrawableProject;

public class Cube extends ThreeDShape {
    private double side;

    public Cube(double side) {
        this.side = side;

    }
    public Cube(String color, double side) {
        super(color);
        this.side = side;
    }


    @Override
    public String howToDraw() {
        return "Draw a cube with side " + side;
    }

    @Override
    public double getArea() {
        return 6 * side * side;
    }

    @Override
    public double getPerimeter() {
        return 12 * side;
    }

    @Override
    public double getVolume() {
        return side * side * side;
    }


    public double getSide() {
        return side;
    }

    public void setSide(double side) {
        this.side = side;
    }

    @Override
    public String toString() {
        return "Cube [side=" + side + ", color=" + getColor() + "]";
    }
}
