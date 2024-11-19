import java.util.Scanner;

class InvalidNumber extends Exception {
    public InvalidNumber(String message) {
        super(message);
    }
}

class MathFunctions {
    public float getMean(int[] numbers) throws InvalidNumber {
        float sum = 0;
        for (int num : numbers) {
            if (num < 0 || num > 100) {
                throw new InvalidNumber("Number " + num + " is out of range (0-100).");
            }
            sum += num;
        }
        return sum / numbers.length;
    }

    public float divideNum(int num1, int num2) throws ArithmeticException {
        if (num2 == 0) {
            throw new ArithmeticException("Cannot divide by zero.");
        }
        return (float) num1 / num2;
    }
}

public class maths {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MathFunctions mathFunctions = new MathFunctions();

        try {
            System.out.println("Choose an operation: ");
            System.out.println("1. Calculate Mean");
            System.out.println("2. Perform Division");
            int choice = scanner.nextInt();

            if (choice == 1) {
                System.out.println("Enter the number of elements in the array:");
                int n = scanner.nextInt();
                int[] numbers = new int[n];
                System.out.println("Enter the array elements:");
                for (int i = 0; i < n; i++) {
                    numbers[i] = scanner.nextInt();
                }
                float mean = mathFunctions.getMean(numbers);
                System.out.println("The mean of the array is: " + mean);
            } else if (choice == 2) {
                System.out.println("Enter the numerator:");
                int num1 = scanner.nextInt();
                System.out.println("Enter the denominator:");
                int num2 = scanner.nextInt();
                
                float result = mathFunctions.divideNum(num1, num2);
                System.out.println("Result of division: " + result);
            } else {
                System.out.println("Invalid choice.");
            }
        } catch (InvalidNumber ex) {
            System.out.println("Error: " + ex.getMessage());
        } catch (ArithmeticException ex) {
            System.out.println("Error: " + ex.getMessage());
        } catch (Exception ex) {
            System.out.println("An unexpected error occurred: " + ex.getMessage());
        } finally {
            scanner.close();
        }
    }
}
