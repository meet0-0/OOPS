import java.io.*;
import java.util.Scanner;

class CustomException extends Exception {
    public CustomException(String message) {
        super(message);
    }
}

class Student implements Serializable {
    private int rollNumber;
    private String name;
    private int age;
    private String address;

    public Student(int rollNumber, String name, int age, String address) {
        this.rollNumber = rollNumber;
        this.name = name;
        this.age = age;
        this.address = address;
    }

    @Override
    public String toString() {
        return "Roll Number: " + rollNumber + ", Name: " + name + ", Age: " + age + ", Address: " + address;
    }
}

public class StudentRecords {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in); ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("students.dat", true))) {
            while (true) {
                System.out.print("Enter Roll Number: ");
                int rollNumber = getValidIntInput(scanner);

                System.out.print("Enter Name: ");
                String name = scanner.nextLine();
                checkEmptyField(name, "Name");

                System.out.print("Enter Age: ");
                int age = getValidIntInput(scanner);

                System.out.print("Enter Address: ");
                String address = scanner.nextLine();
                checkEmptyField(address, "Address");

                Student student = new Student(rollNumber, name, age, address);

                System.out.print("Would you like to save the record? (yes/no): ");
                String saveOption = scanner.nextLine();
                if (saveOption.equalsIgnoreCase("yes")) {
                    oos.writeObject(student);
                    System.out.println("Record saved successfully!");
                } else {
                    System.out.println("Record not saved.");
                }

                System.out.print("Would you like to add another record? (yes/no): ");
                String addMore = scanner.nextLine();
                if (!addMore.equalsIgnoreCase("yes")) break;
            }
        } catch (IOException | CustomException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static int getValidIntInput(Scanner scanner) {
        while (true) {
            try {
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.print("Invalid input. Please enter a numeric value: ");
            }
        }
    }

    private static void checkEmptyField(String field, String fieldName) throws CustomException {
        if (field.isBlank()) {
            throw new CustomException(fieldName + " cannot be empty.");
        }
    }
}
