package Task2;
import java.util.Scanner;

public class Circle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("input radius: ");
        double rad = scanner.nextDouble();
        System.out.println("Circumstance of circle is: " + (Math.PI * rad * 2));
        System.out.println("Area of circle is: " + (Math.PI * rad * rad));
        scanner.close();
    }
}
