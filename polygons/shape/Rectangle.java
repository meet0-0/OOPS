package shape;

public class Rectangle implements Polygon {
    private int length;
    private int breadth;
    private float area;
    private float perimeter;

    // Constructor to initialize length and breadth of rectangle
    public Rectangle(int len, int bre) {
        this.length = len;
        this.breadth = bre;
    }

    // Method to calculate area of rectangle
    @Override
    public void calcArea() {
        area = length * breadth;
    }

    // Method to calculate perimeter of rectangle
    @Override
    public void calcPeri() {
        perimeter = 2 * (length + breadth);
    }

    // Method to display area and perimeter
    @Override
    public void display() {
        System.out.println("Rectangle - Length: " + length + ", Breadth: " + breadth);
        System.out.println("Area: " + area);
        System.out.println("Perimeter: " + perimeter);
    }
}