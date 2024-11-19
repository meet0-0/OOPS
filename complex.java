/*a. Create a class called complex for performing arithmetic
operations with complex numbers. Use floating point variables to
represent the private data of the class. Provide a default constructor that
initialises the object with some default values. Provide public member
methods for each of the following:
- Addition of two complex numbers: It returns the result obtained by
adding the respective real parts and the imaginary parts of the two
complex numbers. The method must return complex class object.
- Subtraction of two complex numbers: It returns the result obtained
by subtracting the respective real parts and the imaginary parts of
02 2
the two complex numbers. The method must return complex class
object.
- display () – It displays the complex number in a+bi format.
The output should be displayed as follows: -
Sum of a1+b1 i & a2+b2 i is: a3+b3 i
*/

public class complex {
    private float num1; // Real part
    private float num2; // Imaginary part

    public complex() {  //constructor
        this.num1 = 0.0f;
        this.num2 = 0.0f;
    }

    public complex(float num1, float num2) {
        this.num1 = num1;
        this.num2 = num2;
    }

    public complex add(complex other) {
        float newnum1 = this.num1 + other.num1;
        float newnum2 = this.num2 + other.num2;
        return new complex(newnum1, newnum2);
    }

    public complex subtract(complex other) {
        float newnum1 = this.num1 - other.num1;
        float newnum2 = this.num2 - other.num2;
        return new complex(newnum1, newnum2);
    }

    public void display() {
        System.out.println(num1 + " + " + num2 + "i");
    }

    public static void main(String[] args) {
        complex c1 = new complex(3.5f, 2.5f);
        complex c2 = new complex(1.2f, 4.3f);

        complex sum = c1.add(c2);
        System.out.print("Sum of ");
        c1.display();
        System.out.print(" & ");
        c2.display();
        System.out.print(" is: ");
        sum.display();

        complex difference = c1.subtract(c2);
        System.out.print("Difference of ");
        c1.display();
        System.out.print(" & ");
        c2.display();
        System.out.print(" is: ");
        difference.display();
    }
}