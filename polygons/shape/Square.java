// Square.java
package shape;

public class Square implements Polygon {
    private float side;
    private float area;
    private float perimeter;

    // Constructor to initialize side of the square
    public Square(float s) {
        this.side = s;
    }

    // Method to calculate area of square
    @Override
    public void calcArea() {
        area = side * side;
    }

    // Method to calculate perimeter of square
    @Override
    public void calcPeri() {
        perimeter = 4 * side;
    }

    // Method to display area and perimeter
    @Override
    public void display() {
        System.out.println("Square - Side: " + side);
        System.out.println("Area: " + area);
        System.out.println("Perimeter: " + perimeter);
    }
}