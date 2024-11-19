import shape.Square;
import shape.Rectangle;

public class main {
    public static void main(String[] args) {
        // Creating an object of Square with side 4.0
        Square square = new Square(4.0f);
        square.calcArea();
        square.calcPeri();
        square.display();

        // Creating an object of Rectangle with length 5 and breadth 3
        Rectangle rectangle = new Rectangle(5, 3);
        rectangle.calcArea();
        rectangle.calcPeri();
        rectangle.display();
    }
}