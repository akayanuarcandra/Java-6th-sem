package Task2;
import java.util.Scanner;

public class Circle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            try {
                System.out.println("Input radius: ");
                double rad = scanner.nextDouble();
                System.out.println("Circumference of circle is: " + (Math.PI * rad * 2));
                System.out.println("Area of circle is: " + (Math.PI * rad * rad));
                break; // Exit the loop if input is valid
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next(); // Clear the invalid input
            }
        }
        scanner.close();
    }
}