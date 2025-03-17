package Task2;
import java.util.Scanner;

public class CelsiusToFahrenheit {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter temperature in Celcius: ");
        double celsius = scanner.nextDouble();
        double fahrenheit = (celslius * 9/5) + 32;
        System.out.println("Temperature in Fahrenheit is: " + fahrenheit);
        scanner.close();
    }
}
